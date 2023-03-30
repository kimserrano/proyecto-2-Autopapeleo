/*
Clase Tramite.java creada el 29/03/2023.
*/
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gabriel x Kim
 */
@Table(name = "Tramite")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Tramite implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "costo", nullable = false)
    private Float costo;
    @Column(name = "fecha_expedicion", nullable = false)
    private Calendar fechaExpedicion;
    @ManyToOne()
    @JoinColumn(name="id_persona",nullable=false) 
    private Persona persona;
   
    public Tramite() {
    }

    public Tramite(Float costo, Calendar fechaExpedicion) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
    }

    public Tramite(Float costo, Calendar fechaExpedicion, Persona persona) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }
    

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    
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
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.proyecto2_233410_233023.dominio.Tramite[ id=" + id + " ]";
    }

}
