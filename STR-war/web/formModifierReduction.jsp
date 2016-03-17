<%-- 
    Document   : formModifierReduction
    Created on : 11 mars 2016, 13:07:57
    Author     : 5150796
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Reduction"%>
<%@page import="entity.TypeReduction"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Reduction</title>
    </head>
    <%
        Reduction red = (Reduction) request.getAttribute("reduction");
    %>
    <body>
        <h1 id="h1">Réduction > Modifier</h1>
        <form method="POST" action="menu">
            <label id=sDetail>Type : </label>

            <select name="type"> 
                <%
                    List<TypeReduction> enumListTypeReduction = (List) request.getAttribute("enumListTypeReduction");
                    for (TypeReduction t : enumListTypeReduction) {
                %>	
                <option value="<%=t%>"><%=t%></option> 
                <%}%> </select>
            <br>
            <label id=sDetail>Taux : </label>
            <input type="text" name="taux" value="<%=red.getTauxReduction()%>"/>
            <br>
            <div id="btn_ModSup">
                <input type="hidden" name="action" value="modifierReduction" />
                <input type="hidden" name="id" value="<%=red.getId()%>"/>
                <input class="btn_ModSup" type="submit" value="Enregistrer">
                <input class="btn_ModSup" type="reset" value="Vider">
            </div>
        </form>

    </body>
</html>
