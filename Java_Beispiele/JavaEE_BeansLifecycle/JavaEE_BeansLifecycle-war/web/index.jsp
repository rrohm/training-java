<%--
    Document   : index
    Created on : 01.11.2012, 06:40:10
    Author     : robert rohm
--%>
<%@page import="org.meins.javaee.beanslifecycle.StatefulSessionBean"%>
<%@page import="javax.naming.NamingEnumeration"%>
<%@page import="javax.naming.NameClassPair"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="org.meins.javaee.beanslifecycle.StatelessSessionBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Beans-Lebenszyklus</h1>
    <h2>Beispiel-Anwendung</h2>
    <p>Diese JavaEE-Anwendung illustriert (ganz knapp) den Einsatz von
      Lebenszyklus-Methoden in EJBs.
    </p>
    <p>Zu diesem Zweck werden in dieser JSP-Seite Instanzen der EJBs erzeugt.
      Bitte achten Sie auf die Konsolenausgabe im Server-Log.
    </p>
    <p>Ausgabe der Stateless EJB: <%

      // Dieses Beispiel zeigt die Verwendung von EJBs direkt in einer JSP-Seite.
      // Dies ist v.a. illustrativ - in realen Anwendungen würden der EJB-Aufruf
      // in Servlets vor JSP-Seiten oder in ManagedBeans für JSF-Seiten
      // eingesetzt werden.
      Context context = new InitialContext();
      // Hier wird der JNDI-Lookup-Name verwendet, den der
      // Application Server beim Deployment der Bean im Log ausgibt:
      StatelessSessionBean slsb = (StatelessSessionBean)context.lookup("java:global/JavaEE_BeansLifecycle/JavaEE_BeansLifecycle-ejb/MeineStatelessSessionBean");

      out.print(slsb.sagHallo("Welt"));
      //*/
    %></p>

  </body>
</html>
