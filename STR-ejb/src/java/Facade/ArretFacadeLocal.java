/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Trajet;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface ArretFacadeLocal {

    void create(Arret arret);

    void edit(Arret arret);

    void remove(Arret arret);

    Arret find(Object id);

    List<Arret> findAll();

    List<Arret> findRange(int[] range);

    int count();

     Collection<Arret> afficherListeArrets();

     Arret RechercheArret(Long id);
     void creerArret(String Nom,String Adresse, List<Trajet> Trajet);
     void supprimerArret(Arret id);
     void modifierArret(Arret Ar ,String Nom, String Adresse,List<Trajet> Trajet);
     Arret RechercheArretParNom(String nom);
}
