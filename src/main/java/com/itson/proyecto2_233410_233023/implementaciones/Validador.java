/**
 * Clase validadores.java creada el 15/02/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;


import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Este clase representa los validadores del proyecto.
 * @author Gab x Kim
 */
public class Validador {

    /**
     * Constructor por defecto.
     */
    public Validador() {

    }

    public boolean validaID(String id) {
        
        String patron = "^[0-9]+$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(id);
        return matcher.matches();
    }
    
    public boolean validaNombre(String letras){
         String patron = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+([ '-][a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(letras);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
     public boolean validaRFC(String letras){
         String patron = "^[A-ZÑ&]{3,4}\\d{6}[A-V1-9][0-9A-Z]?$|^.{0,12}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(letras);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    
}