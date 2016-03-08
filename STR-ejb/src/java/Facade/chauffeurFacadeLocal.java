/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Chauffeur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface chauffeurFacadeLocal {

    void create(Chauffeur chauffeur);

    void edit(Chauffeur chauffeur);

    void remove(Chauffeur chauffeur);

    Chauffeur find(Object id);

    List<Chauffeur> findAll();

    List<Chauffeur> findRange(int[] range);

    int count();
    
}
