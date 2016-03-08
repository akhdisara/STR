/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 5152683
 */
@Entity
public class Tarifs implements Serializable {
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
        if (!(object instanceof Tarifs)) {
            return false;
        }
        Tarifs other = (Tarifs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tarifs[ id=" + id + " ]";
    }
   
    private Float Prix;

    /**
     * Get the value of Prix
     *
     * @return the value of Prix
     */
    public Float getPrix() {
        return Prix;
    }

    /**
     * Set the value of Prix
     *
     * @param Prix new value of Prix
     */
    public void setPrix(Float Prix) {
        this.Prix = Prix;
    }

 
 
 
 
  
     @ManyToOne
    private Trajet Trajet;

    /**
     * Get the value of Trajet
     *
     * @return the value of Trajet
     */
    public Trajet getTrajet() {
        return Trajet;
    }

    /**
     * Set the value of Trajet
     *
     * @param Trajet new value of Trajet
     */
    public void setTrajet(Trajet Trajet) {
        this.Trajet = Trajet;
    }


    /**
     * Get the value of Categorie_voyageur
     *
     * @return the value of Categorie_voyageur
     */
    private Catégorie_voyageur Categorie_voyageur;
    public Catégorie_voyageur getCategorie_voyageur() {
        return Categorie_voyageur;
    }

    /**
     * Set the value of Categorie_voyageur
     *
     * @param Categorie_voyageur new value of Categorie_voyageur
     */
    public void setCategorie_voyageur(Catégorie_voyageur Categorie_voyageur) {
        this.Categorie_voyageur = Categorie_voyageur;
    }
    @ManyToOne
    

    private Ligne Ligne;

    /**
     * Get the value of Ligne
     *
     * @return the value of Ligne
     */
    public Ligne getLigne() {
        return Ligne;
    }

    /**
     * Set the value of Ligne
     *
     * @param Ligne new value of Ligne
     */
    public void setLigne(Ligne Ligne) {
        this.Ligne = Ligne;
    }
    
    private Periode Periode;

    /**
     * Get the value of Periode
     *
     * @return the value of Periode
     */
    public Periode getPeriode() {
        return Periode;
    }

    /**
     * Set the value of Periode
     *
     * @param Periode new value of Periode
     */
    public void setPeriode(Periode Periode) {
        this.Periode = Periode;
    }

}
