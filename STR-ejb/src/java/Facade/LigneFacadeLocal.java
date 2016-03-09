/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.Horaire;
import entity.Ligne;
import entity.Tarifs;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface LigneFacadeLocal {

    void create(Ligne ligne);

    void edit(Ligne ligne);

    void remove(Ligne ligne);

    Ligne find(Object id);

    List<Ligne> findAll();

    List<Ligne> findRange(int[] range);

    int count();
    public Collection<Ligne>afficherListeLigne();
    public void creerLigne(String Identifiant,Arret Debut,Arret Fin, List<Tarifs> Tarifs, List<Horaire> Horaire, List<Arret> Arret);
     public Ligne RechercheLigne(String Identifiant);
     public void supprimerLigne(Ligne Ligne);
     Ligne RechercheLigneParId(Long id);
      public void modifierLigne(Ligne L,String Identifiant,Arret Debut,Arret Fin, List<Tarifs> Tarifs, List<Horaire> Horaire, List<Arret> Arret);
}
