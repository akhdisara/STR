/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Horaire;
import entity.Ligne;
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

    public Collection<Arret> afficherListeArrets();

    public Arret RechercheArret(Long id);
    public void creerArret(String Nom,String Adresse, List<Trajet> Trajet, List<Horaire> Horaire, List<Ligne> Ligne);
    public void supprimerArret(Arret id);
    public void modifierArret(Arret Ar ,String Nom, String Adresse,List<Trajet> Trajet, List<Horaire> Horaire, List<Ligne> Ligne);
}
