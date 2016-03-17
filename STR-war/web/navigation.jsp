<%-- 
    Document   : Navigation
    Created on : 12 mars 2016, 17:45:35
    Author     : vanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body> 
        <img id="logoMenu" src='image/logo_STR.jpg' alt='Logo'>
        
        <ul id="navigation">
            <li><a id="active" href="menu?action=accueil">Page d'accueil</a></li>
            <li><a href="menu?action=gestionArrets">Gestion des arrêts</a></li>
            <li><a href="menu?action=gestionLignes">Gestion des lignes</a></li>
            <li><a href="menu?action=gestionReduction">Gestion des reductions</a></li>
        </ul>
        <br><br>
    </body>
</html>
