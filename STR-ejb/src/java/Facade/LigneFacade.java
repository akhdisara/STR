/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Horaire;
import entity.Ligne;
import entity.Tarifs;
import java.util.ArrayList;
import java.util.Collection;
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
public class LigneFacade extends AbstractFacade<Ligne> implements LigneFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneFacade() {
        super(Ligne.class);
    }
      public void creerLigne(String Identifiant,Arret Debut,Arret Fin, List<Tarifs> Tarifs, List<Horaire> Horaire, List<Arret> Arret)
    {
        Ligne L = new Ligne();
        L.setIdentifiant(Identifiant);
        L.setDebut(Debut);
        L.setFin(Fin);
        L.setListeTarifs(Tarifs);
        L.setListeHoraire(Horaire);
        L.setListeArret(Arret);
        getEntityManager().persist(L);
    }
    public Collection<Ligne>afficherListeLigne()
    {
        List L;
        String txt="SELECT L FROM Ligne AS L";
                Query req=getEntityManager().createQuery(txt);
                L = req.getResultList();
                return L;
        
    }
    public Ligne RechercheLigne(String Identifiant)
    {
        List L = new ArrayList<Ligne>();
    String txt="SELECT L FROM Ligne L WHERE L.Identifiant=:Identifiant";
    Query req=getEntityManager().createQuery(txt);
    req.setParameter("Identifiant",Identifiant);
    L = req.getResultList();
    return(Ligne)L.get(0);
    
}
    public void supprimerLigne(Ligne Ligne) {
        Ligne = em.merge(Ligne);
        em.remove(Ligne);
    }
    public void modifierLigne(String Identifiant,Arret Debut,Arret Fin, List<Tarifs> Tarifs, List<Horaire> Horaire, List<Arret> Arret)
    {
      Ligne L = new Ligne();
        L.setIdentifiant(Identifiant);
        L.setDebut(Debut);
        L.setFin(Fin);
        L.setListeTarifs(Tarifs);
        L.setListeHoraire(Horaire);
        L.setListeArret(Arret);
        em.merge(L);
    }
}
