/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.servlets.filters;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class RewriteFilter implements Filter {

  private static final boolean debug = true;

  // The filter configuration object we are associated with.  If
  // this value is null, this filter instance is not currently
  // configured. 
  private FilterConfig filterConfig = null;
  private RewriteConfig config;

  public RewriteFilter() {
  }

  /**
   *
   * @param request The servlet request we are processing
   * @param response The servlet response we are creating
   * @param chain The filter chain we are processing
   *
   * @exception IOException if an input/output error occurs
   * @exception ServletException if a servlet error occurs
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {
    System.out.println("org.meins.servlets.filters.doFilter " + request);
    if (debug) {
      log("RewriteFilter:doFilter()");
    }

    HttpServletRequest req = (HttpServletRequest) request;
    String contextPath = req.getContextPath();
    String pathInfo = req.getPathInfo();
    String queryString = req.getQueryString();
    String servletPath = req.getServletPath();
    System.out.println("contextPath: " + contextPath);
    System.out.println("pathInfo   : " + pathInfo);
    System.out.println("queryString: " + queryString);
    System.out.println("servletPath: " + servletPath);

    for (RewriteMapping mapping : this.config.getMappings()) {
      Pattern pattern = Pattern.compile("(\\{\\w*\\})");
      Matcher matcher = pattern.matcher(mapping.getPattern());
      System.out.println(">>>> Mapping: " + mapping.getPattern());
      
      List<String> params = new ArrayList<>();
      while (matcher.find()) {
        params.add(matcher.group().substring(1,matcher.group().length() -1 ));
        System.out.println("param found: " + matcher.group());
      }

      String pattern2 = matcher.replaceAll("(\\\\w+)") + "{1}";
      System.out.println("pattern2: " + pattern2);
      
      Pattern p = Pattern.compile(pattern2);
      Matcher matcher1 = p.matcher(req.getServletPath());
      if (matcher1.find()) {
        System.out.println("FOUND: " + mapping.getToView());
        
        int paramNr = 1;
        for (String param : params) {
          System.out.printf("param %d: %s = %s", paramNr, param, matcher1.group(paramNr));
          req.setAttribute(param, matcher1.group(paramNr));
          paramNr++;
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(mapping.getToView());
        requestDispatcher.forward(request, response);
        break;
      }
    }
  }

  /**
   * Return the filter configuration object for this filter.
   */
  public FilterConfig getFilterConfig() {
    return (this.filterConfig);
  }

  /**
   * Set the filter configuration object for this filter.
   *
   * @param filterConfig The filter configuration object
   */
  public void setFilterConfig(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  /**
   * Destroy method for this filter
   */
  @Override
  public void destroy() {
  }

  /**
   * Init method for this filter
   */
  @Override
  public void init(FilterConfig filterConfig) {
    System.out.println("REWRITE CONFIGURATION INIT...");
    this.filterConfig = filterConfig;
    if (filterConfig != null) {
      if (debug) {
        log("RewriteFilter:Initializing filter");
      }
    }
    try {
      URL configURL = filterConfig.getServletContext().getResource("/WEB-INF/rewrite-config.xml");
      JAXBContext context = JAXBContext.newInstance(RewriteConfig.class);

      RewriteConfig config = new RewriteConfig();
      config.getMappings().add(new RewriteMapping("/go/{id}", "page1.xhtml"));
      config.getMappings().add(new RewriteMapping("/find/{id}", "page2.xhtml"));
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      marshaller.marshal(config, new File("/tmp/rewrite.config.xml"));

      Unmarshaller unmarshaller = context.createUnmarshaller();
      RewriteConfig unmarshal = (RewriteConfig) unmarshaller.unmarshal(configURL);

      this.config = unmarshal;

      System.out.println("REWRITE: " + unmarshal.getMappings().size());

    } catch (MalformedURLException ex) {
      System.err.println("REWRITE CONFIGURATION MISSING!!!");
      Logger.getLogger(RewriteFilter.class.getName()).log(Level.SEVERE, null, ex);
    } catch (JAXBException ex) {
      Logger.getLogger(RewriteFilter.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * Return a String representation of this object.
   */
  @Override
  public String toString() {
    if (filterConfig == null) {
      return ("RewriteFilter()");
    }
    StringBuffer sb = new StringBuffer("RewriteFilter(");
    sb.append(filterConfig);
    sb.append(")");
    return (sb.toString());
  }

  private void sendProcessingError(Throwable t, ServletResponse response) {
    String stackTrace = getStackTrace(t);

    if (stackTrace != null && !stackTrace.equals("")) {
      try {
        response.setContentType("text/html");
        PrintStream ps = new PrintStream(response.getOutputStream());
        PrintWriter pw = new PrintWriter(ps);
        pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

        // PENDING! Localize this for next official release
        pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
        pw.print(stackTrace);
        pw.print("</pre></body>\n</html>"); //NOI18N
        pw.close();
        ps.close();
        response.getOutputStream().close();
      } catch (Exception ex) {
      }
    } else {
      try {
        PrintStream ps = new PrintStream(response.getOutputStream());
        t.printStackTrace(ps);
        ps.close();
        response.getOutputStream().close();
      } catch (Exception ex) {
      }
    }
  }

  public static String getStackTrace(Throwable t) {
    String stackTrace = null;
    try {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      t.printStackTrace(pw);
      pw.close();
      sw.close();
      stackTrace = sw.getBuffer().toString();
    } catch (Exception ex) {
    }
    return stackTrace;
  }

  public void log(String msg) {
    filterConfig.getServletContext().log(msg);
  }

}
