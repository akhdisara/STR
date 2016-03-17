/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Car;
import entity.Reduction;
import entity.Trajet;
import entity.TypeReduction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
@Stateless
public class ReductionFacade extends AbstractFacade<Reduction> implements ReductionFacadeLocal {

    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReductionFacade() {
        super(Reduction.class);
    }

    @Override
    public void creerReduction(TypeReduction type, int taux) {
        Reduction r = new Reduction();
        r.setTauxReduction(taux);
        r.setTypeReduction(type);
        em.merge(r);
    }

    @Override
    public Collection<Reduction> afficherListeReductions() {
        String txt = "SELECT r FROM Reduction AS r";
        Query req = getEntityManager().createQuery(txt);
        return req.getResultList();
    }

    @Override
    public Reduction RechercheReduction(long id) {
        String txt = "SELECT r FROM Reduction r WHERE r.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("id", id);
        return (Reduction) req.getResultList().get(0);
    }
    
    @Override
    public Reduction RechercheReductionParType(TypeReduction typeReduction) {
        String txt = "SELECT r FROM Reduction r WHERE r.typeReduction =:typeReduction";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("typeReduction", typeReduction);
        return (Reduction) req.getResultList().get(0);
    }

    @Override
    public void supprimerReduction(Reduction reduction) {
        reduction = em.merge(reduction);
        em.remove(reduction);
    }

    @Override
    public void modifierReduction(Reduction reduction, TypeReduction type, int taux) {
        reduction.setTauxReduction(taux);
        reduction.setTypeReduction(type);
        em.merge(reduction);
    }
}
