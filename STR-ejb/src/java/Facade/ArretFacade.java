/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Horaire;
import entity.Ligne;
import entity.Trajet;
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
public class ArretFacade extends AbstractFacade<Arret> implements ArretFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArretFacade() {
        super(Arret.class);
    }
    public void creerArret(String Nom,String Adresse, List<Trajet> Trajet, List<Horaire> Horaire, List<Ligne> Ligne)
    {
        Arret Ar = new Arret();
        Ar.setNom(Nom);
        Ar.setAdresse(Adresse);
        Ar.setListeHoraire(Horaire);
        Ar.setListeTrajet(Trajet);
        Ar.setListeLigne(Ligne);
        getEntityManager().persist(Ar);
    }
    @Override
    public Collection<Arret>afficherListeArrets()
    {
        List Ar;
        String txt="SELECT Ar FROM Arret AS Ar";
                Query req=getEntityManager().createQuery(txt);
                Ar = req.getResultList();
                return Ar;
        
    }
    @Override
    public Arret RechercheArret(Long id)
    {
        List Ar = new ArrayList<Arret>();
    String txt="SELECT Ar FROM Arret Ar WHERE Ar.id=:id";
    Query req=getEntityManager().createQuery(txt);
    req.setParameter("id",id);
    Ar = req.getResultList();
    return(Arret)Ar.get(0);
    
}
    public void supprimerArret(Arret arret) {
        arret = em.merge(arret);
        em.remove(arret);
    }
    public void modifierArret(Arret Ar , String Nom, String Adresse,List<Trajet> Trajet, List<Horaire> Horaire, List<Ligne> Ligne)
    {
        Ar.setNom(Nom);
        Ar.setAdresse(Adresse);
        Ar.setListeHoraire(Horaire);
        Ar.setListeTrajet(Trajet);
        Ar.setListeLigne(Ligne);
        em.merge(Ar);
    }
}
