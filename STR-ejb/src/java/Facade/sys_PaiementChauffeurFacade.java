/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_PaiementChauffeur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 5152683
 */
@Stateless
public class sys_PaiementChauffeurFacade extends AbstractFacade<sys_PaiementChauffeur> implements sys_PaiementChauffeurFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public sys_PaiementChauffeurFacade() {
        super(sys_PaiementChauffeur.class);
    }
    
}
