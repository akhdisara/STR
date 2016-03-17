<%-- 
    Document   : detailLigne
    Created on : 9 mars 2016, 01:08:32
    Author     : Sara
--%>

<%@page import="entity.PositionArretLigne"%>
<%@page import="entity.LigneSTR"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="navigation.jsp" %>
        <title>Fiche tarifaire</title>
    </head>
    <%
        LigneSTR ligne = (LigneSTR) request.getAttribute("ligne");
    %>
    <body>

        <h1 id="h1">Tarif > Détail</h1> 
        <form id="ficheTarifaire-form">
            <div class="textTarif">
            Identifiant : <%=ligne.getIdentifiant()%> <br>
            </div>
            <div id="allDiv">
                <div id="divBase">
            <h2>Tarif de Base</h2>
            <TABLE id="tableAffich">
            <tr id="trTitre">
                    <th>Départ</th>
                    <th>Arrivée - Tarif</th>
                </tr>
                <%
                    int i = 0;
                    List<PositionArretLigne> listePos = (List) request.getAttribute("PositionsArretLigne");
                    for (i = 0; i < listePos.size() - 1; i++) {%>
                <tr id="trContenu">
                    <td><%= listePos.get(i).getArret().getNom()%></td>
                    <td>
                        <%
                            for (int j = i + 1; j < listePos.size(); j++) {
                                String val = (String) request.getAttribute("tarif_" + listePos.get(i).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                if(val == null)
                                    val = "";                             
                        %>

                        <label size="10"> <%= listePos.get(j).getArret().getNom()%></label>
                        <input type="text" name="tarif_<%= listePos.get(i).getArret().getNom()%>_<%= listePos.get(j).getArret().getNom()%>" 
                               value="<%=val%>" size="10" />
                        <br/>
                        <%}%>

                    </td>

                </tr>
                <%}%>

            </table>
                </div>
                <div id="divMensuel">
            <h2>Tarif Mensuel</h2>
            <TABLE id="tableAffich">
            <tr id="trTitre">
                    <th>Départ</th>
                    <th>Arrivée - Tarif</th>
                </tr>
                <%
                    List<PositionArretLigne> listePosM = (List) request.getAttribute("PositionsArretLigne");;
                    for (int k = 0; k < listePosM.size() - 1; k++) {%>
                <tr id="trContenu">
                    <td><%= listePosM.get(k).getArret().getNom()%></td>
                    <td>
                        <%
                            for (int j = k + 1; j < listePosM.size(); j++) {
                                String val = (String) request.getAttribute("tarifM_" + listePos.get(k).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                if(val == null)
                                    val = "";
                        %>
                        <label size="10"> <%= listePosM.get(j).getArret().getNom()%></label>
                        <input type="text" name="tarifM_<%= listePosM.get(k).getArret().getNom()%>_<%= listePosM.get(j).getArret().getNom()%>" value="<%=val%>" size="10" />
                        <br/>
                        <%}%>

                    </td>

                </tr>
                <%}%>

            </table>
                </div>
                <div id="divHebdo">
            <h2>Tarif Hebdomadaire</h2>
            <TABLE id="tableAffich">
            <tr id="trTitre">
                    <th>Départ</th>
                    <th>Arrivée - Tarif</th>
                </tr>
                <%
                    List<PositionArretLigne> listePosH = (List) request.getAttribute("PositionsArretLigne");;
                    for (int k = 0; k < listePosH.size() - 1; k++) {%>
                <tr id="trContenu">
                    <td><%= listePosH.get(k).getArret().getNom()%></td>
                    <td>
                        <%
                            for (int j = k + 1; j < listePosH.size(); j++) {
                                String val = (String) request.getAttribute("tarifM_" + listePos.get(k).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                                if(val == null)
                                    val = "";
                        %>
                        <label size="10"> <%= listePosH.get(j).getArret().getNom()%></label>
                        <input type="text" name="tarifH_<%= listePosH.get(k).getArret().getNom()%>_<%= listePosH.get(j).getArret().getNom()%>" value="<%=val%>"  size="10" />
                        <br/>
                        <%}%>

                    </td>

                </tr>
                <%}%>
                
            </table>
                </div>
                </div>
                <br>
                <div id="btn_ModSup">
            <input type="hidden" name="action" value="ajouterFicheTarifaire" />
            <input type="hidden" name="id" value="<%=ligne.getId()%>"/>
            <input id="btn_gauche" type="submit" value="Ajouter">
                </div> 
        </form>
    </body>
</html>
