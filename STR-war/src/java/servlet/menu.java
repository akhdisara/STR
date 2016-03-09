/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Arret;
import entity.Ligne;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.Administrateur;

/**
 *
 * @author Sara
 */
@WebServlet(name = "menu", urlPatterns = {"/menu"})
public class menu extends HttpServlet {

    @EJB
    private Administrateur administrateurSession;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods-.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String act = request.getParameter("action");
        String jspAdmin = null;

        if ((act == null) || (act.equals("null"))) {
            jspAdmin = "/accueil.jsp";
        } else if (act.equalsIgnoreCase("gestionLignes")) {
            gestionLignes(request, response);
            jspAdmin = "/gestionLignes.jsp";
        } else if (act.equalsIgnoreCase("ajouterLigne")) {
            ajouterLigne(request, response);
            jspAdmin = "/gestionLignes.jsp";
        } else if (act.equalsIgnoreCase("detailLigne")) {
            detailLigne(request, response);
            jspAdmin = "/detailLigne.jsp";
        } else if (act.equalsIgnoreCase("formModifierLigne")) {
            formModifierLigne(request, response);
            jspAdmin = "/formModifierLigne.jsp";
        } else if (act.equalsIgnoreCase("modifierLigne")) {
            modifierLigne(request, response);
            jspAdmin = "/detailLigne.jsp";
        }else if (act.equalsIgnoreCase("supprimerLigne")) {
            supprimerLigne(request, response);
            jspAdmin = "/gestionLignes.jsp";
        }else if (act.equalsIgnoreCase("gestionArrets")) {
            gestionArrets(request, response);
            jspAdmin = "/gestionArrets.jsp";
        }else if (act.equalsIgnoreCase("ajouterArret")) {
            ajouterArret(request, response);
            jspAdmin = "/gestionArrets.jsp";
        }else if (act.equalsIgnoreCase("detailArrets")) {
            ajouterArret(request, response);
            jspAdmin = "/detailArrets.jsp";
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(jspAdmin);
        rd.forward(request, response);
    }

    protected void detailArrets(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Arret arret = administrateurSession.RechercheArret(Long.parseLong(id));
        request.setAttribute("arret", arret);
    }
    protected void ajouterArret(HttpServletRequest request, HttpServletResponse response) {
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        administrateurSession.creerArret(nom, adresse, null, null, null);
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
    }
    
    protected void gestionArrets(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
    }
    protected void supprimerLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        administrateurSession.supprimerLigne(Long.parseLong(id));
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
    }
    protected void modifierLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String identifiant = request.getParameter("identifiant");
        
        administrateurSession.modifierLigne(Long.parseLong(id),identifiant, null, null, null, null, null);
        
        Ligne ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);
    }

    protected void formModifierLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Ligne ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);
    }

    protected void detailLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Ligne ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);
    }

    protected void ajouterLigne(HttpServletRequest request, HttpServletResponse response) {
        String identifiant = request.getParameter("identifiant");
        administrateurSession.creerLigne(identifiant, null, null, null, null, null);
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
    }

    protected void gestionLignes(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
