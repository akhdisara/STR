/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Car;
import entity.Trajet;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface CarFacadeLocal {

    void create(Car car);

    void edit(Car car);

    void remove(Car car);

    Car find(Object id);

    List<Car> findAll();

    List<Car> findRange(int[] range);

    int count();
    public void creerCar(String Identifiant, List<Trajet> Trajet);
    public Car RechercheCar(String Identifiant);
    public void supprimerCar(Car car);
    public void modifierCar(Car car , String Identifiant, List<Trajet> Trajet);
    public Collection<Car>afficherListeCars();
}
