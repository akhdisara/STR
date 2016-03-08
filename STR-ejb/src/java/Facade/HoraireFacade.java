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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
public class HoraireFacade extends AbstractFacade<Horaire> implements HoraireFacadeLocal {
    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoraireFacade() {
        super(Horaire.class);
    }
public void creerHoraire(Date Heure, Ligne Ligne, Arret Arret, List<Periode> Periode)
    {
        Horaire h = new Horaire();
        h.setHeure(Heure);
        h.setLigne(Ligne);
        h.setArret(Arret);
        h.setListePeriode(Periode);
        getEntityManager().persist(h);
    }  
 public Collection<Horaire>afficherListeHoraire()
    {
        List h;
        String txt="SELECT h FROM Horaire AS h";
                Query req=getEntityManager().createQuery(txt);
                h = req.getResultList();
                return h;
        
    }
  public Horaire RechercheHoraire(Date Heure)
    {
        List h = new ArrayList<Horaire>();
    String txt="SELECT h FROM Horaire h WHERE h.Heure=:Heure";
    Query req=getEntityManager().createQuery(txt);
    req.setParameter("Heure",Heure);
    h = req.getResultList();
    return(Horaire)h.get(0);
    
}
    public void supprimerHoraire(Horaire horaire) {
        horaire = em.merge(horaire);
        em.remove(horaire);
    }
 public void modifierHoraire(Horaire h, Date Heure, Ligne Ligne, Arret Arret, List<Periode> Periode)
    {
        h.setHeure(Heure);
        h.setLigne(Ligne);
        h.setArret(Arret);
        h.setListePeriode(Periode);
        em.merge(h);
    }  

    @Override
    public void modifierCar(Car car, String Identifiant, List<Trajet> Trajet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
