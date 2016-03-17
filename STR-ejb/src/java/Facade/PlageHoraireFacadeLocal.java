/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.FicheHoraire;
import entity.PlageHoraire;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5150796
 */
@Local
public interface PlageHoraireFacadeLocal {

    void create(PlageHoraire plageHoraire);

    void edit(PlageHoraire plageHoraire);

    void remove(PlageHoraire plageHoraire);

    PlageHoraire find(Object id);

    List<PlageHoraire> findAll();

    List<PlageHoraire> findRange(int[] range);

    int count();
    
    void creerPlageHoraire(FicheHoraire ficheHoraire , Arret arret , Date horaire);
    
    void modifierPlageHoraire(PlageHoraire plage , FicheHoraire ficheHoraire , Arret arret , Date horaire);
    
    void supprimerPlageHoraire(PlageHoraire plage);
    
    Collection<PlageHoraire> RecherchePlagesHorairesParArret(Arret arret);
    
    Collection<PlageHoraire> RecherchePlagesHorairesParHoraire(Date horaire);
    
    Collection<PlageHoraire> RecherchePlagesHorairesParFicheHoraire(FicheHoraire ficheHoraire);
}
