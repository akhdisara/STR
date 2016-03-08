/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Prepaye;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface PrépayéFacadeLocal {

    void create(Prepaye prépayé);

    void edit(Prepaye prépayé);

    void remove(Prepaye prépayé);

    Prepaye find(Object id);

    List<Prepaye> findAll();

    List<Prepaye> findRange(int[] range);

    int count();
    
}
