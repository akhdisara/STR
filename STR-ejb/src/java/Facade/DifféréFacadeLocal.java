/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Differe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface DifféréFacadeLocal {

    void create(Differe différé);

    void edit(Differe différé);

    void remove(Differe différé);

    Differe find(Object id);

    List<Differe> findAll();

    List<Differe> findRange(int[] range);

    int count();
    
}
