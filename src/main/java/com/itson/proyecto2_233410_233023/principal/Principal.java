/*
Clase Principal.Java creada el 29/03/2023.
*/
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.dominio.Discapacitado;
import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Placa;
import com.itson.proyecto2_233410_233023.dominio.Vehiculo;
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
        Persona personaejemplo = new Persona("1992983kska", "gabriel", "mancinas", "cota",Discapacitado.SI, new GregorianCalendar());
        //String numeroSerie, String modelo, String marca, String linea, String color
        Vehiculo vehiculoejemplo = new Vehiculo("AAA233","Papu","SDLG","CP","Verde",personaejemplo);
        //String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmision, Calendar fechaRecepcion, Vehiculo vehiculo
        Placa placaejemplo = new Placa("234-BVV",1600.00f,Estado.ACTIVA,new GregorianCalendar(),new GregorianCalendar(),vehiculoejemplo);
        
        em.persist(personaejemplo);
        em.persist(vehiculoejemplo);
        em.persist(placaejemplo);
        em.getTransaction().commit();
    }
    
}
