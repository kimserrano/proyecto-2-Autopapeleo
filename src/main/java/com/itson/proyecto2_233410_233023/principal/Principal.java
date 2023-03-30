/*
Clase Principal.java creada el 29/03/2023.
*/
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.dominio.Anios;
import com.itson.proyecto2_233410_233023.dominio.Discapacitado;
import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Placa;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;
import com.itson.proyecto2_233410_233023.dominio.TramitePlaca;
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
        //Float monto, Calendar fechaExpedicion, Anios aniosVigencia
        Licencia licenciaejemplo = new Licencia(600f,new GregorianCalendar(),Anios.UNO);
        //Float costo, Calendar fechaExpedicion
        Tramite tramitePlaca = new TramitePlaca(placaejemplo,placaejemplo.getCosto(),new GregorianCalendar());
        //Float costo, Calendar fechaExpedicion
        Tramite tramiteLicencia = new TramiteLicencia(licenciaejemplo,licenciaejemplo.getMonto(),new GregorianCalendar());
        em.persist(personaejemplo);
        em.persist(vehiculoejemplo);
        em.persist(tramitePlaca);
        em.persist(tramiteLicencia);
        em.getTransaction().commit();
    }
    
}
