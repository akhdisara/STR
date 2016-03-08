/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Tarifs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface TarifsFacadeLocal {

    void create(Tarifs tarifs);

    void edit(Tarifs tarifs);

    void remove(Tarifs tarifs);

    Tarifs find(Object id);

    List<Tarifs> findAll();

    List<Tarifs> findRange(int[] range);

    int count();
    
}
