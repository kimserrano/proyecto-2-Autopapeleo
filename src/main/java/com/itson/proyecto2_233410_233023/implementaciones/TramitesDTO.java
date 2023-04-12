/**
 * Clase TramitesDTO.java creada el 11/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

/**
 *
 * @author Gabriel x Kim
 */
public class TramitesDTO {
    private String nombre;
    private String tipoTramite;
    private String fecha;
    private Float costo;

    public TramitesDTO(String nombre, String tipoTramite, String fecha, Float costo) {
        this.nombre = nombre;
        this.tipoTramite = tipoTramite;
        this.fecha = fecha;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "TramitesDTO{" + "nombre=" + nombre + ", tipoTramite=" + tipoTramite + ", fecha=" + fecha + ", costo=" + costo + '}';
    }

   
    

}

