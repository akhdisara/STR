/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.sys_PaiementChauffeur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 5152683
 */
@Local
public interface sys_PaiementChauffeurFacadeLocal {

    void create(sys_PaiementChauffeur sys_PaiementChauffeur);

    void edit(sys_PaiementChauffeur sys_PaiementChauffeur);

    void remove(sys_PaiementChauffeur sys_PaiementChauffeur);

    sys_PaiementChauffeur find(Object id);

    List<sys_PaiementChauffeur> findAll();

    List<sys_PaiementChauffeur> findRange(int[] range);

    int count();
    
}
