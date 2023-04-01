/*
ConexionBD.java creada el 31/03/2023
*/
package com.itson.proyecto2_233410_233023.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel x Kim
 */
public class ConexionBD {
    private EntityManager entityManager;
    private String nombrePersistencia;
    
    public ConexionBD(String nombrePersistencia){
        this.nombrePersistencia=nombrePersistencia;
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(nombrePersistencia);
         entityManager = entityManagerFactory.createEntityManager();
    }
    public EntityManager getEM() {
        return entityManager;
    }
}
