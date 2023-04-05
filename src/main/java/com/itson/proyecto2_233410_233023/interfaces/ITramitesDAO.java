/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;

/**
 *
 * @author kim
 */
public interface ITramitesDAO {
     Boolean registrarLicencia(Licencia licencia) throws Exception;
     
     Boolean tramiteLicencia(TramiteLicencia tramite) throws Exception;
}
