/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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

    Boolean registrarLicencia(Licencia licencia) throws Exception;

    Boolean tramitarLicencia(TramiteLicencia tramite) throws Exception;

    Boolean registrarPlaca(Placa placa) throws Exception;

    void actualizarLicencia(Licencia licenciaActual, TramiteLicencia tramiteLicencia) throws Exception;
   
    Licencia buscarLicenciaActiva(Persona persona) throws Exception;
    
    Boolean tramitarPlaca(TramitePlaca tramite) throws Exception;

    void actualizarPlaca(Placa placaActual, TramitePlaca tramite);

    Placa buscarPlacaActiva(TramitePlaca tramite) throws Exception;

    List<TramiteLicencia> consultarTramitesLicencia();

    List<TramitePlaca> consultarTramitesPlaca();

    Long consultarDiasTransurridosSP(Calendar fechaInicio, Calendar fechaFin);

    List<Tramite> consultarColumnaTipoTramite();

    List<Tramite> periodoFechaTramite(String fechaInicio, String fechaFin);
}
