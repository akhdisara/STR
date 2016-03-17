/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.FicheHoraire;
import entity.LigneSTR;
import entity.Periode;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5150796
 */
@Local
public interface FicheHoraireFacadeLocal {

    void create(FicheHoraire ficheHoraire);

    void edit(FicheHoraire ficheHoraire);

    void remove(FicheHoraire ficheHoraire);

    FicheHoraire find(Object id);

    List<FicheHoraire> findAll();

    List<FicheHoraire> findRange(int[] range);

    int count();
    
    Long creerFicheHoraire(LigneSTR ligne,Periode periode);
    void modifierFicheHoraire(FicheHoraire fiche,LigneSTR ligne,Periode periode);
    void supprimerFicheHoraire(FicheHoraire fiche);
    Collection<FicheHoraire> RechercheFicheHoraireParLigne(LigneSTR ligne);
    FicheHoraire RechercheFicheHoraireParId(Long id);
    Collection<FicheHoraire> RechercheFicheHoraireParLignePeriode(LigneSTR ligne , Periode periode);
    Collection<FicheHoraire> RechercheFicheHoraireParPeriode(Periode periode);
}
