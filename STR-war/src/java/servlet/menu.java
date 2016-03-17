/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Arret;
import entity.FicheHoraire;
import entity.LigneSTR;
import entity.Periode;
import entity.PlageHoraire;
import entity.PositionArretLigne;
import entity.Reduction;
import entity.Trajet;
import entity.TypeReduction;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            jspAdmin = "/Authentification.jsp";
            request.setAttribute("message", "");
            
        } else if (act.equals("MenuAuthentifier")) {
                int i;
                i = doActionAuthentifier(request, response);
                if (i == 1) {
                    jspAdmin = "/accueil.jsp";
                } else if (i == 2) {
                    jspAdmin = "/Authentification.jsp";
                }
        } else if (act.equals("accueil")) {
                jspAdmin = "/accueil.jsp";
                request.setAttribute("message", "");
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
        } else if (act.equalsIgnoreCase("supprimerLigne")) {
            supprimerLigne(request, response);
            jspAdmin = "/gestionLignes.jsp";
        } else if (act.equalsIgnoreCase("gestionArrets")) {
            gestionArrets(request, response);
            jspAdmin = "/gestionArrets.jsp";
        } else if (act.equalsIgnoreCase("ajouterArret")) {
            ajouterArret(request, response);
            jspAdmin = "/gestionArrets.jsp";
        } else if (act.equalsIgnoreCase("detailArret")) {
            detailArret(request, response);
            jspAdmin = "/detailArret.jsp";
        } else if (act.equalsIgnoreCase("formModifierArret")) {
            detailArret(request, response);
            jspAdmin = "/formModifierArret.jsp";
        } else if (act.equalsIgnoreCase("modifierArret")) {
            modifierArret(request, response);
            jspAdmin = "/detailArret.jsp";
        } else if (act.equalsIgnoreCase("supprimerArret")) {
            supprimerArret(request, response);
            jspAdmin = "/gestionArrets.jsp";
        } else if (act.equalsIgnoreCase("nouvelleLigne")) {
            nouvelleLigne(request, response);
            jspAdmin = "/nouvelleLigne.jsp";
        } else if (act.equalsIgnoreCase("ficheTarifaire")) {
            ficheTarifaire(request, response);
            jspAdmin = "/ficheTarifaire.jsp";
        } else if (act.equalsIgnoreCase("ajouterFicheTarifaire")) {
            ajouterFicheTarifaire(request, response);
            jspAdmin = "/gestionLignes.jsp";
        } else if (act.equalsIgnoreCase("gestionReduction")) {
            gestionReduction(request, response);
            jspAdmin = "/gestionReduction.jsp";
        } else if (act.equalsIgnoreCase("chercherLigne")) {
            chercherLigne(request, response);
            jspAdmin = "/gestionLignes.jsp";
        } else if (act.equalsIgnoreCase("nouvelleReduction")) {
            nouvelleReduction(request, response);
            jspAdmin = "/nouvelleReduction.jsp";
        } else if (act.equalsIgnoreCase("ajouterReduction")) {
            ajouterReduction(request, response);
            jspAdmin = "/gestionReduction.jsp";
        } else if (act.equalsIgnoreCase("supprimerReduction")) {
            supprimerReduction(request, response);
            jspAdmin = "/gestionReduction.jsp";
        } else if (act.equalsIgnoreCase("formModifierReduction")) {
            formModifierReduction(request, response);
            jspAdmin = "/formModifierReduction.jsp";
        } else if (act.equalsIgnoreCase("modifierReduction")) {
            modifierReduction(request, response);
            jspAdmin = "/gestionReduction.jsp";
        } else if (act.equalsIgnoreCase("ficheHoraire")) {
            ficheHoraire(request, response);
            jspAdmin = "/ficheHoraire.jsp";
        } else if (act.equalsIgnoreCase("nouvelleFicheHoraire")) {
            nouvelleFicheHoraire(request, response);
            jspAdmin = "/nouvelleFicheHoraire.jsp";
        } else if (act.equalsIgnoreCase("ajouterFicheHoraire")) {
            try {
                ajouterFicheHoraire(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            jspAdmin = "/ficheHoraire.jsp";
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(jspAdmin);
        rd.forward(request, response);
    }

    protected int doActionAuthentifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String message;
        int i = 0;
        
        if (login.trim().isEmpty() || password.trim().isEmpty()) {
            message = "<div class='msg_error'>Erreur - Vous n'avez pas rempli tous les champs obligatoires.</div>";
            request.setAttribute("message", message);
            i = 2;
        } else if (!login.equals("admin") || !password.equals("admin")) {
            message = "<div class='msg_error'>Erreur - Login ou Mot de passe incorrect</div>";
            request.setAttribute("message", message);
            i = 2;
        } else if (login.equals("admin") && password.equals("admin")) {
            i = 1;
        }
        return i;
    }
    
    protected void ajouterFicheHoraire(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String idLigne = request.getParameter("idLigne");
        String periode = request.getParameter("periode");
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(idLigne));
        Collection<PositionArretLigne> coll = administrateurSession.RecherchePositionParLigne(ligne);
        //Creer une fiche horaire ( contient plusieurs plages horaires)       
        Long idFiche = administrateurSession.creerFicheHoraire(ligne,Periode.valueOf(periode));
        FicheHoraire fiche = administrateurSession.RechercheFicheHoraireParId(idFiche);
        for (PositionArretLigne pos : coll) {
            String horaiteTxt = "horaire" + pos.getArret().getNom();
            String horaiteVal = request.getParameter(horaiteTxt);
            //System.out.println(pos.getArret().getNom()+" --> "+horaiteTxt+"-->"+horaiteVal);           
            administrateurSession.creerPlageHoraire(fiche, pos.getArret(), formatter.parse(horaiteVal));
        }
        //Preparer la liste des plages horaires à afficher
        Collection<FicheHoraire> fichesBlanche = administrateurSession.RechercheFicheHoraireParLignePeriode(ligne,Periode.Blanche);
        for (FicheHoraire fich : fichesBlanche) {
            List<PlageHoraire> listePlages = new ArrayList(administrateurSession.RecherchePlagesHorairesParFicheHoraire(fich));
            fich.setPlagesHoraires(listePlages);
        }
        request.setAttribute("collectionFichesHorairesBlanche", fichesBlanche);
        
        Collection<FicheHoraire> fichesJaune = administrateurSession.RechercheFicheHoraireParLignePeriode(ligne,Periode.Jaune);
        for (FicheHoraire fich : fichesJaune) {
            List<PlageHoraire> listePlages = new ArrayList(administrateurSession.RecherchePlagesHorairesParFicheHoraire(fich));
            fich.setPlagesHoraires(listePlages);
        }
        request.setAttribute("collectionFichesHorairesJaune", fichesJaune);
        request.setAttribute("ligne", ligne);
    }

    protected void nouvelleFicheHoraire(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("PositionsArretLigne", administrateurSession.RecherchePositionParLigne(ligne));
        request.setAttribute("ligne", ligne);
        List<Periode> enumListPeriode = new ArrayList<Periode>(Arrays.asList(Periode.values()));
        request.setAttribute("enumListPeriode", enumListPeriode);
    }

    protected void ficheHoraire(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        //Preparer la liste des plages horaires à afficher
        Collection<FicheHoraire> fichesBlanche = administrateurSession.RechercheFicheHoraireParLignePeriode(ligne,Periode.Blanche);
        for (FicheHoraire fich : fichesBlanche) {
            List<PlageHoraire> listePlages = new ArrayList(administrateurSession.RecherchePlagesHorairesParFicheHoraire(fich));
            fich.setPlagesHoraires(listePlages);
        }
        request.setAttribute("collectionFichesHorairesBlanche", fichesBlanche);
        
        Collection<FicheHoraire> fichesJaune = administrateurSession.RechercheFicheHoraireParLignePeriode(ligne,Periode.Jaune);
        for (FicheHoraire fich : fichesJaune) {
            List<PlageHoraire> listePlages = new ArrayList(administrateurSession.RecherchePlagesHorairesParFicheHoraire(fich));
            fich.setPlagesHoraires(listePlages);
        }
        request.setAttribute("collectionFichesHorairesJaune", fichesJaune);
        request.setAttribute("ligne", ligne);
    }

    protected void modifierReduction(HttpServletRequest request, HttpServletResponse response) {
        String taux = request.getParameter("taux");
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        administrateurSession.modifierReduction(Long.parseLong(id), TypeReduction.valueOf(type), Integer.parseInt(taux));
        request.setAttribute("collectionReductions", administrateurSession.afficherListeReductions());
    }

    protected void supprimerReduction(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        administrateurSession.supprimerReduction(Long.parseLong(id));
        request.setAttribute("collectionReductions", administrateurSession.afficherListeReductions());
    }

    protected void formModifierReduction(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Reduction reduction = administrateurSession.RechercheReduction(Long.parseLong(id));
        List<TypeReduction> enumListTypeReduction = new ArrayList<TypeReduction>(Arrays.asList(TypeReduction.values()));
        request.setAttribute("enumListTypeReduction", enumListTypeReduction);
        request.setAttribute("reduction", reduction);
    }

    protected void ajouterReduction(HttpServletRequest request, HttpServletResponse response) {
        String taux = request.getParameter("taux");
        String type = request.getParameter("type");
        administrateurSession.creerReduction(TypeReduction.valueOf(type), Integer.parseInt(taux));
        request.setAttribute("collectionReductions", administrateurSession.afficherListeReductions());
    }

    protected void nouvelleReduction(HttpServletRequest request, HttpServletResponse response) {
        List<TypeReduction> enumListTypeReduction = new ArrayList<TypeReduction>(Arrays.asList(TypeReduction.values()));
        request.setAttribute("enumListTypeReduction", enumListTypeReduction);
        request.setAttribute("collectionReductions", administrateurSession.afficherListeReductions());
    }

    protected void chercherLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Collection<LigneSTR> coll = new ArrayList<LigneSTR>();
        LigneSTR ligne = administrateurSession.RechercheLigne(id);
        if (ligne == null) {
            request.setAttribute("collectionLignes", new ArrayList<LigneSTR>());
        } else {
            coll.add(ligne);
            request.setAttribute("collectionLignes", coll);
        }
    }

    protected void gestionReduction(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("collectionReductions", administrateurSession.afficherListeReductions());
    }

    protected void ajouterFicheTarifaire(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        List<PositionArretLigne> listePos = new ArrayList(administrateurSession.RecherchePositionParLigne(ligne));
        for (int i = 0; i < listePos.size() - 1; i++) {
            for (int j = i + 1; j < listePos.size(); j++) {
                String tarifTxt = request.getParameter("tarif_" + listePos.get(i).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                String tarifMTxt = request.getParameter("tarifM_" + listePos.get(i).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                String tarifHTxt = request.getParameter("tarifH_" + listePos.get(i).getArret().getNom() + "_" + listePos.get(j).getArret().getNom());
                double tarif = Double.parseDouble(tarifTxt);
                double tarifM = Double.parseDouble(tarifMTxt);
                double tarifH = Double.parseDouble(tarifHTxt);
                administrateurSession.creerTrajet(ligne, listePos.get(i).getArret(), listePos.get(j).getArret(), tarif, tarifM, tarifH, null);
            }
        }
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
    }

    protected void ficheTarifaire(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);

        List<PositionArretLigne> PositionsArretLigne = new ArrayList(administrateurSession.RecherchePositionParLigne(ligne));
        request.setAttribute("PositionsArretLigne", PositionsArretLigne);

        System.out.println("--->Tarif " + PositionsArretLigne);

        for (Trajet t : administrateurSession.RechercheTrajetParLigne(ligne)) {

            String arretDebut = t.getDebut().getNom();
            String arretFin = t.getFin().getNom();

            double tarifBase = administrateurSession.TarifBaseParArrets(ligne, t.getDebut(), t.getFin());
            request.setAttribute("tarif_" + arretDebut + "_" + arretFin, String.valueOf(tarifBase));

            double tarifMensuel = administrateurSession.TarifMensuelParArrets(ligne, t.getDebut(), t.getFin());
            request.setAttribute("tarifM_" + arretDebut + "_" + arretFin, String.valueOf(tarifMensuel));

            double tarifHebdomadaire = administrateurSession.TarifHebdomadaireParArrets(ligne, t.getDebut(), t.getFin());
            System.out.println("===");
            request.setAttribute("tarifH_" + arretDebut + "_" + arretFin, String.valueOf(tarifHebdomadaire));

        }
    }

    protected void nouvelleLigne(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
    }

    protected void supprimerArret(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        administrateurSession.supprimerArret(Long.parseLong(id));
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
        request.setAttribute("message", "Arrêt supprimée");
    }

    protected void detailArret(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Arret arret = administrateurSession.RechercheArret(Long.parseLong(id));
        request.setAttribute("arret", arret);
    }

    protected void modifierArret(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        administrateurSession.modifierArret(Long.parseLong(id), nom, adresse, null);

        Arret arret = administrateurSession.RechercheArret(Long.parseLong(id));
        request.setAttribute("arret", arret);
    }

    protected void detailArrets(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Arret arret = administrateurSession.RechercheArret(Long.parseLong(id));
        request.setAttribute("arret", arret);
    }

    protected void ajouterArret(HttpServletRequest request, HttpServletResponse response) {
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        Arret a = administrateurSession.RechercheArretParNom(nom);
        System.out.println("-->" + nom);
        System.out.println("-->" + a);
        if (a != null) {
            request.setAttribute("message", "Cette arrêt existe deja");
        } else {
            request.setAttribute("message", "Nouvelle arrêt enregistrée");
            administrateurSession.creerArret(nom, adresse, null);
        }

        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
    }

    protected void gestionArrets(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
        request.setAttribute("message", "");
    }

    protected void supprimerLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        administrateurSession.supprimerLigne(Long.parseLong(id));
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
        request.setAttribute("message", "La ligne STR a été bien supprimée");
    }

    protected void modifierLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String identifiant = request.getParameter("identifiant");

        administrateurSession.modifierLigne(Long.parseLong(id), identifiant, null, null);

        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);
    }

    protected void formModifierLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
        request.setAttribute("ligne", ligne);
    }

    protected void detailLigne(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        LigneSTR ligne = administrateurSession.RechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);
        request.setAttribute("PositionArretLigne", administrateurSession.RecherchePositionParLigne(ligne));
    }

    protected void ajouterLigne(HttpServletRequest request, HttpServletResponse response) {
        String identifiant = request.getParameter("identifiant");
        Collection<Arret> col = administrateurSession.afficherListeArrets();
        String o = new String();
        int max = 0;
        //Verifier que la position est saisi une seule fois
        List<String> listePosition = new ArrayList<String>();
        boolean tmp = true;
        for (Arret a : col) {
            o = request.getParameter("arret_" + a.getNom());
            System.out.println("---->" + o);
            if (!o.equals("null") && !o.equals("0") && !o.equals("")) {
                if (listePosition.contains(o)) {
                    tmp = false;
                } else {
                    listePosition.add(o);
                }

                if (max < Integer.parseInt(o)) {
                    max = Integer.parseInt(o);
                }
            }
        }
        if (tmp == false) {
            request.setAttribute("message", "Erreur ! , Vous avez saisi plusieur fois la meme position.");
        } else if (listePosition.size() < 2) {
            request.setAttribute("message", "Erreur ! , Vous devez selectionner au moins deux arrets.");
        } else // Sinon
        {
            //Creer la ligne
            administrateurSession.creerLigne(identifiant);
            LigneSTR l = administrateurSession.RechercheLigne(identifiant);
            Arret d = new Arret();
            Arret f = new Arret();

            //Creer les positions des arrets
            for (Arret arret : col) {
                o = request.getParameter("arret_" + arret.getNom());
                if (!o.equals("null") && !o.equals("0") && !o.equals("")) {
                    administrateurSession.ajouterPosition(l, arret, Integer.parseInt(o));
                    if (Integer.parseInt(o) == 1) {
                        d = arret;
                    }
                    if (Integer.parseInt(o) == max) {
                        f = arret;
                    }
                }
            }
            administrateurSession.modifierLigne(l.getId(), l.getIdentifiant(), d, f);
            request.setAttribute("message", "");
        }
        request.setAttribute("collectionArrets", administrateurSession.afficherListeArrets());
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
    }

    protected void gestionLignes(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("collectionLignes", administrateurSession.afficherListeLigne());
        request.setAttribute("message", "");
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
