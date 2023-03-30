/*
Clase TramiteLicencia.java creada el 29/03/2023.
*/
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Gabriel x Kim
 */
@Table(name = "tramite_licencia")
@Entity
@PrimaryKeyJoinColumn(name="id_tramite_licencia")
public class TramiteLicencia extends Tramite implements Serializable {
    
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_licencia",nullable=false)
    private Licencia licencia;
    
    public TramiteLicencia() {
    }

    public TramiteLicencia(Licencia licencia, Float costo, Calendar fechaExpedicion) {
        super(costo, fechaExpedicion);
        this.licencia = licencia;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }
    

    @Override
    public String toString() {
        return "TramiteLicencia{" + '}';
    }
    
    
    
}
