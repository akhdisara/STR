<%-- 
    Document   : nouvelleReduction
    Created on : 11 mars 2016, 12:51:41
    Author     : 5150796
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.TypeReduction"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Réduction</title>

    </head>
    <body>
        <h1 id="h1">Nouvelle réduction</h1>
        <form method="get" action="menu">
            <span id="sDetail">Type : </span>

            <select name="type"> 

                <%
                    List<TypeReduction> enumListTypeReduction = (List) request.getAttribute("enumListTypeReduction");
                    for (TypeReduction t : enumListTypeReduction) {
                %>	
                <option value="<%=t%>"><%=t%></option> 
                <%}%> </select>
            <br>
            <span id="sDetail">Taux : </span>
            <input type="text" name="taux"/>
            <br>
            <div id="btn_ModSup">
            <input type="hidden" name="action" value="ajouterReduction" />
            <input class="btn_ModSup" type="submit" value="Ajouter">
            <input class="btn_ModSup" type="reset" value="Vider">
            </div>
        </form>
    </body>
</html>
