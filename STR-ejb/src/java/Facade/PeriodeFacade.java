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
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void creerPeriode(Date Date_debut, Date Date_fin,Type_periode Type_periode, Horaire Horaire, List<Tarifs> Tarifs)
    {
        Periode p = new Periode();
        p.setDate_debut(Date_debut);
        p.setDate_fin(Date_fin);
        p.setType_Periode(Type_periode);
        p.setHoraire(Horaire);
        p.setlisteTarifs(Tarifs);
        getEntityManager().persist(p);
    }  
}
