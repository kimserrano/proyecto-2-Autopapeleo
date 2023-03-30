/*
Clase Licencia.java creada el 29/03/2023.
*/
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gabriel x Kim
 */
@Entity
@Table(name="Lincencias")
public class Licencia implements Serializable {

    @Id
    @Column(name = "id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "monto",nullable=false)
    private Float monto;
    @Column(name = "fecha_expedicion",nullable=false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;
    @Column(name = "anios_vigencia",nullable=false)
    @Enumerated(EnumType.STRING)
    private Anios aniosVigencia;

    public Licencia() {
    }

    public Licencia(Float monto, Calendar fechaExpedicion, Anios aniosVigencia) {
        this.monto = monto;
        this.fechaExpedicion = fechaExpedicion;
        this.aniosVigencia = aniosVigencia;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Anios getAniosVigencia() {
        return aniosVigencia;
    }

    public void setAniosVigencia(Anios aniosVigencia) {
        this.aniosVigencia = aniosVigencia;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.proyecto2_233410_233023.dominio.Licencia[ id=" + id + " ]";
    }
    
}
