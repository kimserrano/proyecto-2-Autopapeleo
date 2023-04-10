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
    /**
     * Método para registrar un vehículo en la base de datos.
     * @param vehiculo Vehículo a registrar.
     * @return Valor booleano.
     * @throws Exception Excepción a lanzar. 
     */
    Boolean registrarVehiculo(Vehiculo vehiculo) throws Exception;
    /**
     * Método para obtener un vehículo a partir del número de serie.
     * @param numeroSerie Número de serie del vehículo.
     * @return Vehículo obtenido.
     * @throws Exception Excepción a lanzar.
     */
    Vehiculo obtenerVehiculo(String numeroSerie) throws Exception;
    /**
     * Método para obtener un vehículo usado a partir de su placa actual.
     * @param placa Placa del vehículo.
     * @return Vehículo obtenido.
     * @throws Exception Excepción a lanzar.
     */
    Vehiculo obtenerVehiculoUsado(String placa) throws Exception;
    /**
     * Método para obtener un vehículo sin historial a partir de su número de serie.
     * @param numeroSerie Número de serie del vehículo.
     * @return Vehículo obtenido.
     * @throws Exception Excepción a lanzar.
     */
    Vehiculo obtenerVehiculoSinHistorial(String numeroSerie) throws Exception;
}
