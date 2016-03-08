/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_abonnement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_abonnementFacadeLocal {

    void create(Sys_abonnement sys_abonnement);

    void edit(Sys_abonnement sys_abonnement);

    void remove(Sys_abonnement sys_abonnement);

    Sys_abonnement find(Object id);

    List<Sys_abonnement> findAll();

    List<Sys_abonnement> findRange(int[] range);

    int count();
    
}
