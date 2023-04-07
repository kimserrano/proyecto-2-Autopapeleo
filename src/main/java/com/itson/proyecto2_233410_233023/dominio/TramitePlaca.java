/*
Clase TramitePlaca.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Clase que representa un tramite de placas por lo que hereda de tramite
 *
 * @author Gabriel x Kim
 */
@Table(name = "tramites_placa")
@Entity
@DiscriminatorValue("tramitePlaca")
public class TramitePlaca extends Tramite implements Serializable {

    /**
     * Representa la placa a la que pertenece el tramite
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_placa", nullable = true)
    private Placa placa;

    /**
     * Constructor por defecto para construir un tramite para obtener una placa
     */
    public TramitePlaca() {
    }

    /**
     * Constructor para construir un tramite para obtener una placa
     *
     * @param placa Representa la placa a la que pertenece el tramite
     * @param costo Representa el costo que tiene el tramite
     * @param fechaExpedicion Representa la fecha en la que se genero el tramite
     * @param persona Representa a la persona a la que se le esta haciendo el
     * tramite
     */
    public TramitePlaca(Placa placa, Float costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.placa = placa;
    }

    /**
     * Obtiene la placa
     *
     * @return Representa la placa a la que pertenece el tramite
     */
    public Placa getPlaca() {
        return placa;
    }

    /**
     * Establece la placa
     *
     * @param placa Representa la placa a la que pertenece el tramite
     */
    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    /**
     * Escribe la placa de la que se hizo el tramite
     *
     * @return imprime la placa
     */
    @Override
    public String toString() {
        return "TramitePlaca{" + "placa=" + placa + '}';
    }

}
