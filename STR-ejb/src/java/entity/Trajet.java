/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author 5152683
 */
@Entity
public class Trajet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trajet)) {
            return false;
        }
        Trajet other = (Trajet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Trajet[ id=" + id + " ]";
    }

    private Arret Debut;

    /**
     * Get the value of Debut
     *
     * @return the value of Debut
     */
    public Arret getDebut() {
        return Debut;
    }

    /**
     * Set the value of Debut
     *
     * @param Debut new value of Debut
     */
    public void setDebut(Arret Debut) {
        this.Debut = Debut;
    }

    private Arret Fin;

    /**
     * Get the value of Fin
     *
     * @return the value of Fin
     */
    public Arret getFin() {
        return Fin;
    }

    /**
     * Set the value of Fin
     *
     * @param Fin new value of Fin
     */
    public void setFin(Arret Fin) {
        this.Fin = Fin;
    }

    
    @ManyToMany
    private List<Car> listeCar = new ArrayList<Car>();

    public List<Car> getListeCar() {
        return listeCar;
    }

    public void setListeCar(List<Car> listeCar) {
        this.listeCar = listeCar;
    }

    private Double tarifBase;

    public Double getTarifBase() {
        return tarifBase;
    }

    public void setTarifBase(Double tarifBase) {
        this.tarifBase = tarifBase;
    }

    private Double tarifMensuel;

    public Double getTarifMensuel() {
        return tarifMensuel;
    }

    public void setTarifMensuel(Double tarifMensuel) {
        this.tarifMensuel = tarifMensuel;
    }
    
    private Double tarifHebdomadaire;

    public void setTarifHebdomadaire(Double tarifHebdomadaire) {
        this.tarifHebdomadaire = tarifHebdomadaire;
    }

    public Double getTarifHebdomadaire() {
        return tarifHebdomadaire;
    }
    
    @ManyToOne
    private LigneSTR ligne;

    public LigneSTR getLigne() {
        return ligne;
    }

    public void setLigne(LigneSTR ligne) {
        this.ligne = ligne;
    }
   
}
