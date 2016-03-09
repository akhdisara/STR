/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Horaire;
import entity.Periode;
import entity.Tarifs;
import entity.Type_periode;
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
public class PeriodeFacade extends AbstractFacade<Periode> implements PeriodeFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodeFacade() {
        super(Periode.class);
    }
    @Override
    public void creerPeriode(Date Date_debut, Date Date_fin,Type_periode Type_periode, Horaire Horaire, List<Tarifs> Tarifs)
    {
        Periode p = new Periode();
        p.setDate_debut(Date_debut);
        p.setDate_fin(Date_fin);
        p.setType_Periode(Type_periode);
        p.setHoraire(Horaire);
        p.setListeTarifs(Tarifs);
        getEntityManager().persist(p);
    }  
    @Override
    public Collection<Periode>afficherListePeriode()
    {
        List p;
        String txt="SELECT p FROM Periode AS p";
                Query req=getEntityManager().createQuery(txt);
                p = req.getResultList();
                return p;
        
    }
    @Override
     public Periode RecherchePeriode(Type_periode Type_periode)
    {
        List p = new ArrayList<Periode>();
    String txt="SELECT p FROM Periode p WHERE p.Type_periode=:Type_periode";
    Query req=getEntityManager().createQuery(txt);
    req.setParameter("Type_periode",Type_periode);
    p = req.getResultList();
    return(Periode)p.get(0);
    
}
     @Override
      public void supprimerPeriode(Periode periode) {
        periode = em.merge(periode);
        em.remove(periode);
    }
      @Override
      public void modifierPeriode(Periode p, Date Date_debut, Date Date_fin,Type_periode Type_periode, Horaire Horaire, List<Tarifs> Tarifs)
    {
        p.setDate_debut(Date_debut);
        p.setDate_fin(Date_fin);
        p.setType_Periode(Type_periode);
        p.setHoraire(Horaire);
        p.setListeTarifs(Tarifs);
        em.merge(p);
    }
      
}
