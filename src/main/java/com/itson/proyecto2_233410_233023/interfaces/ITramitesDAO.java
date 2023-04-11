/**
 * Clase ITramitesDAO.java creada el 04/04/2023.
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Placa;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;
import com.itson.proyecto2_233410_233023.dominio.TramitePlaca;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public interface ITramitesDAO {

    /**
     * Método que se encarga de hacer el insert de una licencia a la base de
     * datos.
     *
     * @param licencia la cual se requiere hacer un insert a la base.
     * @return true si fue posible.
     * @throws Exception lanza una expeción en caso de no poder.
     */
    Boolean registrarLicencia(Licencia licencia) throws Exception;

    /**
     * * Método que se encarga de hacer el insert de una tramite de una
     * licencia a la base de datos.
     *
     * @param tramite el cual se requiere hacer un insert a la base.
     * @return true si fue posible.
     * @throws Exception lanza una expeción en caso de no poder.
     */
    Boolean tramitarLicencia(TramiteLicencia tramite) throws Exception;

    /**
     * Método que actualiza el estado de una licencia. l
     *
     * @param licenciaActual licencia que desea ctualizarse.
     * @param tramiteLicencia trámite que se usa para su actualización.
     * @throws Exception lanza un una excepción en caso de no lograrse la
     * actualización.
     */
    void actualizarLicencia(Licencia licenciaActual, TramiteLicencia tramiteLicencia) throws Exception;

    /**
     * Método que se encarga de buscar si una persona tiene una licencia que
     * este activa.
     *
     * @param persona persona de la que se desea conoce el estado de su
     * licencia.
     * @return la licencia de la persona.
     * @throws Exception si no se encuentra la licencia activa.
     */
    Licencia buscarLicenciaActiva(Persona persona) throws Exception;
    
    /**
     * Método que se encarga de hacer el insert de una placa a la base de datos.
     *
     * @param placa la cual se requiere hacer un insert a la base.
     * @return true si fue posible.
     * @throws Exception lanza una expeción en caso de no poder.
     */
    Boolean registrarPlaca(Placa placa) throws Exception;
    /**
     * Método para tramitar una placa.
     * @param tramite Tramite de placa a realizar.
     * @return Valor booleano.
     * @throws Exception Excepción a lanzar en caso de fallar el trámite.
     */
    Boolean tramitarPlaca(TramitePlaca tramite) throws Exception;

    /**
     * Método que cambia el estado de la placa a inactiva y la fecha de
     * expedicion por la del trámite.
     * @param placaActual Placa actual.
     * @param tramite Tramite actual.
     */
    void actualizarPlaca(Placa placaActual, TramitePlaca tramite);

    /**
     * Método para buscar una placa activa.
     * @param tramite Tramite actual.
     * @return Placa activa encontrada.
     * @throws Exception Excepción en caso de no poder realizar la búsqueda.
     */
    Placa buscarPlacaActiva(TramitePlaca tramite) throws Exception;

    /**
     * Método que realiza una consulta de trámites de tipo licencia.
     *
     * @return lista de trámites de tipo lecencia.
     * @throws Exception si no se puede consultar la lista.
     */
    List<TramiteLicencia> consultarTramitesLicencia() throws Exception;

    /**
     * Método que realiza una consulta de trámites de tipo placa.
     *
     * @return lista de trámites de tipo placa.
     * @throws Exception si no se puede consultar la lista.
     */
    List<TramitePlaca> consultarTramitesPlaca() throws Exception;

    /**
     * Método que consulta un Stored Procedure en la base de datos de los días
     * transcurridos.
     *
     * @param fechaInicio Inicio del periodo.
     * @param fechaFin Fin del periodo.
     * @return Días transcurridos.
     */
    Long consultarDiasTransurridosSP(Calendar fechaInicio, Calendar fechaFin);

    /**
     * Consulta los trámites registrados en la base de datos.
     *
     * @return Lista de trámites.
     */
    List<Tramite> consultarColumnaTipoTramite();

    /**
     * Consulta aquellos trámites que están dentro de el periodo enviado como
     * parámetro.
     *
     * @param fechaInicio Inicio del periodo.
     * @param fechaFin Fin del periodo.
     * @return Lista de tramites cuya fecha de expedición esté dentro de ese
     * periodo.
     */
    List<Tramite> periodoFechaTramite(String fechaInicio, String fechaFin);
}
