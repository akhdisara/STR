/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_abonnement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_abonnementFacadeLocal {

    void create(sys_abonnement sys_abonnement);

    void edit(sys_abonnement sys_abonnement);

    void remove(sys_abonnement sys_abonnement);

    sys_abonnement find(Object id);

    List<sys_abonnement> findAll();

    List<sys_abonnement> findRange(int[] range);

    int count();
    
}
