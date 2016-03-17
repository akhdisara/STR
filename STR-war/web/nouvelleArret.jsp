<%-- 
    Document   : nouvelleLigne
    Created on : 9 mars 2016, 00:23:04
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Arret</title>
    
</head>
<body>
    <h1 id="h1">Nouvelle Arrêts</h1>
    
    <form method="get" action="menu">
        <div class='text'>
        Nom <br> <input type="text" name="nom" /><br>
        Adresse <br> <input type="text" name="adresse" /><br><br>
        </div>
        <div id="btn_ModSup">
        <input type="hidden" name="action" value="ajouterArret" />
        <input class="btn_ModSup" type="submit" value="Ajouter">
        <input class="btn_ModSup" type="reset" value="Vider">
        </div>
    </form>
    
</body>
</html>
