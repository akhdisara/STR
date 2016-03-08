/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Car;
import entity.Trajet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 5152683
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> implements CarFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarFacade() {
        super(Car.class);
    }
   public void creerCar(String Identifiant, List<Trajet> Trajet)
    {
        Car c = new Car();
        c.setIdentifiant(Identifiant);
        c.setListeTrajet(Trajet);
        getEntityManager().persist(c);
    }
    public Collection<Car>afficherListeCars()
    {
        List c;
        String txt="SELECT c FROM Car AS c";
                Query req=getEntityManager().createQuery(txt);
                c = req.getResultList();
                return c;
        
    }
    public Car RechercheCar(String Identifiant)
    {
        List c = new ArrayList<Car>();
    String txt="SELECT c FROM Car c WHERE r.Identifiant=:Identifiant";
    Query req=getEntityManager().createQuery(txt);
    req.setParameter("Identifiant",Identifiant);
    c = req.getResultList();
    return(Car)c.get(0);
    
}
    public void supprimerCar(Car car) {
        car = em.merge(car);
        em.remove(car);
    }
    public void modifierCar(Car car , String Identifiant, List<Trajet> Trajet)
    {
        car.setIdentifiant(Identifiant);
        car.setListeTrajet(Trajet);
        em.merge(car);
    }  
}
