/*
Clase Vehiculo.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que repesenta un vehiculo que pertenece a una persona
 *
 * @author Gabriel x Kim
 */
@Entity
@DiscriminatorColumn(name="tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable {

    /**
     * Id unico que identifica a un vehiculo especifico
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa el numero de serie del vehiculo
     */
    @Column(name = "numero_serie", nullable = false, length = 6, unique = true)
    private String numeroSerie;

    /**
     * Representa el modelo del vehiculo
     */
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    /**
     * Representa la marca del vehiculo
     */
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    /**
     * Representa la linea del vehiculo
     */
    @Column(name = "linea", nullable = false, length = 50)
    private String linea;

    /**
     * Representa el color del vehiculo
     */
    @Column(name = "color", nullable = false, length = 30)
    private String color;

    /**
     * Representa a la persona duenia del vehiculo
     */
    @ManyToOne()
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    /**
     * Representa la lista de placas que tiene o ha tenido el vehiculo
     */
    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;

    /**
     * Constructor por defecto para crear un vehiculo
     */
    public Vehiculo() {
    }

    /**
     * Contructor para construir un vehiculo enviandole atributos
     *
     * @param numeroSerie Representa el numero de serie del vehiculo
     * @param modelo Representa el modelo del vehiculo
     * @param marca Representa la marca del vehiculo
     * @param linea Representa la linea del vehiculo
     * @param color Representa el color del vehiculo
     * @param persona Representa a la persona duenia del vehiculo
     */
    public Vehiculo(String numeroSerie, String modelo, String marca, String linea, String color, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
    }

    /**
     * Contructor para construir un vehiculo enviandole atributos
     *
     * @param numeroSerie Representa el numero de serie del vehiculo
     * @param modelo Representa el modelo del vehiculo
     * @param marca Representa la marca del vehiculo
     * @param linea Representa la linea del vehiculo
     * @param color Representa el color del vehiculo
     * @param persona Representa a la persona duenia del vehiculo
     * @param placas Representa la lista de placas que tiene o ha tenido el
     * vehiculo
     */
    public Vehiculo(String numeroSerie, String modelo, String marca, String linea, String color, Persona persona, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
        this.placas = placas;
    }

    /**
     * Obtiene el numero de serie
     *
     * @return Representa el numero de serie del vehiculo
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el numero de serie
     *
     * @param numeroSerie Representa el numero de serie del vehiculo
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene el modelo
     *
     * @return Representa el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo
     *
     * @param modelo Representa el modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la marca
     *
     * @return Representa la marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca
     *
     * @param marca Representa la marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la linea
     *
     * @return Representa la linea del vehiculo
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la linea
     *
     * @param linea Representa la linea del vehiculo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene el color
     *
     * @return Representa el color del vehiculo
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color
     *
     * @param color Representa el color del vehiculo
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene a la persona
     *
     * @return Representa a la persona duenia del vehiculo
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece a la persona
     *
     * @param persona Representa a la persona duenia del vehiculo
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el id
     *
     * @return Id unico que identifica a un vehiculo especifico
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id
     *
     * @param id Id unico que identifica a un vehiculo especifico
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la placa
     *
     * @return Representa la lista de placas que tiene o ha tenido el vehiculo
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Estavlece la placa
     *
     * @param placas Representa la lista de placas que tiene o ha tenido el
     * vehiculo
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Obtiene el hash de un vehiculo en especifico usando el id
     *
     * @return
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Escribe los atributos del vehiculo de manera ordenada
     *
     * @return imprime los atributos del vehiculo generado
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", numeroSerie=" + numeroSerie + ", modelo=" + modelo + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", persona=" + persona + ", placas=" + placas + '}';
    }

}
