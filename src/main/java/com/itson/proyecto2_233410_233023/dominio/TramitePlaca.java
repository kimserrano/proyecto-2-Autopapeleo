/*
Clase TramitePlaca.java creada el 29/03/2023.
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
 * @author kim
 */
@Table(name = "tramite_placa")
@Entity
@PrimaryKeyJoinColumn(name = "id_tramite_placa")
public class TramitePlaca extends Tramite implements Serializable {


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_placa",nullable=false)
    private Placa placa;

    public TramitePlaca() {
    }

    public TramitePlaca(Placa placa, Float costo, Calendar fechaExpedicion) {
        super(costo, fechaExpedicion);
        this.placa = placa;
    }
    
    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "TramitePlaca{" + "placa=" + placa + '}';
    }
    
    

}
