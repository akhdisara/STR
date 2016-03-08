/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_eporte_differe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_eporte_différéFacadeLocal {

    void create(Sys_eporte_differe sys_eporte_différé);

    void edit(Sys_eporte_differe sys_eporte_différé);

    void remove(Sys_eporte_differe sys_eporte_différé);

    Sys_eporte_differe find(Object id);

    List<Sys_eporte_differe> findAll();

    List<Sys_eporte_differe> findRange(int[] range);

    int count();
    
}
