/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel Mancinas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_proyecto2_233410_233023");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaccion = em.getTransaction();

        transaccion.begin();
        //String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, String discapacitado, Calendar fechaNacimiento
        Persona personaejemplo = new Persona("1992983kska", "gabriel", "mancinas", "cota", "si", new GregorianCalendar());
       
        em.persist(personaejemplo);
        em.getTransaction().commit();
    }
    
}
