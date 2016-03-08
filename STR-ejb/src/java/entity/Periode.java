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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author 5152683
 */
@Entity
public class Periode implements Serializable {
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
        if (!(object instanceof Periode)) {
            return false;
        }
        Periode other = (Periode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Periode[ id=" + id + " ]";
    }
 
 @Temporal(javax.persistence.TemporalType.DATE)
    private Date Date_debut;

    /**
     * Get the value of Date_debut
     *
     * @return the value of Date_debut
     */
    public Date getDate_debut() {
        return Date_debut;
    }

    /**
     * Set the value of Date_debut
     *
     * @param Date_debut new value of Date_debut
     */
    public void setDate_debut(Date Date_debut) {
        this.Date_debut = Date_debut;
    }
   
 @Temporal(javax.persistence.TemporalType.DATE)
    private Date Date_fin;

    /**
     * Get the value of Date_fin
     *
     * @return the value of Date_fin
     */
    public Date getDate_fin() {
        return Date_fin;
    }

    /**
     * Set the value of Date_fin
     *
     * @param Date_fin new value of Date_fin
     */
    public void setDate_fin(Date Date_fin) {
        this.Date_fin = Date_fin;
    }

    private Type_periode Type_Periode;

    /**
     * Get the value of Type_Periode
     *
     * @return the value of Type_Periode
     */
    public Type_periode getType_Periode() {
        return Type_Periode;
    }

    /**
     * Set the value of Type_Periode
     *
     * @param Type_Periode new value of Type_Periode
     */
    public void setType_Periode(Type_periode Type_Periode) {
        this.Type_Periode = Type_Periode;
    }
    @ManyToOne
   

    private Horaire Horaire;

    /**
     * Get the value of Horaire
     *
     * @return the value of Horaire
     */
    public Horaire getHoraire() {
        return Horaire;
    }

    /**
     * Set the value of Horaire
     *
     * @param Horaire new value of Horaire
     */
    public void setHoraire(Horaire Horaire) {
        this.Horaire = Horaire;
    }
    @OneToMany
    private List<Tarifs> listeTarifs = new ArrayList<Tarifs>();
    
    public List<Tarifs> getListeTarifs() {
        return listeTarifs;
}

    public void setListeTarifs(List<Tarifs> listeTarifs) {
        this.listeTarifs = listeTarifs;
    }

}
