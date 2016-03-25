/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.LigneSTR;
import entity.PositionArretLigne;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
@Stateless
public class PositionArretLigneFacade extends AbstractFacade<PositionArretLigne> implements PositionArretLigneFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PositionArretLigneFacade() {
        super(PositionArretLigne.class);
    }
    
    @Override
    public void ajouterPositionArretLigne(LigneSTR ligne,Arret arret , int position)            
    {
        PositionArretLigne p = new PositionArretLigne();
        p.setLigne(ligne);
        p.setArret(arret);
        p.setPosition(position);
        em.merge(p);
    }
    
    @Override
    public Collection<PositionArretLigne> RecherchePositionParLigne(LigneSTR ligne) {
        String txt = "SELECT p FROM PositionArretLigne p WHERE p.ligne=:ligne order by p.position asc";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ligne", ligne);
        return req.getResultList();
    }
}


