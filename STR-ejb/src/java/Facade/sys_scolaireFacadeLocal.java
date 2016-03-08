/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_scolaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_scolaireFacadeLocal {

    void create(Sys_scolaire sys_scolaire);

    void edit(Sys_scolaire sys_scolaire);

    void remove(Sys_scolaire sys_scolaire);

    Sys_scolaire find(Object id);

    List<Sys_scolaire> findAll();

    List<Sys_scolaire> findRange(int[] range);

    int count();
    
}
