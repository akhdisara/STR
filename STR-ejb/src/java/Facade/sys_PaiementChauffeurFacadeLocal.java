/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Sys_PaiementChauffeur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_PaiementChauffeurFacadeLocal {

    void create(Sys_PaiementChauffeur sys_PaiementChauffeur);

    void edit(Sys_PaiementChauffeur sys_PaiementChauffeur);

    void remove(Sys_PaiementChauffeur sys_PaiementChauffeur);

    Sys_PaiementChauffeur find(Object id);

    List<Sys_PaiementChauffeur> findAll();

    List<Sys_PaiementChauffeur> findRange(int[] range);

    int count();
    
}
