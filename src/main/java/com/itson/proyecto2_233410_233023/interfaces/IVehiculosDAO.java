/**
 * Clase IVehiculosDAO.java creada el 04/04/2023.
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Vehiculo;

/**
 *
 * @author Gabriel x Kim
 */
public interface IVehiculosDAO {
    
    Boolean registrarVehiculo(Vehiculo vehiculo) throws Exception;
    Vehiculo obtenerVehiculo(String numeroSerie) throws Exception;
    Vehiculo obtenerVehiculoUsado(String placa) throws Exception;
    Vehiculo obtenerVehiculoSinHistorial(String numeroSerie) throws Exception;
}
