/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Car;
import entity.Tarifs;
import entity.Trajet;
import entity.Type_Paiement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 5152683
 */
@Stateless
public class TrajetFacade extends AbstractFacade<Trajet> implements TrajetFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrajetFacade() {
        super(Trajet.class);
    }
      public void creerTrajet(Arret Debut,Arret Fin,Date Heure_depart, Date Heure_Arrivé, Integer Kilométrage,List<Arret> Arret, List<Car> Car, List<Tarifs> Tarifs)
    {
        Trajet T = new Trajet();
        T.setDebut(Debut);
        T.setFin(Fin);
        T.setHeure_depart(Heure_depart);
        T.setHeure_Arrivé(Heure_Arrivé);
        T.setKilométrage(Kilométrage);
        T.setListeArret(Arret);
        T.setListeCar(Car);
        T.setListeTarif(Tarifs);
        getEntityManager().persist(T);
    }
    public Collection<Trajet>afficherListeTrajet()
    {
        List T;
        String txt="SELECT T FROM Trajet AS T";
                Query req=getEntityManager().createQuery(txt);
                T = req.getResultList();
                return T;
        
    }
    public Trajet RechercheTrajet(Long id)
    {
        List T = new ArrayList<Trajet>();
    String txt="SELECT T FROM Trajet T WHERE T.id=:id";
    Query req=getEntityManager().createQuery(txt);
    req.setParameter("id",id);
    T = req.getResultList();
    return(Trajet)T.get(0);
    
}
    public void supprimerTrajet(Trajet trajet) {
        trajet = em.merge(trajet);
        em.remove(trajet);
    }
    public void modifierTrajet(Long id, Arret Debut,Arret Fin,Date Heure_depart, Date Heure_Arrivé, Integer Kilométrage,List<Arret> Arret, List<Car> Car, List<Tarifs> Tarifs)
    {
       Trajet T = new Trajet();
       T.setId(id);
        T.setDebut(Debut);
        T.setFin(Fin);
        T.setHeure_depart(Heure_depart);
        T.setHeure_Arrivé(Heure_Arrivé);
        T.setKilométrage(Kilométrage);
        T.setListeArret(Arret);
        T.setListeCar(Car);
        T.setListeTarif(Tarifs);
        em.merge(T);
    }
    
}
