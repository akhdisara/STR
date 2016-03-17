/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.LigneSTR;
import entity.Trajet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    @Override
    public void creerArret(String Nom, String Adresse, List<Trajet> Trajet) {
        Arret Ar = new Arret();
        Ar.setNom(Nom);
        Ar.setAdresse(Adresse);
        Ar.setListeTrajet(Trajet);
        getEntityManager().persist(Ar);
    }

    @Override
    public Collection<Arret> afficherListeArrets() {
        List Ar;
        String txt = "SELECT Ar FROM Arret AS Ar";
        Query req = getEntityManager().createQuery(txt);
        Ar = req.getResultList();
        return Ar;

    }

    @Override
    public Arret RechercheArret(Long id) {
        List Ar = new ArrayList<Arret>();
        String txt = "SELECT Ar FROM Arret Ar WHERE Ar.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("id", id);
        Ar = req.getResultList();
        return (Arret) Ar.get(0);

    }

    @Override
    public Arret RechercheArretParNom(String nom) {
        try {
            String txt = "SELECT Ar FROM Arret Ar WHERE Ar.Nom=:nom";
            Query req = getEntityManager().createQuery(txt);
            req.setParameter("nom", nom);
            return (Arret) req.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void supprimerArret(Arret arret) {
        arret = em.merge(arret);
        em.remove(arret);
    }

    @Override
    public void modifierArret(Arret Ar, String Nom, String Adresse, List<Trajet> Trajet) {
        Ar.setNom(Nom);
        Ar.setAdresse(Adresse);
        Ar.setListeTrajet(Trajet);
        em.merge(Ar);
    }
}
