/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_eporte_prepaye;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 5152683
 */
@Stateless
public class sys_eporte_prépayéFacade extends AbstractFacade<Sys_eporte_prepaye> implements sys_eporte_prépayéFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public sys_eporte_prépayéFacade() {
        super(Sys_eporte_prepaye.class);
    }
    
}
