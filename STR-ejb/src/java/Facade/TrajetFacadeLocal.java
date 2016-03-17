/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Car;
import entity.FicheHoraire;
import entity.LigneSTR;
import entity.Trajet;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface TrajetFacadeLocal {

    void create(Trajet trajet);

    void edit(Trajet trajet);

    void remove(Trajet trajet);

    Trajet find(Object id);

    List<Trajet> findAll();

    List<Trajet> findRange(int[] range);

    int count();

    void creerTrajet(LigneSTR ligne,Arret Debut, Arret Fin, double tarifBase, double TarifMensuel, double tarifHebdomadaire, List<Car> Car);

    Trajet RechercheTrajet(Long id);

    void modifierTrajet(Trajet T, LigneSTR ligne,Arret Debut, Arret Fin, double tarifBase, double TarifMensuel, double tarifHebdomadaire, List<Car> Car);

    void supprimerTrajet(Trajet trajet);

    Collection<Trajet> afficherListeTrajet();
    
    double TarifBaseParArrets(LigneSTR l , Arret debut , Arret arrivee);
    
    double TarifMensuelParArrets(LigneSTR ligne, Arret debut, Arret arrivee);
    
    double TarifHebdomadaireParArrets(LigneSTR ligne, Arret debut, Arret arrivee);
    
    List<Trajet> RechercheTrajetParLigne(LigneSTR ligne);
    

}
