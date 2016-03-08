/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Car;
import entity.Tarifs;
import entity.Trajet;
import entity.Type_Paiement;
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
    public void creerTrajet(Arret Debut,Arret Fin,Date Heure_depart, Date Heure_Arrivé, Integer Kilométrage,List<Arret> Arret, List<Car> Car, List<Type_Paiement> Type_Paiement, List<Tarifs> Tarifs);
    public Trajet RechercheTrajet(Long id);
     public void modifierTrajet(Long id, Arret Debut,Arret Fin,Date Heure_depart, Date Heure_Arrivé, Integer Kilométrage,List<Arret> Arret, List<Car> Car, List<Type_Paiement> Type_Paiement, List<Tarifs> Tarifs);
    public void supprimerTrajet(Trajet trajet);
     public Collection<Trajet>afficherListeTrajet();
}
