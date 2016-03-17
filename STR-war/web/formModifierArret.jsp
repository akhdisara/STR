<%-- 
    Document   : modifierLigne
    Created on : 9 mars 2016, 01:27:03
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Arret"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Arrêt</title>
    </head>
    <%
        Arret arret = (Arret) request.getAttribute("arret");
    %>
    <body>
        <h1 id="h1">Arrêt > Modifier</h1>
        <form method="POST" action="menu">
            <label id=sDetail>Nom : </label><input type="text" name="nom" value="<%=arret.getNom() %>"/><br><br>
            <label id=sDetail>Adresse : </label><input type="text" name="adresse" value="<%=arret.getAdresse() %>"/><br>
            
            <div id="btn_ModSup">
            <input type="hidden" name="action" value="modifierArret" />
             <input type="hidden" name="id" value="<%=arret.getId()%>"/>
            <input class="btn_ModSup" type="submit" value="Enregistrer">
            <input class="btn_ModSup" type="reset" value="Vider">
            </div>
        </form>

    </body>
</html>
