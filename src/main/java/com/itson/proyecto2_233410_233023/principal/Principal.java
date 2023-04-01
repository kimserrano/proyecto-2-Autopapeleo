/*
Clase Principal.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.principal;

import com.itosn.proyecto2_233410_233023.UI.FrmMenu;
import com.itson.proyecto2_233410_233023.dominio.Anios;
import com.itson.proyecto2_233410_233023.dominio.Automovil;
import com.itson.proyecto2_233410_233023.dominio.Discapacitado;
import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Placa;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;
import com.itson.proyecto2_233410_233023.dominio.TramitePlaca;
import com.itson.proyecto2_233410_233023.dominio.Vehiculo;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel x Kim
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD conexionBD = new ConexionBD("com.itson.proyecto2_233410_233023");
        new FrmMenu().setVisible(true);
        EntityTransaction transaccion = conexionBD.getEM().getTransaction();
        
        transaccion.begin();
        //String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, String discapacitado, Calendar fechaNacimiento
        Persona personaejemplo = new Persona("1992983kska", "gabriel", "mancinas", "cota", Discapacitado.SI, new GregorianCalendar());
        //String numeroSerie, String modelo, String marca, String linea, String color
        Vehiculo vehiculoejemplo = new Automovil("AAA233", "Papu", "SDLG", "CP", "Verde", personaejemplo);
        //String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmision, Calendar fechaRecepcion, Vehiculo vehiculo
        Placa placaejemplo = new Placa("234-BVV", 1600.00f, Estado.ACTIVA, new GregorianCalendar(), new GregorianCalendar(), vehiculoejemplo);
        //Float monto, Calendar fechaExpedicion, Anios aniosVigencia
        Licencia licenciaejemplo = new Licencia(600f, new GregorianCalendar(), Anios.UNO);
        //Float costo, Calendar fechaExpedicion
        Tramite tramitePlaca = new TramitePlaca(placaejemplo, placaejemplo.getCosto(), new GregorianCalendar(), personaejemplo);
        //Float costo, Calendar fechaExpedicion
        Tramite tramiteLicencia = new TramiteLicencia(licenciaejemplo, licenciaejemplo.getMonto(), new GregorianCalendar(), personaejemplo);
        conexionBD.getEM().persist(personaejemplo);
        conexionBD.getEM().persist(vehiculoejemplo);
        conexionBD.getEM().persist(tramitePlaca);
        conexionBD.getEM().persist(tramiteLicencia);
        conexionBD.getEM().getTransaction().commit();
    }

}
