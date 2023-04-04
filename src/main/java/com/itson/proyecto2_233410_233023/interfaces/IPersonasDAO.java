/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.implementaciones.ConfiguracionPaginado;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public interface IPersonasDAO {
    
    boolean insercionMasivaPersonas(); 
    List<Persona> consultarPersonas(ConfiguracionPaginado config);
    List<Persona> consultarPersonasFiltro(String filtro, String dato,ConfiguracionPaginado config);
    Persona obtenerPersona(Long id);
}
