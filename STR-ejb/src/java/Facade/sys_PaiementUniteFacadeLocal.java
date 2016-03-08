/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_PaiementUnite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_PaiementUniteFacadeLocal {

    void create(Sys_PaiementUnite sys_PaiementUnite);

    void edit(Sys_PaiementUnite sys_PaiementUnite);

    void remove(Sys_PaiementUnite sys_PaiementUnite);

    Sys_PaiementUnite find(Object id);

    List<Sys_PaiementUnite> findAll();

    List<Sys_PaiementUnite> findRange(int[] range);

    int count();
    
}
