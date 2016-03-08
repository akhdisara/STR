/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.chauffeur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface chauffeurFacadeLocal {

    void create(chauffeur chauffeur);

    void edit(chauffeur chauffeur);

    void remove(chauffeur chauffeur);

    chauffeur find(Object id);

    List<chauffeur> findAll();

    List<chauffeur> findRange(int[] range);

    int count();
    
}
