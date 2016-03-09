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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion des arrêts</h1>
        <a href="nouvelleArret.jsp">Ajouter Ligne</a>
        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Nom</th>
                                    <th>Adresse</th>
                                    <th>Détail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    Collection<Arret> coll = (Collection) request.getAttribute("collectionArrets");
                                for (Arret a : coll) {%>
                                <tr>
                                    <td> <%= a.getNom()%></td>
                                    <td> <%= a.getAdresse()%></td>
                                    <td> <a href="menu?action=detailArrets&id=<%=a.getId()%>">---></a></td>
                                </tr>
                                <%
                                    }
                                %>
                                </tr>
                            </tbody>
                        </table>  
    </body>
</html>
