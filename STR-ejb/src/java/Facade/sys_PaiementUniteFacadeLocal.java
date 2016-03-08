/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_PaiementUnite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_PaiementUniteFacadeLocal {

    void create(sys_PaiementUnite sys_PaiementUnite);

    void edit(sys_PaiementUnite sys_PaiementUnite);

    void remove(sys_PaiementUnite sys_PaiementUnite);

    sys_PaiementUnite find(Object id);

    List<sys_PaiementUnite> findAll();

    List<sys_PaiementUnite> findRange(int[] range);

    int count();
    
}
