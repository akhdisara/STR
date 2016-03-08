/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Prépayé;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface PrépayéFacadeLocal {

    void create(Prépayé prépayé);

    void edit(Prépayé prépayé);

    void remove(Prépayé prépayé);

    Prépayé find(Object id);

    List<Prépayé> findAll();

    List<Prépayé> findRange(int[] range);

    int count();
    
}
