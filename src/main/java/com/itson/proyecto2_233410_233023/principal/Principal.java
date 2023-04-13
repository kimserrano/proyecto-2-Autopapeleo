/*
Clase Principal.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.principal;

import com.itson.proyecto2_233410_233023.UI.FrmMenu;
import com.itson.proyecto2_233410_233023.implementaciones.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        new FrmMenu(personasDAO, vehiculosDAO, tramitesDAO).setVisible(true);

    }
}
