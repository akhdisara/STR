<%-- 
    Document   : modifierLigne
    Created on : 9 mars 2016, 01:27:03
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Ligne"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Ligne ligne = (Ligne) request.getAttribute("ligne");
    %>
    <body>
        <form method="POST" action="menu">
            Identifiant <br> <input type="text" name="identifiant" value="<%=ligne.getIdentifiant()%>"/><br>
            <input type="hidden" name="id" value="<%=ligne.getId()%>"/>
            <input type="hidden" name="action" value="modifierLigne" />
            <input type="submit" value="Enregistrer">
            <input type="reset" value="Vider">
        </form>

    </body>
</html>
