/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_eporte_différé;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_eporte_différéFacadeLocal {

    void create(sys_eporte_différé sys_eporte_différé);

    void edit(sys_eporte_différé sys_eporte_différé);

    void remove(sys_eporte_différé sys_eporte_différé);

    sys_eporte_différé find(Object id);

    List<sys_eporte_différé> findAll();

    List<sys_eporte_différé> findRange(int[] range);

    int count();
    
}
