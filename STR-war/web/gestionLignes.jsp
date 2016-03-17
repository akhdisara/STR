<%-- 
    Document   : gestionLignes
    Created on : 9 mars 2016, 13:19:18
    Author     : 5152683
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.LigneSTR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Ligne</title>
    </head>
    <body>
        <h1 id="h1">Gestion des lignes</h1>
        <div class ="text">
            <form method="POST" action="menu">
                Identifiant :<input type="text" name="id"  placeholder="Rechercher une ligne"/><br>
                <input type="hidden" name="action" value="chercherLigne" />
                <input type="submit" value="Chercher">
            </form>
            <br>
            <% String message = (String) request.getAttribute("message");%>
            <%=message%>
        </div>
        <TABLE id="tableAffich">
            <tr id="trTitre">
                    <th>Identifiant</th>
                    <th>Départ</th>
                    <th>Arrivée</th>
                    <th>Fiche tarifaire</th>
                    <th>Fiche horaire</th>
                    <th>Sélectionner</th>
                </tr>
            
                <%
                                    Collection<LigneSTR> coll = (Collection) request.getAttribute("collectionLignes");
                                    for (LigneSTR L : coll) {%>
                <tr id="trContenu">
                    <td> <%= L.getIdentifiant()%></td>
                    <td> <%= L.getDebut().getNom()%></td>
                    <td> <%= L.getFin().getNom()%></td>
                    <td> <a href="menu?action=ficheTarifaire&id=<%=L.getId()%>">Fiche tarifaire</a></td>                               
                    <td> <a href="menu?action=ficheHoraire&id=<%=L.getId()%>">Fiche horaire</a></td>                               
                    <td> <a href="menu?action=detailLigne&id=<%=L.getId()%>"><button class="btn_ModSup">---></button></a>
                         <a href="menu?action=supprimerLigne&id=<%=L.getId()%>"><button class="btn_ModSup">Supprimer</button></a></td>
                </tr>
                <%
                    }
                %>
                </tr>
        </table>  
         <a href="menu?action=nouvelleLigne"><button id="btn_gauche">Ajouter une ligne</button></a>
    </body>
</html>
