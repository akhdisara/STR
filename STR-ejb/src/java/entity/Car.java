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

/**
 *
 * @author 5152683
 */
@Entity
public class Car implements Serializable {
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
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Car[ id=" + id + " ]";
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
  @ManyToMany
  private List<Trajet> listeTrajet = new ArrayList<Trajet>();

    public List<Trajet> getListeTrajet() {
        return listeTrajet;
    }

    public void setListeTrajet(List<Trajet> listeTrajet) {
        this.listeTrajet = listeTrajet;
    }
  
}
