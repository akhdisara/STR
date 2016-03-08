/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_eporte_prepaye;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_eporte_prépayéFacadeLocal {

    void create(Sys_eporte_prepaye sys_eporte_prépayé);

    void edit(Sys_eporte_prepaye sys_eporte_prépayé);

    void remove(Sys_eporte_prepaye sys_eporte_prépayé);

    Sys_eporte_prepaye find(Object id);

    List<Sys_eporte_prepaye> findAll();

    List<Sys_eporte_prepaye> findRange(int[] range);

    int count();
    
}
