<%-- 
    Document   : gestionReduction
    Created on : 11 mars 2016, 03:54:28
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Reduction"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Réduction</title>
    </head>
    <body>
        <h1 id="h1">Nos réductions STR</h1>

        <TABLE id="tableModif">
            <tr id="trTitre">
                    <th>Type</th>
                    <th>Taux</th>
                    <th>Sélectionner</th>
                </tr>
                <%
                                    Collection<Reduction> coll = (Collection) request.getAttribute("collectionReductions");
                                    for (Reduction r : coll) {%>
                <tr id="trContenu">
                    <td> <%= r.getTypeReduction()%></td>
                    <td> <%= r.getTauxReduction()%></td>
                    <td> <a href="menu?action=formModifierReduction&id=<%=r.getId()%>"><button class="btn_ModSup">Modifier</button></a> 
                         <a href="menu?action=supprimerReduction&id=<%=r.getId()%>"><button class="btn_ModSup">Supprimer</button></a></td>
                </tr>
                <%
                    }
                %>
                </tr>
        </table>  
                <div id="btn_Enre">
        <a href="menu?action=nouvelleReduction"><button id="btn_gauche">Ajouter une réduction</button></a>
                </div>
    </body>
</html>
