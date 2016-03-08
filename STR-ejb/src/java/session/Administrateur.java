/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Facade.ArretFacadeLocal;
import Facade.CarFacadeLocal;
import Facade.LigneFacadeLocal;
import Facade.TrajetFacadeLocal;
import entity.Arret;
import static entity.Arret_.id;
import entity.Car;
import entity.Horaire;
import entity.Ligne;
import static entity.Ligne_.Debut;
import static entity.Ligne_.Identifiant;
import entity.Tarifs;
import entity.Trajet;
import entity.Type_Paiement;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author 5152683
 */
@Stateless
@LocalBean

public class Administrateur {
    @EJB
    private CarFacadeLocal carFacade;
    @EJB
    private TrajetFacadeLocal trajetFacade;
    @EJB
    private LigneFacadeLocal ligneFacade;
    @EJB
    private ArretFacadeLocal arretFacade;
    ///LIGNE
     public void creerLigne(String Identifiant,Arret Debut,Arret Fin, List<Tarifs> Tarifs, List<Horaire> Horaire, List<Arret> Arret)
     {
        ligneFacade.creerLigne(Identifiant,Debut,Fin,Tarifs, Horaire, Arret);
     }
     public Ligne RechercheLigne(String Identifiant)
     {
         return ligneFacade.RechercheLigne(Identifiant);
     }
     public void supprimerLigne(String Identifiant) 
     {
         Ligne l = ligneFacade.RechercheLigne(Identifiant);
       
        ligneFacade.supprimerLigne(l);
     }
      public void modifierLigne(String Identifiant,Arret Debut,Arret Fin, List<Tarifs> Tarifs, List<Horaire> Horaire, List<Arret> Arret)
      {
          Ligne l = ligneFacade.RechercheLigne(Identifiant);
        ligneFacade.modifierLigne(Identifiant,Debut,Fin,Tarifs,Horaire,Arret);
      }
       public Collection<Ligne>afficherListeLigne()
    {
        return ligneFacade.afficherListeLigne();
    }
///Arret
       public void creerArret(String Nom,String Adresse, List<Trajet> Trajet, List<Horaire> Horaire, List<Ligne> Ligne)
     {
        arretFacade.creerArret(Nom,Adresse,Trajet,Horaire, Ligne);
     }
     public Arret RechercheArret(Long id)
     {
         return arretFacade.RechercheArret(id);
     }
     public void supprimerArret(Long id) 
     {
         Arret a = arretFacade.RechercheArret(id);
        arretFacade.supprimerArret(a);
     }
    public void modifierArret(Long id, String Nom,String Adresse, List<Trajet> Trajet, List<Horaire> Horaire, List<Ligne> Ligne)
      {
        Arret a = arretFacade.RechercheArret(id);
        arretFacade.modifierArret(a,Nom,Adresse,Trajet,Horaire,Ligne);
      }
    public Collection<Arret>afficherListeArrets()
    {
        return arretFacade.afficherListeArrets();
    }
    ///Trajet
         public void creerTrajet(Arret Debut,Arret Fin,Date Heure_depart, Date Heure_Arrivé, Integer Kilométrage,List<Arret> Arret, List<Car> Car, List<Type_Paiement> Type_Paiement, List<Tarifs> Tarifs)
     {
        trajetFacade.creerTrajet(Debut,Fin,Heure_depart,Heure_Arrivé,Kilométrage,Arret,Car,Type_Paiement,Tarifs);
     }
     public Trajet RechercheTrajet(Long id)
     {
         return trajetFacade.RechercheTrajet(id);
     }
     public void supprimerTrajet(Long id) 
     {
         Trajet t = trajetFacade.RechercheTrajet(id);
        trajetFacade.supprimerTrajet(t);
     }
     public void modifierTrajet(Long id, Arret Debut,Arret Fin,Date Heure_depart, Date Heure_Arrivé, Integer Kilométrage,List<Arret> Arret, List<Car> Car, List<Type_Paiement> Type_Paiement, List<Tarifs> Tarifs)
      {
        Trajet t = trajetFacade.RechercheTrajet(id);
        trajetFacade.modifierTrajet(id,Debut,Fin,Heure_depart,Heure_Arrivé,Kilométrage,Arret,Car,Type_Paiement,Tarifs);
      }
    public Collection<Trajet>afficherListeTrajet()
    {
        return trajetFacade.afficherListeTrajet();
    }
    ///CAR
      public void creerCar(String Identifiant, List<Trajet> Trajet)
     {
        carFacade.creerCar(Identifiant,Trajet);
     }
     public Car RechercheCar(String Identifiant)
     {
        return carFacade.RechercheCar(Identifiant);
     }
     public void supprimerCar(String Identifiant) 
     {
         Car c = carFacade.RechercheCar(Identifiant);
        carFacade.supprimerCar(c);
     }
     public void modifierCar(Car car , String Identifiant, List<Trajet> Trajet)
      {
        Car c = carFacade.RechercheCar(Identifiant);
        carFacade.modifierCar(car ,Identifiant,Trajet);
      }
     public Collection<Car>afficherListeCars()
    {
        return carFacade.afficherListeCars();
    
    }
       
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}