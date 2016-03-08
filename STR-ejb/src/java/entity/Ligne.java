/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author 5152683
 */
@Entity
public class Ligne implements Serializable {
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
        if (!(object instanceof Ligne)) {
            return false;
        }
        Ligne other = (Ligne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ligne[ id=" + id + " ]";
    }
  @Column(name="DESC", nullable=false, length=512)
    private String Identifiant;

    /**
     * Get the value of Identifiant
     *
     * @return the value of Identifiant
     */
    public String getIdentifiant() {
        return Identifiant;
    }

    /**
     * Set the value of Identifiant
     *
     * @param Identifiant new value of Identifiant
     */
    public void setIdentifiant(String Identifiant) {
        this.Identifiant = Identifiant;
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
    @ManyToMany(mappedBy="Ligne")
    private List<Tarifs> listeTarifs = new ArrayList<Tarifs>();

    public List<Tarifs> getListeTarifs() {
        return listeTarifs;
    }

    public void setListeTarifs(List<Tarifs> listeTarifs) {
        this.listeTarifs = listeTarifs;
    }
    @ManyToMany (mappedBy="Ligne")
    private List<Arret> listeArret = new ArrayList<Arret>();

    public List<Arret> getListeArret() {
        return listeArret;
    }

    public void setListeArret(List<Arret> listeArret) {
        this.listeArret = listeArret;
    }
    @OneToMany(mappedBy="Ligne")
    private List<Horaire> listeHoraire = new ArrayList<Horaire>();

    public List<Horaire> getListeHoraire() {
        return listeHoraire;
    }

    public void setListeHoraire(List<Horaire> listeHoraire) {
        this.listeHoraire = listeHoraire;
    }
    
    

}
