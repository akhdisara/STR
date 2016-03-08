/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_eporte_différé;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 5152683
 */
@Stateless
public class sys_eporte_différéFacade extends AbstractFacade<sys_eporte_différé> implements sys_eporte_différéFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public sys_eporte_différéFacade() {
        super(sys_eporte_différé.class);
    }
    
}
