/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Différé;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface DifféréFacadeLocal {

    void create(Différé différé);

    void edit(Différé différé);

    void remove(Différé différé);

    Différé find(Object id);

    List<Différé> findAll();

    List<Différé> findRange(int[] range);

    int count();
    
}
