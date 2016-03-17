/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Facade.ArretFacadeLocal;
import Facade.CarFacadeLocal;
import Facade.FicheHoraireFacadeLocal;
import Facade.LigneSTRFacadeLocal;
import Facade.PlageHoraireFacadeLocal;
import Facade.PositionArretLigneFacadeLocal;
import Facade.ReductionFacadeLocal;
import Facade.TrajetFacadeLocal;
import entity.Arret;
import entity.Car;
import entity.FicheHoraire;
import entity.LigneSTR;
import entity.Periode;
import entity.PlageHoraire;
import entity.PositionArretLigne;
import entity.Reduction;
import entity.Trajet;
import entity.TypeReduction;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;


/**
 *
 * @author 5152683
 */
@Stateless
@LocalBean

public class Administrateur {
    @EJB
    private LigneSTRFacadeLocal ligneFacade;
    @EJB
    private PlageHoraireFacadeLocal plageHoraireFacade;

    @EJB
    private FicheHoraireFacadeLocal ficheHoraireFacade;
    @EJB
    private ReductionFacadeLocal reductionFacade;
    @EJB
    private PositionArretLigneFacadeLocal positionArretLigneFacade;

    @EJB
    private CarFacadeLocal carFacade;
    @EJB
    private TrajetFacadeLocal trajetFacade;
 
    @EJB
    private ArretFacadeLocal arretFacade;

    ///LIGNE
    public void creerLigne(String Identifiant) {
        ligneFacade.creerLigne(Identifiant);
    }

    public LigneSTR RechercheLigne(String Identifiant) {
        return ligneFacade.RechercheLigne(Identifiant);
    }

    public LigneSTR RechercheLigneParId(Long id) {
        return ligneFacade.RechercheLigneParId(id);
    }

    public void supprimerLigne(Long id) {
        LigneSTR l = ligneFacade.RechercheLigneParId(id);
        ligneFacade.supprimerLigne(l);
    }

    public void modifierLigne(Long id, String Identifiant, Arret Debut, Arret Fin) {
        LigneSTR l = ligneFacade.RechercheLigneParId(id);
        ligneFacade.modifierLigne(l, Identifiant, Debut, Fin);
    }

    public Collection<LigneSTR> afficherListeLigne() {
        return ligneFacade.afficherListeLigne();
    }
///Arret

    public void creerArret(String Nom, String Adresse, List<Trajet> Trajet) {
        arretFacade.creerArret(Nom, Adresse, Trajet);
    }

    public Arret RechercheArret(Long id) {
        return arretFacade.RechercheArret(id);
    }

    public void supprimerArret(Long id) {
        Arret a = arretFacade.RechercheArret(id);
        arretFacade.supprimerArret(a);
    }

    public void modifierArret(Long id, String Nom, String Adresse, List<Trajet> Trajet) {
        Arret a = arretFacade.RechercheArret(id);
        arretFacade.modifierArret(a, Nom, Adresse, Trajet);
    }

    public Collection<Arret> afficherListeArrets() {
        return arretFacade.afficherListeArrets();
    }

    ///Trajet
    public void creerTrajet(LigneSTR ligne, Arret Debut, Arret Fin, double tarifBase, double TarifMensuel, double tarifHebdomadaire, List<Car> Car) {
        trajetFacade.creerTrajet(ligne, Debut, Fin, tarifBase, TarifMensuel, tarifHebdomadaire, Car);
    }

    public Trajet RechercheTrajet(Long id) {
        return trajetFacade.RechercheTrajet(id);
    }

    public void supprimerTrajet(Long id) {
        Trajet t = trajetFacade.RechercheTrajet(id);
        trajetFacade.supprimerTrajet(t);
    }

    public void modifierTrajet(long id, LigneSTR ligne, Arret Debut, Arret Fin, double tarifBase, double TarifMensuel, double tarifHebdomadaire, List<Car> Car) {
        Trajet t = trajetFacade.RechercheTrajet(id);
        trajetFacade.modifierTrajet(t, ligne, Debut, Fin, tarifBase, TarifMensuel, tarifHebdomadaire, null);
    }

