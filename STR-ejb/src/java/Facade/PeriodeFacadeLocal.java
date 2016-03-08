/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Horaire;
import entity.Periode;
import entity.Tarifs;
import entity.Type_periode;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface PeriodeFacadeLocal {

    void create(Periode periode);

    void edit(Periode periode);

    void remove(Periode periode);

    Periode find(Object id);

    List<Periode> findAll();

    List<Periode> findRange(int[] range);

    int count();
     public void creerPeriode(Date Date_debut, Date Date_fin,Type_periode Type_periode, Horaire Horaire, List<Tarifs> Tarifs);
         public Collection<Periode>afficherListePeriode();
         public Periode RecherchePeriode(Type_periode Type_periode);
         public void supprimerPeriode(Periode periode);
         public void modifierPeriode(Periode p, Date Date_debut, Date Date_fin,Type_periode Type_periode, Horaire Horaire, List<Tarifs> Tarifs);
    
}
