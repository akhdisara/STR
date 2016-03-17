/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Reduction;
import entity.TypeReduction;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sara
 */
@Local
public interface ReductionFacadeLocal {

    void create(Reduction reduction);

    void edit(Reduction reduction);

    void remove(Reduction reduction);

    Reduction find(Object id);

    List<Reduction> findAll();

    List<Reduction> findRange(int[] range);

    int count();
    
    void creerReduction(TypeReduction type , int taux);
    
    Collection<Reduction> afficherListeReductions();
    
    Reduction RechercheReduction(long id);
    
    void supprimerReduction(Reduction reduction);
    
    void modifierReduction(Reduction reduction, TypeReduction type, int taux);
    
    Reduction RechercheReductionParType(TypeReduction typeReduction);
}
