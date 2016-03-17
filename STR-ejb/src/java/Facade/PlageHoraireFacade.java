/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.FicheHoraire;
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
public class PlageHoraireFacade extends AbstractFacade<PlageHoraire> implements PlageHoraireFacadeLocal {

    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlageHoraireFacade() {
        super(PlageHoraire.class);
    }

    @Override
    public void creerPlageHoraire(FicheHoraire ficheHoraire, Arret arret, Date horaire) {
        PlageHoraire plage = new PlageHoraire();
        plage.setArret(arret);
        plage.setHoraire(horaire);
        plage.setFicheHoraire(ficheHoraire);
        em.persist(plage);
    }

    @Override
    public void modifierPlageHoraire(PlageHoraire plage, FicheHoraire ficheHoraire, Arret arret, Date horaire) {
        plage.setArret(arret);
        plage.setHoraire(horaire);
        plage.setFicheHoraire(ficheHoraire);
        em.merge(plage);
    }

    @Override
    public void supprimerPlageHoraire(PlageHoraire plage) {
        plage = em.merge(plage);
        em.remove(plage);
    }

    @Override
    public Collection<PlageHoraire> RecherchePlagesHorairesParArret(Arret arret) {
        String txt = "SELECT p FROM PlageHoraire p WHERE p.arret=:arret";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("arret", arret);
        return req.getResultList();
    }
    
    @Override
    public Collection<PlageHoraire> RecherchePlagesHorairesParHoraire(Date horaire) {
        String txt = "SELECT p FROM PlageHoraire p WHERE p.horaire=:horaire";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("horaire", horaire);
        return req.getResultList();
    }
    
    @Override
    public Collection<PlageHoraire> RecherchePlagesHorairesParFicheHoraire(FicheHoraire ficheHoraire) {
        String txt = "SELECT p FROM PlageHoraire p WHERE p.ficheHoraire=:ficheHoraire";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ficheHoraire", ficheHoraire);
        return req.getResultList();
    }
}
