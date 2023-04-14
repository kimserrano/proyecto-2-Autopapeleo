/**
 * Clase TramitesDTO.java creada el 11/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

/**
 * Clase que sirve como transporte de datos para generar el reporte de trámites.
 *
 * @author Gabriel x Kim
 */
public class TramitesDTO {

    /**
     * Atributo que representa el nombre de la persona que realizó el trámite.
     */
    private String nombre;
    /**
     * Atributo que representa que tipo de trámite fue realizado, de placas o
     * licencias.
     */
    private String tipoTramite;
    /**
     * Atributo que representa la fecha en la que se realizó el trámite.
     */
    private String fecha;
    /**
     * Atributo que representa el costo que tubo que pagar la persona por ese
     * trámite.
     */
    private Float costo;

    /**
     * Contructor que inicializa los atributos de la clase con sus parametros.
     *
     * @param nombre nombre de la persona que realizó el trámite.
     * @param tipoTramite tipo de trámite fue realizado, de placas o licencias.
     * @param fecha la fecha en la que se realizó el trámite.
     * @param costo el costo que tubo que pagar la persona por ese trámite.
     */
    public TramitesDTO(String nombre, String tipoTramite, String fecha, Float costo) {
        this.nombre = nombre;
        this.tipoTramite = tipoTramite;
        this.fecha = fecha;
        this.costo = costo;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona que realizó el trámite.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nombre de la persona que realizó el trámite.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de trámite.
     *
     * @return tipo de trámite fue realizado, de placas o licencias.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite.
     *
     * @param tipoTramite tipo de trámite fue realizado, de placas o licencias.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Obtiene la fecha de expedición del trámite.
     *
     * @return la fecha en la que se realizó el trámite.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de expedición del trámite.
     *
     * @param fecha fecha en la que se realizó el trámite.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return el costo que tubo que pagar la persona por ese trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo del trámite.
     *
     * @param costo el costo que tubo que pagar la persona por ese trámite.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Metodo usado para escribir y con ello conocer los atributos de esta
     * clase, nombre, tipoTramite, fecha y costo.
     *
     * @return tributos de la persona en orden.
     */
    @Override
    public String toString() {
        return "TramitesDTO{" + "nombre=" + nombre + ", tipoTramite=" + tipoTramite + ", fecha=" + fecha + ", costo=" + costo + '}';
    }

}
