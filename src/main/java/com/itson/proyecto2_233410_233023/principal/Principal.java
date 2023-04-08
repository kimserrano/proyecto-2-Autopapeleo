/*
Clase Principal.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.UI.FrmMenu;
import com.itson.proyecto2_233410_233023.dominio.*;
import com.itson.proyecto2_233410_233023.implementaciones.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel x Kim
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        ConexionBD conexionBD = new ConexionBD("com.itson.proyecto2_233410_233023");
        IPersonasDAO personasDAO = new PersonasDAO(conexionBD);
        IVehiculosDAO vehiculosDAO = new VehiculosDAO(conexionBD);
        ITramitesDAO tramitesDAO = new TramitesDAO(conexionBD);
        IHistorialDAO historialDAO = new HistorialDAO(conexionBD);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

//        for (Persona personas : personasDAO.consultarPersonasFiltro("id","5")) {
//            GregorianCalendar fechaNacimiento = (GregorianCalendar) personas.getFechaNacimiento();
//            String fechaNacimientoFormateada = formatter.format(fechaNacimiento.getTime());
//        System.out.println(personas);
//            System.out.println(fechaNacimientoFormateada);
//        }
        new FrmMenu(personasDAO, vehiculosDAO, tramitesDAO, historialDAO).setVisible(true);
        // EntityTransaction transaccion = conexionBD.getEM().getTransaction();

//        transaccion.begin();
        //        //String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, String discapacitado, Calendar fechaNacimiento
//        Persona personaejemplo = new Persona("1992983kska", "kim", "serrano", "uribe", Discapacitado.SI, new GregorianCalendar());
//        //String numeroSerie, String modelo, String marca, String linea, String color
//        Vehiculo vehiculoejemplo = new Automovil("AAA233", "Papu", "SDLG", "CP", "Verde", personaejemplo);
//        //String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmision, Calendar fechaRecepcion, Vehiculo vehiculo
//        Placa placaejemplo = new Placa("234-BVV", 1600.00f, Estado.ACTIVA, new GregorianCalendar(), new GregorianCalendar(), vehiculoejemplo);
//        //Float monto, Calendar fechaExpedicion, Anios aniosVigencia
//        Licencia licenciaejemplo = new Licencia(600f, new GregorianCalendar(), Anios.UNO);
//        //Float costo, Calendar fechaExpedicion
//        Tramite tramitePlaca = new TramitePlaca(placaejemplo, placaejemplo.getCosto(), new GregorianCalendar(), personaejemplo);
//        //Float costo, Calendar fechaExpedicion
//        Tramite tramiteLicencia = new TramiteLicencia(licenciaejemplo, licenciaejemplo.getMonto(), new GregorianCalendar(), personaejemplo);
//        conexionBD.getEM().persist(personaejemplo);
//        conexionBD.getEM().persist(vehiculoejemplo);
//        conexionBD.getEM().persist(tramitePlaca);
//        conexionBD.getEM().persist(tramiteLicencia);
//        conexionBD.getEM().getTransaction().commit();
//        EntityManager em = //obtener el EntityManager
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        String fechaTexto = "2023-04-01";
//        String fechaTextoFin = "2024-04-03";
//        Date fecha = formato.parse(fechaTexto);
//        Date fechaFin = formato.parse(fechaTextoFin);
//        System.out.println(tramitesDAO.consultarDiasTransurridosSP(fecha, fechaFin));

    }
}
