
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Tramite;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public class PersonasDTO {

    private String rfc;
    private String nombre;
    private String fechaNacimiento;
    private List<Tramite> tramites;

    public PersonasDTO(String rfc, String nombre, String fechaNacimiento) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonasDTO(String nombre) {
        this.nombre = nombre;
    }
    

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    @Override
    public String toString() {
        return "PersonasDTO{" + "rfc=" + rfc + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", tramites=" + tramites + '}';
    }

}
