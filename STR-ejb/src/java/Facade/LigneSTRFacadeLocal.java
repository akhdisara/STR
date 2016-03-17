/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Arret;
import entity.LigneSTR;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5150796
 */
@Local
public interface LigneSTRFacadeLocal {

    void create(LigneSTR ligneSTR);

    void edit(LigneSTR ligneSTR);

    void remove(LigneSTR ligneSTR);

    LigneSTR find(Object id);

    List<LigneSTR> findAll();

    List<LigneSTR> findRange(int[] range);

    int count();

    public Collection<LigneSTR> afficherListeLigne();

    public void creerLigne(String Identifiant);

    public LigneSTR RechercheLigne(String Identifiant);

    public void supprimerLigne(LigneSTR Ligne);

    LigneSTR RechercheLigneParId(Long id);

    public void modifierLigne(LigneSTR L, String Identifiant, Arret Debut, Arret Fin);
}
