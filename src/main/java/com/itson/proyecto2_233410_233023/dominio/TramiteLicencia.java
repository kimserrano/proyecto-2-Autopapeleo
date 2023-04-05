/*
Clase TramiteLicencia.java creada el 29/03/2023.
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
 * Clase que representa un tramite de licencias por lo que hereda de tramite
 *
 * @author Gabriel x Kim
 */
@Table(name = "tramites_licencia")
@Entity
@DiscriminatorValue(value = "tramiteLicencia")
public class TramiteLicencia extends Tramite implements Serializable {

    /**
     * Representa la licencia a la que pertenece el tramite
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_licencia", nullable = false)
    private Licencia licencia;

    /**
     * Constructor por defecto para crear tramites de licencia
     */
    public TramiteLicencia() {
    }

    /**
     * Constructor para crear tramites de licencia dando atributos
     *
     * @param licencia Representa la licencia a la que pertenece el tramite
     * @param costo Representa el costo que tiene el tramite
     * @param fechaExpedicion Representa la fecha en la que se genero el tramite
     * @param persona Representa a la persona a la que se le esta haciendo el
     * tramite
     */
    public TramiteLicencia(Licencia licencia, Float costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.licencia = licencia;
    }

    /**
     * Obtiene la licencia
     *
     * @return Representa la licencia a la que pertenece el tramite
     */
    public Licencia getLicencia() {
        return licencia;
    }

    /**
     * Establece la licencia
     *
     * @param licencia Representa la licencia a la que pertenece el tramite
     */
    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    /**
     * Escribe la licencia de la que se hizo el tramite
     *
     * @return imprime la licencia
     */
    @Override
    public String toString() {
        return "TramiteLicencia{" + "licencia=" + licencia + '}';
    }

}
