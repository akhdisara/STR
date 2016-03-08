/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Ligne;
import entity.Periode;
import entity.Tarifs;
import entity.Categorie_voyageur;
import entity.Horaire;
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
public class TarifsFacade extends AbstractFacade<Tarifs> implements TarifsFacadeLocal {

    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarifsFacade() {
        super(Tarifs.class);
    }

    @Override
    public void creerTarif(Ligne ligne, Trajet trajet, Categorie_voyageur categorie_voyageur, float prix, Periode periode) {
        Tarifs tarif = new Tarifs();
        tarif.setLigne(ligne);
        tarif.setTrajet(trajet);
        tarif.setCategorie_voyageur(categorie_voyageur);
        tarif.setPrix(prix);
        tarif.setPeriode(periode);
        em.persist(tarif);
    }
    
    @Override
    public Collection<Tarifs> afficherListeTarifs() {
        String txt = "SELECT t FROM Tarifs AS t";
        Query req = getEntityManager().createQuery(txt);
        return req.getResultList();
    }

    @Override
    public Collection<Tarifs> RechercheTarifsParLigne(Ligne ligne) {
        String txt = "SELECT t FROM Tarifs t WHERE t.Ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ligne", ligne);
        return req.getResultList();
    }

    @Override
    public Collection<Tarifs> RechercheTarifsParTrajet(Trajet trajet) {
        String txt = "SELECT t FROM Tarifs t WHERE t.Trajet=:trajet";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("trajet", trajet);
        return req.getResultList();
    }

    @Override
    public Collection<Tarifs> RechercheTarifsParTypePaiement(Type_Paiement typePaiement) {
        String txt = "SELECT t FROM Tarifs t WHERE t.Type_Paiement=:typePaiement";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("typePaiement", typePaiement);
        return req.getResultList();
    }
    
    @Override
    public Collection<Tarifs> RechercheTarifsParPeriode(Periode periode) {
        String txt = "SELECT t FROM Tarifs t WHERE t.Periode=:periode";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("periode", periode);
        return req.getResultList();
    } 
        
    @Override
    public void supprimerTarifs(Tarifs tarifs) {
        tarifs = em.merge(tarifs);
        em.remove(tarifs);
    }
    
    @Override
    public void modifierTarifs(Tarifs tarif,Ligne ligne, Trajet trajet, Categorie_voyageur categorie_voyageur, float prix, Periode periode)
    {
        tarif.setLigne(ligne);
        tarif.setTrajet(trajet);
        tarif.setCategorie_voyageur(categorie_voyageur);
        tarif.setPrix(prix);
        tarif.setPeriode(periode);
        em.merge(tarif);
    } 
}
