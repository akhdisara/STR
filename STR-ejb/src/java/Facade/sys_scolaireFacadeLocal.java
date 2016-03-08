/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_scolaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_scolaireFacadeLocal {

    void create(sys_scolaire sys_scolaire);

    void edit(sys_scolaire sys_scolaire);

    void remove(sys_scolaire sys_scolaire);

    sys_scolaire find(Object id);

    List<sys_scolaire> findAll();

    List<sys_scolaire> findRange(int[] range);

    int count();
    
}
