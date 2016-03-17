/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.LigneSTR;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 5150796
 */
@Stateless
public class LigneSTRFacade extends AbstractFacade<LigneSTR> implements LigneSTRFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneSTRFacade() {
        super(LigneSTR.class);
    }
    
    
    @Override
    public void creerLigne(String Identifiant) {
        LigneSTR L = new LigneSTR();
        L.setIdentifiant(Identifiant);
        getEntityManager().persist(L);
    }

    @Override
    public Collection<LigneSTR> afficherListeLigne() {

        String txt = "SELECT L FROM LigneSTR AS L";
        Query req = getEntityManager().createQuery(txt);
        return req.getResultList();
    }

    @Override
    public LigneSTR RechercheLigne(String Identifiant) {
        try {
            String txt = "SELECT L FROM LigneSTR L WHERE L.Identifiant=:Identifiant";
            Query req = getEntityManager().createQuery(txt);
            req.setParameter("Identifiant", Identifiant);
            return (LigneSTR) req.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public LigneSTR RechercheLigneParId(Long id) {
        String txt = "SELECT L FROM LigneSTR L WHERE L.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("id", id);
        return (LigneSTR) req.getResultList().get(0);
    }

    @Override
    public void supprimerLigne(LigneSTR Ligne) {
        Ligne = em.merge(Ligne);
        em.remove(Ligne);
    }

    @Override
    public void modifierLigne(LigneSTR L, String Identifiant, Arret Debut, Arret Fin) {
        L.setIdentifiant(Identifiant);
        L.setDebut(Debut);
        L.setFin(Fin);
        em.merge(L);
    }
    
}
