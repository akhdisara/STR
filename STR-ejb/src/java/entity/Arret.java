/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Arret implements Serializable {
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
        if (!(object instanceof Arret)) {
            return false;
        }
        Arret other = (Arret) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Arret[ id=" + id + " ]";
    }
   
    private String Nom;

    /**
     * Get the value of Nom
     *
     * @return the value of Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Set the value of Nom
     *
     * @param Nom new value of Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
 
    private String Adresse;

    /**
     * Get the value of Adresse
     *
     * @return the value of Adresse
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * Set the value of Adresse
     *
     * @param Adresse new value of Adresse
     */
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
@ManyToMany
private List<Trajet> listeTrajet = new ArrayList<Trajet>();

    public List<Trajet> getListeTrajet() {
        return listeTrajet;
    }

    public void setListeTrajet(List<Trajet> listeTrajet) {
        this.listeTrajet = listeTrajet;
    }


    @OneToMany (mappedBy="arret")
    List<PositionArretLigne> positions = new ArrayList<PositionArretLigne>();

    public List<PositionArretLigne> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionArretLigne> positions) {
        this.positions = positions;
    }
    
    @OneToMany (mappedBy="arret")
    List<PlageHoraire> plagesHoraires = new ArrayList<PlageHoraire>();

    public void setPlagesHoraires(List<PlageHoraire> plagesHoraires) {
        this.plagesHoraires = plagesHoraires;
    }

    public List<PlageHoraire> getPlagesHoraires() {
        return plagesHoraires;
    }
    
    
    
    
}
