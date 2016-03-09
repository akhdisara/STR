<%-- 
    Document   : detailLigne
    Created on : 9 mars 2016, 01:08:32
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
        <h1>Détail</h1>       
        Identifiant : <%=ligne.getIdentifiant()%> <br>
        <a href="menu?action=formModifierLigne&id=<%=ligne.getId()%>">Modifier</a>
        <a href="menu?action=supprimerLigne&id=<%=ligne.getId()%>">Supprimer</a>
    </body>
</html>
