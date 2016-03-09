/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Categorie_voyageur;
import entity.Ligne;
import entity.Periode;
import entity.Tarifs;
import entity.Trajet;
import entity.Type_Paiement;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface TarifsFacadeLocal {

    void create(Tarifs tarifs);

    void edit(Tarifs tarifs);

    void remove(Tarifs tarifs);

    Tarifs find(Object id);

    List<Tarifs> findAll();

    List<Tarifs> findRange(int[] range);

    int count();
        
    void creerTarif(Ligne ligne,Trajet trajet,Categorie_voyageur categorie_voyageur ,float prix ,Periode periode);
    Collection<Tarifs> afficherListeTarifs();
    Collection<Tarifs> RechercheTarifsParLigne(Ligne ligne);
    Collection<Tarifs> RechercheTarifsParTrajet(Trajet trajet);
    void supprimerTarifs(Tarifs tarifs);
    void modifierTarifs(Tarifs tarif,Ligne ligne, Trajet trajet, Categorie_voyageur categorie_voyageur, float prix, Periode periode);
    Collection<Tarifs> RechercheTarifsParPeriode(Periode periode);
    Collection<Tarifs> RechercheTarifsParTypePaiement(Type_Paiement typePaiement);
     public Tarifs RechercheTarifsParId(Long id);
}
