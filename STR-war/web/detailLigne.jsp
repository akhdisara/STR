<%-- 
    Document   : detailLigne
    Created on : 9 mars 2016, 01:08:32
    Author     : Sara
--%>

<%@page import="entity.PositionArretLigne"%>
<%@page import="entity.LigneSTR"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Ligne</title>
    </head>
    <%
        LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");
    %>
    <body>
        <h1 id="h1">Ligne > Détail</h1>     
        
        <span id="sDetail">Identifiant : </span><%=ligne.getIdentifiant()%> <br>
        <span id="sDetail">Départ : </span><%=ligne.getDebut().getNom()%> <br>
        <span id="sDetail">Arrivée : </span><%=ligne.getFin().getNom()%> <br>
        <br>
        <h1 id="h1">Lignes > Arrêts</h1>
        <div class="text">
        <%
            List<PositionArretLigne> listePos = (List) request.getAttribute("PositionArretLigne");
            for (PositionArretLigne pos : listePos) {%><li>
                <%= pos.getArret().getNom() %><%= pos.getPosition() %><br></li>
        <%}%>
        </div>
    </body>
</html>
