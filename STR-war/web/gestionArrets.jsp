<%-- 
    Document   : gestionArrets
    Created on : 9 mars 2016, 10:07:38
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Arret"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Gestion des arrêts</title>
    </head>
    <body>
        <h1>Gestion des arrêts</h1>
        
        <br>
        <TABLE id="tableModif">
            <tr id="trTitre">
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Détail</th>
                </tr>
            <tbody>
                <%
                    Collection<Arret> coll = (Collection) request.getAttribute("collectionArrets");
                    for (Arret a : coll) {%>
                <tr id="trContenu">
                    <td> <%= a.getNom()%></td>
                    <td> <%= a.getAdresse()%></td>
                    <td> <a href="menu?action=detailArret&id=<%=a.getId()%>"><button class="btn_ModSup">---></button></a></td>
                </tr>
                <%
                    }
                %>
                </tr>
            </tbody>
        </table>  
                <div id="btn_Enre">
                <a href="nouvelleArret.jsp"><button id="btn_enregistrer">Ajouter un arrêt</button></a
                </div>
    </body>
</html>
