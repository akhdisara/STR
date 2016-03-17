<%-- 
    Document   : nouvelleFicheHoraire
    Created on : 11 mars 2016, 16:29:36
    Author     : 5150796
--%>
<%@page import="entity.PositionArretLigne"%>
<%@page import="entity.LigneSTR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="entity.Periode"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Horaire</title>
    </head>
    <body>
        <h1 id="h1">Nouveau Horaire</h1>
        <% Collection<PositionArretLigne> coll = (Collection) request.getAttribute("PositionsArretLigne");
             LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");%>
             
        <form method="get" action="menu">
            <input type="hidden" name="idLigne" value="<%=ligne.getId()%>"/>     
            <table align="center">
                <tr>
                    <th>Période</th>
                    <th>
                        <select name="periode"> 
                            <%
                                List<Periode> enumListPeriode = (List) request.getAttribute("enumListPeriode");
                                for (Periode p : enumListPeriode) {
                            %>	
                            <option value="<%=p%>"><%=p%></option> 
                            <%}%> </select>
                    </th>
                </tr>
                <% for (PositionArretLigne pos : coll) {%>
                <tr>            
                    <th><%=pos.getArret().getNom()%></th>
                    <th><input type="time" name="horaire<%=pos.getArret().getNom()%>"/></th>
                        <%}%>
                </tr>
            </table>
                <div id="btn_Enre">
            <input type="hidden" name="action" value="ajouterFicheHoraire" />
            <input id="btn_enregistrer" type="submit" value="Ajouter">
            <input id="btn_enregistrer" type="reset" value="Vider">
                </div>
        </form>
    </body>
</html>