    public Collection<Trajet> afficherListeTrajet() {
        return trajetFacade.afficherListeTrajet();
    }

    ///CAR
    public void creerCar(String Identifiant, List<Trajet> Trajet) {
        carFacade.creerCar(Identifiant, Trajet);
    }

    public Car RechercheCar(String Identifiant) {
        return carFacade.RechercheCar(Identifiant);
    }

    public void supprimerCar(String Identifiant) {
        Car c = carFacade.RechercheCar(Identifiant);
        carFacade.supprimerCar(c);
    }

    public void modifierCar(Car car, String Identifiant, List<Trajet> Trajet) {
        Car c = carFacade.RechercheCar(Identifiant);
        carFacade.modifierCar(car, Identifiant, Trajet);
    }

    public Collection<Car> afficherListeCars() {
        return carFacade.afficherListeCars();

    }


    public void ajouterPosition(LigneSTR l, Arret a, int position) {
        positionArretLigneFacade.ajouterPositionArretLigne(l, a, position);
    }

    public double TarifBaseParArrets(LigneSTR l, Arret debut, Arret arrivee) {
        return trajetFacade.TarifBaseParArrets(l, debut, arrivee);
    }

    public double TarifMensuelParArrets(LigneSTR l, Arret debut, Arret arrivee) {
        return trajetFacade.TarifMensuelParArrets(l, debut, arrivee);
    }

    public double TarifHebdomadaireParArrets(LigneSTR l, Arret debut, Arret arrivee) {
        return trajetFacade.TarifHebdomadaireParArrets(l, debut, arrivee);
    }

    public void creerReduction(TypeReduction type, int taux) {
        reductionFacade.creerReduction(type, taux);
    }

    public Collection<Reduction> afficherListeReductions() {
        return reductionFacade.afficherListeReductions();
    }

    public Reduction RechercheReduction(long id) {
        return reductionFacade.RechercheReduction(id);
    }

    public Reduction RechercheReductionParType(TypeReduction typeReduction) {
        return reductionFacade.RechercheReductionParType(typeReduction);
    }

    public void supprimerReduction(long id) {
        Reduction r = reductionFacade.RechercheReduction(id);
        reductionFacade.supprimerReduction(r);
    }

    public void modifierReduction(long id, TypeReduction type, int taux) {
        Reduction r = reductionFacade.RechercheReduction(id);
        reductionFacade.modifierReduction(r, type, taux);
    }

    public Collection<PositionArretLigne> RecherchePositionParLigne(LigneSTR ligne) {
        return positionArretLigneFacade.RecherchePositionParLigne(ligne);
    }

    public List<Trajet> RechercheTrajetParLigne(LigneSTR ligne) {
        return trajetFacade.RechercheTrajetParLigne(ligne);
    }

    public Collection<FicheHoraire> RechercheFicheHoraireParLigne(LigneSTR ligne) {
        return ficheHoraireFacade.RechercheFicheHoraireParLigne(ligne);
    }
    
    public Arret RechercheArretParNom(String nom) {
        return arretFacade.RechercheArretParNom(nom);
    }
    
    public Long creerFicheHoraire(LigneSTR ligne,Periode periode) {
        return ficheHoraireFacade.creerFicheHoraire(ligne,periode);
    }
    
    public void creerPlageHoraire(FicheHoraire ficheHoraire, Arret arret, Date horaire) {
        plageHoraireFacade.creerPlageHoraire(ficheHoraire, arret, horaire);
    }
    
    public FicheHoraire RechercheFicheHoraireParId(Long id) {
        return ficheHoraireFacade.RechercheFicheHoraireParId(id);
    }
    
     public Collection<PlageHoraire> RecherchePlagesHorairesParFicheHoraire(FicheHoraire ficheHoraire) {
       return plageHoraireFacade.RecherchePlagesHorairesParFicheHoraire(ficheHoraire);
    }
     
     public Collection<FicheHoraire> RechercheFicheHoraireParLignePeriode(LigneSTR ligne , Periode periode) {
        return  ficheHoraireFacade.RechercheFicheHoraireParLignePeriode(ligne, periode);
    }
}
