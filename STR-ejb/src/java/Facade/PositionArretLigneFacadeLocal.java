/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.LigneSTR;
import entity.PositionArretLigne;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sara
 */
@Local
public interface PositionArretLigneFacadeLocal {

    void create(PositionArretLigne positionArretLigne);

    void edit(PositionArretLigne positionArretLigne);

    void remove(PositionArretLigne positionArretLigne);

    PositionArretLigne find(Object id);

    List<PositionArretLigne> findAll();

    List<PositionArretLigne> findRange(int[] range);

    int count();
    
    void ajouterPositionArretLigne(LigneSTR ligne,Arret arret , int position);
    
    Collection<PositionArretLigne> RecherchePositionParLigne(LigneSTR ligne);
}
