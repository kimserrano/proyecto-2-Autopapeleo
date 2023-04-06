/*
Clase Placa.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa las placa de un automovil
 *
 * @author Gabriel x Kim
 */
@Entity
@Table(name = "Placas")
public class Placa implements Serializable {

    /**
     * Id unico que identifica a una placa en especifico de un automovil
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa la combinacion de numero y letras que identifican a la placa
     * de una automovil
     */
    @Column(name = "numero_alfanumerico", nullable = false, length = 10,unique = true)
    private String numeroAlfanumerico;

    /**
     * Representa el costo de la placa
     */
    @Column(name = "costo", nullable = false)
    private Float costo;

    /**
     * Representa el estado de una placa para conocer si se encuentra activa
     */
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    /**
     * Representa la fecha en la que se crea la placa del vehiculo
     */
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEmision;

    /**
     * Representa la fecha en la que se recibe la placa del vehiculo
     */
    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    /**
     * Representa el vehiculo que tiene dicha placa
     */
    @ManyToOne()
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    /**
     * Contructor por defecto para crear una placa
     */
    public Placa() {
    }

    /**
     * Contructor para crear una placa enviando parametros
     *
     * @param numeroAlfanumerico Representa la combinacion de numero y letras
     * que identifican a la placa de una automovil
     * @param costo Representa el costo de la placa
     * @param estado Representa el estado de una placa para conocer si se
     * encuentra activa
     * @param fechaEmision Representa la fecha en la que se crea la placa del
     * vehiculo
     * @param fechaRecepcion Representa la fecha en la que se recibe la placa
     * del vehiculo
     * @param vehiculo Representa el vehiculo que tiene dicha placa
     */
    public Placa(String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmision, Calendar fechaRecepcion, Vehiculo vehiculo) {
        this.numeroAlfanumerico = numeroAlfanumerico;
        this.costo = costo;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }
    /**
     * Contructor para crear una placa enviando parametros
     *
     * @param numeroAlfanumerico Representa la combinacion de numero y letras
     * que identifican a la placa de una automovil
     * @param costo Representa el costo de la placa
     * @param estado Representa el estado de una placa para conocer si se
     * encuentra activa
     * @param fechaEmision Representa la fecha en la que se crea la placa del
     * vehiculo
     * @param vehiculo Representa el vehiculo al cual se le tramitan las placas.
     */
    public Placa(String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmision,Vehiculo vehiculo) {
        this.numeroAlfanumerico = numeroAlfanumerico;
        this.costo = costo;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.vehiculo=vehiculo;
    }

    public Placa(String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmision) {
        this.numeroAlfanumerico = numeroAlfanumerico;
        this.costo = costo;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
    }
    

    /**
     * Obtiene el id unico que identifica a una placa en especifico de un
     * automovil
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id
     *
     * @param id id unico que identifica a una placa en especifico de un
     * automovil
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el numero alfanumerico de la placa
     *
     * @return Representa la combinacion de numero y letras que identifican a la
     * placa de una automovil
     */
    public String getNumeroAlfanumerico() {
        return numeroAlfanumerico;
    }

    /**
     * Establece el numero alfanumerico de la placa
     *
     * @param numeroAlfanumerico Representa la combinacion de numero y letras
     * que identifican a la placa de una automovil
     */
    public void setNumeroAlfanumerico(String numeroAlfanumerico) {
        this.numeroAlfanumerico = numeroAlfanumerico;
    }

    /**
     * Regresa el costo
     *
     * @return Representa el costo de la placa
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo
     *
     * @param costo Representa el costo de la placa
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene el estado
     *
     * @return Representa el estado de una placa para conocer si se encuentra
     * activa
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado
     *
     * @param estado Representa el estado de una placa para conocer si se
     * encuentra activa
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de emision
     *
     * @return Representa la fecha en la que se crea la placa del vehiculo
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emision
     *
     * @param fechaEmision Representa la fecha en la que se crea la placa del
     * vehiculo
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene la fecha de recepcion
     *
     * @return Representa la fecha en la que se recibe la placa del vehiculo
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepcion
     *
     * @param fechaRecepcion Representa la fecha en la que se recibe la placa
     * del vehiculo
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Obtiene el vehiculo al que pertenece la placa
     *
     * @return Representa el vehiculo que tiene dicha placa
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehiculo al que pertenece la placa
     *
     * @param vehiculo Representa el vehiculo que tiene dicha placa
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Para obtener el numero hash de la placa
     *
     * @return regresa el hash de la placa mediante el id
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara dos objetos para ver si son iguales
     *
     * @param object el objeto que se desea comparar
     * @return regresa true si son iguales y false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Escribe los atributos de la placa de manera ordenada
     *
     * @return imprime los atributos de la placa generada
     */
    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", numeroAlfanumerico=" + numeroAlfanumerico + ", costo=" + costo + ", estado=" + estado + ", fechaEmision=" + fechaEmision + ", fechaRecepcion=" + fechaRecepcion + ", vehiculo=" + vehiculo + '}';
    }

}
