/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Car;
import entity.Horaire;
import entity.Ligne;
import entity.Periode;
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
public interface HoraireFacadeLocal {

    void create(Horaire horaire);

    void edit(Horaire horaire);

    void remove(Horaire horaire);

    Horaire find(Object id);

    List<Horaire> findAll();

    List<Horaire> findRange(int[] range);

    int count();
    public void creerHoraire(Date Heure, Ligne Ligne, Arret Arret, List<Periode> Periode);
    public Collection<Horaire>afficherListeHoraire();
    public Horaire RechercheHoraire(Date Heure);
    public void supprimerHoraire(Horaire horaire);
    public void modifierCar(Car car , String Identifiant, List<Trajet> Trajet);
}
