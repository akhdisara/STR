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
        <title>JSP Page</title>
    
</head>
<body>
    <h1>Nouvelle Arrêts</h1>
    <form method="get" action="menu">
        Nom <br> <input type="text" name="nom" /><br>
        Adresse <br> <input type="text" name="adresse" /><br>
        <input type="hidden" name="action" value="ajouterArret" />
        <input type="submit" value="Ajouter">
        <input type="reset" value="Vider">
    </form>
</body>
</html>
