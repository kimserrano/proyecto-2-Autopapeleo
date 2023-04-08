/**
 * Clase Validador.java creada el 15/02/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Este clase representa los validadores del proyecto.
 *
 * @author Gabriel x Kim
 */
public class Validador {

    /**
     * Constructor por defecto.
     */
    public Validador() {

    }

    /**
     * Método que valida una ID.
     *
     * @param id ID a validar.
     * @return Valor booleano.
     */
    public boolean validaID(String id) throws PersistenciaException {

        String patron = "^[0-9]+$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(id);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("ID inválida.");
        }
    }

    /**
     * Método que valida un nombre.
     *
     * @param letras símbolos a validar.
     * @return Valor booleano.
     */
    public boolean validaNombre(String letras) throws PersistenciaException {

        String patron = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+([ '-][a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(letras);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("Nombre inválido.");
        }
    }

    /**
     * Método que valida un RFC
     *
     * @param rfc RFC a validar.
     * @return Valor booleano.
     */
    public boolean validaRFC(String rfc) throws PersistenciaException {
        String patron = "^[A-ZÑ&]{3,4}\\d{6}[A-V1-9][0-9A-Z]?$|^.{0,12}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(rfc);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("RFC inválido.");
        }
    }

    public boolean validaNumeroSerie(String num) throws PersistenciaException {
        String patron = "^[A-Z]{3}-\\d{3}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(num);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("Número de serie inválido");
        }
    }

    public boolean validaTexto(String texto, String tipo) throws PersistenciaException {
        String patron = "^[A-Za-z0-9 ]{1,20}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(texto);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException(tipo + " inválido");
        }

    }

    public boolean validaModelo(String modelo) throws PersistenciaException {
        String patron = "^(?!0{4})\\d{4}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(modelo);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("Modelo inválido");
        }
    }

    public boolean validaPlacas(String placas) throws PersistenciaException {
        String patron = "^[A-Z]{3}-\\d{3}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(placas);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("Fórmato de placas inválido.");
        }
    }

    public boolean validaFechaNacimiento(String fechaNacimiento) throws PersistenciaException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String dateString = fechaNacimiento.format(formatter);
        String patron = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(fechaNacimiento);
        if (matcher.matches()) {
            return true;
        } else {
            throw new PersistenciaException("Fórmato de fecha inválido.");
        }
    }
}
