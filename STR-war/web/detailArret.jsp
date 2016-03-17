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
        <%@ include file="navigation.jsp" %>
        <title>Détail Arrêt</title>
    </head>
    <%
        Arret arret = (Arret) request.getAttribute("arret");
    %>
    <body>
        <h1 id="h1">Arrêt > Détail</h1>       
        <span id="sDetail">Nom : </span><%=arret.getNom()%> <br><br>
        <span id="sDetail">Adresse : </span><%=arret.getAdresse()%> <br>
        <div id="btn_ModSup">
        <a href="menu?action=formModifierArret&id=<%=arret.getId()%>"><button class="btn_ModSup">Modifier</button></a>
                    
        <a href="menu?action=supprimerArret&id=<%=arret.getId()%>"><button class="btn_ModSup">Supprimer</button></a>
        </div>
    </body>
</html>
