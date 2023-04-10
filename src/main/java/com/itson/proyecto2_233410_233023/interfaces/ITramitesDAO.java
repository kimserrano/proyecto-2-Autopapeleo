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
     * Método que se encarga de hacer el insert de una placa a la base de datos.
     *
     * @param placa la cual se requiere hacer un insert a la base.
     * @return true si fue posible.
     * @throws Exception lanza una expeción en caso de no poder.
     */
    Boolean registrarPlaca(Placa placa) throws Exception;

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
     *
     * @param tramite
     * @return
     * @throws Exception
     */
    Boolean tramitarPlaca(TramitePlaca tramite) throws Exception;

    /**
     *
     * @param placaActual
     * @param tramite
     */
    void actualizarPlaca(Placa placaActual, TramitePlaca tramite);

    /**
     *
     * @param tramite
     * @return
     * @throws Exception
     */
    Placa buscarPlacaActiva(TramitePlaca tramite) throws Exception;

    /**
     * Método que realiza una consulta de trámites de tipo licencia.
     *
     * @return lista de trámites de tipo lecencia.
     */
    List<TramiteLicencia> consultarTramitesLicencia();

    /**
     * Método que realiza una consulta de trámites de tipo placa.
     *
     * @return lista de trámites de tipo placa.
     */
    List<TramitePlaca> consultarTramitesPlaca();

    /**
     * Método que consulta un Stored Procedure en la base de datos de los días
     * transcurridos
     *
     * @param fechaInicio inicio del periodo
     * @param fechaFin sin del periodo
     * @return días transcurridos
     */
    Long consultarDiasTransurridosSP(Calendar fechaInicio, Calendar fechaFin);

    /**
     * Consulta los tramites registrados en la base de datos.
     *
     * @return lista de tramites.
     */
    List<Tramite> consultarColumnaTipoTramite();

    /**
     * Consulta aquellos tramites que estan dentro de el periodo enviado como
     * paramero.
     *
     * @param fechaInicio inicio del periodo.
     * @param fechaFin fin del periodo.
     * @return lista de tramites cuya fecha de expedición este dentro de ese
     * periodo.
     */
    List<Tramite> periodoFechaTramite(String fechaInicio, String fechaFin);
}
