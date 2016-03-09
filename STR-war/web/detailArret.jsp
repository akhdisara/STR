<%-- 
    Document   : detailLigne
    Created on : 9 mars 2016, 01:08:32
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Arret"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Arret arret = (Arret) request.getAttribute("arret");
    %>
    <body>
        <h1>Détail</h1>       
        Nom : <%=arret.getNom()%> <br>
        Adresse : <%=arret.getAdresse()%> <br>
        <a href="menu?action=formModifierArret&id=<%=arret.getId()%>">Modifier</a>
        <a href="menu?action=supprimerArret&id=<%=arret.getId()%>">Supprimer</a>
    </body>
</html>
