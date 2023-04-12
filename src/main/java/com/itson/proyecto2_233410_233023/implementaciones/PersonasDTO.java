/**
 * Clase PersonasDTO.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Tramite;
import java.util.List;

/**
 * Clase que sirve como transporte de datos
 *
 * @author Gabriel x Kim
 */
public class PersonasDTO {

    /**
     * Atributo que representa el rfc de una persona.
     */
    private String rfc;
    /**
     * Atributo que representa el nombre y apellido paterno de una persona.
     */
    private String nombre;
    /**
     * Atributo que representa la fecha de nacimiento de una persona.
     */
    private String fechaNacimiento;
    /**
     * Atributo que representa los trámites que ha realizado una persona.
     */
    private List<Tramite> tramites;

    /**
     * Constructos que recibe parametros para inicializar los atributos.
     *
     * @param rfc representa el rfc de una persona.
     * @param nombre representa el nombre y apellido paterno de una persona.
     * @param fechaNacimiento representa la fecha de nacimiento de una persona.
     */
    public PersonasDTO(String rfc, String nombre, String fechaNacimiento) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor que solamnte necesita el nombre de la persona.
     *
     * @param nombre representa el nombre y apellido paterno de una persona.
     */
    public PersonasDTO(String nombre) {
        this.nombre = nombre;

    }

    /**
     * Obtiene el el rfc de una persona.
     *
     * @return el rfc de una persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el rfc de una persona.
     *
     * @param rfc el rfc de una persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el nombre y apellido paterno de una persona.
     *
     * @return el nombre y apellido paterno de una persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre y apellido paterno de una persona.
     *
     * @param nombre el nombre y apellido paterno de una persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento de una persona
     *
     * @return la fecha de nacimiento de una persona.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de una persona.
     *
     * @param fechaNacimiento la fecha de nacimiento de una persona
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene los trámites que ha realizado una persona.
     *
     * @return los trámites que ha realizado una persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Establece los trámites que ha realizado una persona.
     *
     * @param tramites los trámites que ha realizado una persona.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Metodo usado para escribir y con ello conocer los atributos de esta clase
     *
     * @return atributos de la persona en orden
     */
    @Override
    public String toString() {
        return "PersonasDTO{" + "rfc=" + rfc + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", tramites=" + tramites + '}';
    }

}
