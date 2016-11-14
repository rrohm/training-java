/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.meins.clustered.gf.MeineStatefulSessionBeanRemote;

/**
 *
 * @author robert
 */
public class StartServlet extends HttpServlet {


  @EJB
  MeineStatefulSessionBeanRemote meineStatefulSessionBean;
  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      /* TODO output your page here. You may use following sample code. */
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet StartServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet StartServlet at " + request.getContextPath() + "</h1>");

      String infoString = meineStatefulSessionBean.zeigeInstanzInfo();
      out.println("<p>Instanz-Info: "+ infoString + "</p>");



      int c = meineStatefulSessionBean.gibZaehler();
      out.println("<p>Zähler: "+ c + "</p>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
