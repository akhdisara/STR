/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Car;
import entity.LigneSTR;
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
public class TrajetFacade extends AbstractFacade<Trajet> implements TrajetFacadeLocal {

    @PersistenceContext(unitName = "STR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrajetFacade() {
        super(Trajet.class);
    }

    @Override
    public void creerTrajet(LigneSTR ligne, Arret Debut, Arret Fin, double tarifBase, double TarifMensuel, double tarifHebdomadaire, List<Car> Car) {
        Trajet T = new Trajet();
        T.setLigne(ligne);
        T.setDebut(Debut);
        T.setFin(Fin);
        T.setTarifBase(tarifBase);
        T.setTarifMensuel(TarifMensuel);
        T.setTarifHebdomadaire(tarifHebdomadaire);
        T.setListeCar(Car);
        getEntityManager().persist(T);
    }

    @Override
    public Collection<Trajet> afficherListeTrajet() {
        List T;
        String txt = "SELECT T FROM Trajet AS T";
        Query req = getEntityManager().createQuery(txt);
        T = req.getResultList();
        return T;

    }

    @Override
    public Trajet RechercheTrajet(Long id) {
        List T = new ArrayList<Trajet>();
        String txt = "SELECT T FROM Trajet T WHERE T.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("id", id);
        T = req.getResultList();
        return (Trajet) T.get(0);

    }
    
    @Override
    public List<Trajet> RechercheTrajetParLigne(LigneSTR ligne) {
        List T = new ArrayList<Trajet>();
        String txt = "SELECT T FROM Trajet T WHERE T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ligne", ligne);
        return  req.getResultList();
    }

    @Override
    public void supprimerTrajet(Trajet trajet) {
        trajet = em.merge(trajet);
        em.remove(trajet);
    }

    @Override
    public void modifierTrajet(Trajet T, LigneSTR ligne, Arret Debut, Arret Fin, double tarifBase, double TarifMensuel, double tarifHebdomadaire, List<Car> Car) {
        T.setDebut(Debut);
        T.setFin(Fin);
        T.setListeCar(Car);
        em.merge(T);
    }

    @Override
    public double TarifBaseParArrets(LigneSTR ligne, Arret debut, Arret arrivee) {
        String txt = "SELECT T FROM Trajet T WHERE T.Debut=:Debut and T.Fin=:Fin and T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("Debut", debut);        
        req.setParameter("Fin", arrivee);        
        req.setParameter("ligne", ligne);   
        Trajet t = (Trajet)req.getResultList().get(0);
        return t.getTarifBase() ;
    }
    
    @Override
    public double TarifMensuelParArrets(LigneSTR ligne, Arret debut, Arret arrivee) {
        String txt = "SELECT T FROM Trajet T WHERE T.Debut=:Debut and T.Fin=:Fin and T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("Debut", debut);        
        req.setParameter("Fin", arrivee);        
        req.setParameter("ligne", ligne);   
        Trajet t = (Trajet)req.getResultList().get(0);
        return t.getTarifMensuel();
    }
    
    @Override
    public double TarifHebdomadaireParArrets(LigneSTR ligne, Arret debut, Arret arrivee) {
        String txt = "SELECT T FROM Trajet T WHERE T.Debut=:Debut and T.Fin=:Fin and T.ligne=:ligne";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("Debut", debut);        
        req.setParameter("Fin", arrivee);        
        req.setParameter("ligne", ligne);   
        Trajet t = (Trajet)req.getResultList().get(0);
        return t.getTarifHebdomadaire();
    }
}
