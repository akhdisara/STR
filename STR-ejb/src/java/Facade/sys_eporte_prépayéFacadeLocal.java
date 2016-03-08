/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_eporte_prépayé;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_eporte_prépayéFacadeLocal {

    void create(sys_eporte_prépayé sys_eporte_prépayé);

    void edit(sys_eporte_prépayé sys_eporte_prépayé);

    void remove(sys_eporte_prépayé sys_eporte_prépayé);

    sys_eporte_prépayé find(Object id);

    List<sys_eporte_prépayé> findAll();

    List<sys_eporte_prépayé> findRange(int[] range);

    int count();
    
}
