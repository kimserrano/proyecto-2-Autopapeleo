/**
 * Clase IConexionBD.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel x Kim
 */
public interface IConexionBD {

    /**
     * Método para obtener el EntityManager de la conexión.
     *
     * @return EntityManager de la conexión.
     */
    public EntityManager getEM();
}
