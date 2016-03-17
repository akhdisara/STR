/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.FicheHoraire;
import entity.LigneSTR;
import entity.Periode;
import entity.PlageHoraire;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 5150796
 */
@Stateless
public class FicheHoraireFacade extends AbstractFacade<FicheHoraire> implements FicheHoraireFacadeLocal {

    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FicheHoraireFacade() {
        super(FicheHoraire.class);
    }

    @Override
    public Long creerFicheHoraire(LigneSTR ligne,Periode periode) {
        FicheHoraire fiche = new FicheHoraire();
        fiche.setLigne(ligne);
        fiche.setPeriode(periode);
        em.persist(fiche);
        em.flush();
        return fiche.getId();
    }

    @Override
    public void modifierFicheHoraire(FicheHoraire fiche,LigneSTR ligne,Periode periode) {
        fiche.setLigne(ligne);
        fiche.setPeriode(periode);
        em.merge(fiche);
    }

    @Override
    public void supprimerFicheHoraire(FicheHoraire fiche) {
        fiche = em.merge(fiche);
        em.remove(fiche);
    }

    @Override
    public Collection<FicheHoraire> RechercheFicheHoraireParLigne(LigneSTR ligne) {
        String txt = "SELECT p FROM FicheHoraire p WHERE p.ligne=:ligne";
        em.flush();
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ligne", ligne);
        return req.getResultList();
    }
    
    @Override
    public Collection<FicheHoraire> RechercheFicheHoraireParPeriode(Periode periode) {
        String txt = "SELECT p FROM FicheHoraire p WHERE p.periode=:periode";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("periode", periode);
        return req.getResultList();
    }
    
    @Override
    public Collection<FicheHoraire> RechercheFicheHoraireParLignePeriode(LigneSTR ligne , Periode periode) {
        String txt = "SELECT p FROM FicheHoraire p WHERE p.periode=:periode and p.ligne=:ligne ";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("periode", periode);
        req.setParameter("ligne", ligne);
        return req.getResultList();
    }
    
    @Override
    public FicheHoraire RechercheFicheHoraireParId(Long id) {
        String txt = "SELECT p FROM FicheHoraire p WHERE p.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("id", id);
        return (FicheHoraire)req.getSingleResult();
    }
}
