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
 * Clase que representa las licencias que puede solicitar una persona
 *
 * @author Gabriel x Kim
 */
@Entity
@Table(name = "Licencias")
public class Licencia implements Serializable {

    /**
     * Id unico que identifica a una licencia en especifico
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Monto que representa el costo de la licencia
     */
    @Column(name = "monto", nullable = false)
    private Float monto;

    /**
     * Representa la fecha en la que la licencia fue realizada
     */
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    /**
     * Representa los anios de vigencia que tiene la licencia
     */
    @Column(name = "anios_vigencia", nullable = false)
    @Enumerated(EnumType.STRING)
    private Anios aniosVigencia;

    /**
     * Representa el estado de una placa para conocer si se encuentra activa
     */
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    /**
     * Constructor por defecto para crear licencias
     */
    public Licencia() {
    }

    /**
     * Contructor para construir una licencia pidiendo parametros para su
     * creacion
     * @param monto Monto que representa el costo de la licencia
     * @param fechaExpedicion Representa la fecha en la que la licencia fue
     * realizada
     * @param aniosVigencia Representa los anios de vigencia que tiene la
     * licencia
     * @param estado Estado de la licencia.
     */
    public Licencia(Float monto, Calendar fechaExpedicion, Anios aniosVigencia, Estado estado) {
        this.monto = monto;
        this.fechaExpedicion = fechaExpedicion;
        this.aniosVigencia = aniosVigencia;
        this.estado = estado;
    }

    /**
     * Obtiene el id
     *
     * @return Id unico que identifica a una licencia en especifico
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id
     *
     * @param id Id unico que identifica a una licencia en especifico
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el moto
     *
     * @return Monto que representa el costo de la licencia
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Establece el monto
     *
     * @param monto Monto que representa el costo de la licencia
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha de expedision de la licencia
     *
     * @return Representa la fecha en la que la licencia fue realizada
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedision de la licencia
     *
     * @param fechaExpedicion Representa la fecha en la que la licencia fue
     * realizada
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Obtiene los anios de vigencia de la licencia
     *
     * @return Representa los anios de vigencia que tiene la licencia
     */
    public Anios getAniosVigencia() {
        return aniosVigencia;
    }

    /**
     * Establece los anios de vigencia de la licencia
     *
     * @param aniosVigencia Representa los anios de vigencia que tiene la
     * licencia
     */
    public void setAniosVigencia(Anios aniosVigencia) {
        this.aniosVigencia = aniosVigencia;
    }

    /**
     * Obtiene el hash de una licencia en especifico usando el id
     *
     * @return regresa el hasg de la licencia
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Escribe los atributos de la licencia de manera ordenada
     *
     * @return imprime los atributos de la licencia generada
     */
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", monto=" + monto + ", fechaExpedicion=" + fechaExpedicion + ", aniosVigencia=" + aniosVigencia + ", estado=" + estado + '}';
    }

}
