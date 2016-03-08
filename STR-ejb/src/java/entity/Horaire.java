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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author 5152683
 */
@Entity
public class Horaire implements Serializable {
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
        if (!(object instanceof Horaire)) {
            return false;
        }
        Horaire other = (Horaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Horaire[ id=" + id + " ]";
    }
    
 @Temporal(javax.persistence.TemporalType.DATE)
    private Date Heure;

    /**
     * Get the value of Heure
     *
     * @return the value of Heure
     */
    public Date getHeure() {
        return Heure;
    }

    /**
     * Set the value of Heure
     *
     * @param Heure new value of Heure
     */
    public void setHeure(Date Heure) {
        this.Heure = Heure;
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
    @ManyToOne
    
    private Arret Arret;

    /**
     * Get the value of Arret
     *
     * @return the value of Arret
     */
    public Arret getArret() {
        return Arret;
    }

    /**
     * Set the value of Arret
     *
     * @param Arret new value of Arret
     */
    public void setArret(Arret Arret) {
        this.Arret = Arret;
    }
    @OneToMany (mappedBy="Horaire")
    private List<Periode> listePeriode = new ArrayList<Periode>();

    public List<Periode> getListePeriode() {
        return listePeriode;
    }

    public void setListePeriode(List<Periode> listePeriode) {
        this.listePeriode = listePeriode;
    }
    
}
