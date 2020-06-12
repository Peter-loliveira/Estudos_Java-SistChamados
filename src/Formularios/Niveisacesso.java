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
@Table(name = "niveisacesso", catalog = "dbchamados", schema = "")
@NamedQueries({
    @NamedQuery(name = "Niveisacesso.findAll", query = "SELECT n FROM Niveisacesso n")
    , @NamedQuery(name = "Niveisacesso.findByIn", query = "SELECT n FROM Niveisacesso n WHERE n.in = :in")})
public class Niveisacesso implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IN")
    private Integer in;
    @Basic(optional = false)
    @Lob
    @Column(name = "Nivel")
    private String nivel;

    public Niveisacesso() {
    }

    public Niveisacesso(Integer in) {
        this.in = in;
    }

    public Niveisacesso(Integer in, String nivel) {
        this.in = in;
        this.nivel = nivel;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        Integer oldIn = this.in;
        this.in = in;
        changeSupport.firePropertyChange("in", oldIn, in);
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        String oldNivel = this.nivel;
        this.nivel = nivel;
        changeSupport.firePropertyChange("nivel", oldNivel, nivel);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (in != null ? in.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveisacesso)) {
            return false;
        }
        Niveisacesso other = (Niveisacesso) object;
        if ((this.in == null && other.in != null) || (this.in != null && !this.in.equals(other.in))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Formularios.Niveisacesso[ in=" + in + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
