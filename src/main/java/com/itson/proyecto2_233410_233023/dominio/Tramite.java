/*
Clase Tramite.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa los tramites que puede realizar una persona
 *
 * @author Gabriel x Kim
 */
@Table(name = "Tramites")
@DiscriminatorColumn(name = "tipoTramite", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Tramite implements Serializable {

    /**
     * Id unico que identifica a un trámite especifico.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa el costo que tiene el trámite.
     */
    @Column(name = "costo", nullable = false)
    private Float costo;

    /**
     * Representa la fecha en la que se generó el trámite.
     */
    @Column(name = "fecha_expedicion", nullable = false)
    private Calendar fechaExpedicion;

    /**
     * Representa a la persona a la que se le está haciendo el trámite.
     */
    @ManyToOne()
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    /**
     * Constructor por defecto para crear un trámite.
     */
    public Tramite() {
    }

    /**
     * Contructor para crear un trámite recibiendo atributos
     *
     * @param costo Representa el costo que tiene el trámite
     * @param fechaExpedicion Representa la fecha en la que se genero el trámite
     */
    public Tramite(Float costo, Calendar fechaExpedicion) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Contructor para crear un tramite recibiendo atributos
     *
     * @param costo Representa el costo que tiene el trámite
     * @param fechaExpedicion Representa la fecha en la que se genero el trámite
     * @param persona Representa a la persona a la que se le está haciendo el
     * trámite
     */
    public Tramite(Float costo, Calendar fechaExpedicion, Persona persona) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el costo
     *
     * @return Representa el costo que tiene el trámite
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo
     *
     * @param costo Representa el costo que tiene el trámite
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la fecha de expedicion del trámite
     *
     * @return Representa la fecha en la que se genero el trámite
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedicion del trámite
     *
     * @param fechaExpedicion Representa la fecha en la que se genero el trámite
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Obtiene el id
     *
     * @return Id unico que identifica a un trámite especifico
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id
     *
     * @param id Id unico que identifica a un trámite especifico
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el hash de un trámite en especifico usando el id
     *
     * @return hashCode del trámite.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara un ejemplo con otro para saber si son iguales
     *
     * @param object objeto que deseas comparar
     * @return true si el objeto es igual y false de caso contrario
     */
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

    /**
     * Escribe los atributos de los trámites de manera ordenada
     *
     * @return imprime los atributos de un trámite generado
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", costo=" + costo + ", fechaExpedicion=" + fechaExpedicion + ", persona=" + persona + '}';
    }

}
