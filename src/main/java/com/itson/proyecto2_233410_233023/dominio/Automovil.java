/*
Clase Automovil.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Clase que representa a un automovil que le pertenece a la persona
 *
 * @author Gabriel x Kim
 */
@Table(name = "Automoviles")
@DiscriminatorValue(value = "Automovil")
@Entity
public class Automovil extends Vehiculo implements Serializable {

    /**
     * Constructor de defecto para construir objetos Automovil
     */
    public Automovil() {
    }

    /**
     * Constructor para construir objetos Automovil
     *
     * @param numeroSerie Representa el numero de serie del vehiculo
     * @param modelo Representa el modelo del vehiculo
     * @param marca Representa la marca del vehiculo
     * @param linea Representa la linea del vehiculo
     * @param color Representa el color del vehiculo
     * @param persona Representa a la persona duenia del vehiculo
     */
    public Automovil(String numeroSerie, String marca, String linea, String color, String modelo, Persona persona) {
        super(numeroSerie, marca, linea, color, modelo, persona);
    }

    /**
     * Constructor para construir objetos Automovil
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
    public Automovil(String numeroSerie, String marca, String linea, String color, String modelo, Persona persona, List<Placa> placas) {
        super(numeroSerie, marca, linea, color, modelo, persona, placas);
    }

}
