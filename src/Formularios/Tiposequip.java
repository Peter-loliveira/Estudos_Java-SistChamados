/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "tiposequip", catalog = "dbchamados", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tiposequip.findAll", query = "SELECT t FROM Tiposequip t")
    , @NamedQuery(name = "Tiposequip.findById", query = "SELECT t FROM Tiposequip t WHERE t.id = :id")})
public class Tiposequip implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "Tipos")
    private String tipos;

    public Tiposequip() {
    }

    public Tiposequip(Integer id) {
        this.id = id;
    }

    public Tiposequip(Integer id, String tipos) {
        this.id = id;
        this.tipos = tipos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        String oldTipos = this.tipos;
        this.tipos = tipos;
        changeSupport.firePropertyChange("tipos", oldTipos, tipos);
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
        if (!(object instanceof Tiposequip)) {
            return false;
        }
        Tiposequip other = (Tiposequip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Formularios.Tiposequip[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
