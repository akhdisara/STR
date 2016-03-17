<%-- 
    Document   : nouvelleLigne
    Created on : 9 mars 2016, 00:23:04
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
        <title>Ligne</title>
    
</head>
<body>
    <h1 id="h1">Nouvelle Ligne</h1>
    <form method="get" action="menu">
        <div align="center">
        Identifiant : <input type="text" name="identifiant" /><br>
        </div>
        <TABLE id="tableModif">
                <tr id="trTitre">
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Ordre d'arrêt</th>
                </tr>
                <%
                    Collection<Arret> coll = (Collection) request.getAttribute("collectionArrets");
                for (Arret a : coll) {%>
                <tr>
                    <td> <%= a.getNom()%></td>
                    <td> <%= a.getAdresse()%></td>
                    <td> <input type="text" name="arret_<%=a.getNom()%>" /></td>
                </tr>
                <%
                    }
                %>
                </tr>
            </tbody>
        </table> 
                <div id="btn_Enre">
                    <input type="hidden" name="action" value="ajouterLigne" />
                    <input id="btn_enregistrer" type="submit" value="Ajouter">
                    <input id="btn_enregistrer" type="reset" value="Vider">
                </div>
    </form>
</body>
</html>
