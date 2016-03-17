<%-- 
    Document   : ficheHoraire
    Created on : 11 mars 2016, 16:13:14
    Author     : 5150796
--%>
<%@page import="entity.PlageHoraire"%>
<%@page import="entity.FicheHoraire"%>
<%@page import="entity.LigneSTR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Horaire </title>
    </head>
    <body>
        <h1 id="h1">Horaire > Détail</h1> 
        <% Collection<FicheHoraire> coll = (Collection) request.getAttribute("collectionFichesHorairesBlanche");
            LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");
            java.text.DateFormat df = new java.text.SimpleDateFormat("HH:mm");
            int i = 1;%>
        <h2>Fiche Horaire &nbsp;<%=ligne.getIdentifiant()%></h2>
        
        <% if(!coll.isEmpty()) { %>       
        <TABLE id="tableModif">
            
            <h3><font color="red">Pédiode Blanche</font></h3>
            <% FicheHoraire f = (FicheHoraire) coll.toArray()[0];%>
            <tr id="trTitre">            
                <th></th>
                    <% for (PlageHoraire plage : f.getPlagesHoraires()) {%>
                <th><label><%=plage.getArret().getNom()%></label></th>
                        <%}%>
            </tr>


            <% for (FicheHoraire fiche : coll) {%>
            <tr id="trContenu">           
                <th><font color="red"><%=i%></font></th>
                
                    <% for (PlageHoraire plage : fiche.getPlagesHoraires()) {%>
                <td><label><%= df.format(plage.getHoraire())%></td>
                    <%}%>
            </tr>
            <% i++;%>
            <%}%>
            <%}%>
        </table>

        <% Collection<FicheHoraire> collJ = (Collection) request.getAttribute("collectionFichesHorairesJaune");
            int j = 1;%>
        <% if(!collJ.isEmpty()) { %> 
        <h3><font color="red">Pédiode Jaune</font></h3>
        <TABLE id="tableModif">
            <% FicheHoraire f = (FicheHoraire) collJ.toArray()[0];%>
            <tr id="trTitre">             
                <th></th>
                    <% for (PlageHoraire plage : f.getPlagesHoraires()) {%>
                <th><label><%=plage.getArret().getNom()%></label></th>
                        <%}%>
            </tr>


            <% for (FicheHoraire fiche : collJ) {%>
            <tr id="trContenu">          
                <th><font color="red"><%=j%></font></th>
                    <% for (PlageHoraire plage : fiche.getPlagesHoraires()) {%>
                <td><label><%= df.format(plage.getHoraire())%></td>
                    <%}%>
            </tr>
            <% j++;%>
            <%}%>
            <%}%>
        </table>
        <div id="btn_Enre">
            <a href="menu?action=nouvelleFicheHoraire&id=<%=ligne.getId()%>"><button id="btn_enregistrer">Ajouter horaire</button></a>     
        </div>
    </body>
</html>
