<%-- 
    Document   : Authentification
    Created on : 16 mars 2016, 11:28:00
    Author     : 3099709
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Authentification</title>
    </head>
    <body>
        <div class ="text">
            <%
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </div>
        <form id="form_login" method="get" action="menu">
            <header>Authentification</header>
            <label>Login <span>*</span></label>
            <input type="text" name="login" value="" size="35" maxlength="20"/>
            <label>Mot de passe <span>*</span></label>
            <input type="password" name="password" value="" size="35" maxlength="20"/>

            <input type="hidden" name="action" value="MenuAuthentifier">
            <input id="btn_login" type="submit" value="Se connecter"/>
        </form>
    </body>
</html>
