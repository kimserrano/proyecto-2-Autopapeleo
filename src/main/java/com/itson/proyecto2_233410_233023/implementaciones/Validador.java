/**
 * Clase Validador.java creada el 01/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

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

    private void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
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
     * @param nombre símbolos a validar.
     * @return Valor booleano.
     */
    public boolean validaNombre(String nombre) throws PersistenciaException {
        if (!nombre.equals("")) {
            String patron = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+([ '-][a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(nombre);
            if (matcher.matches()) {
                return true;
            } else {
                throw new PersistenciaException("Nombre inválido.");
            }
        } else {
             throw new PersistenciaException("Ingresa nombre.");
        }
    }

    /**
     * Método que valida un RFC
     *
     * @param rfc RFC a validar.
     * @return Valor booleano.
     */
    public boolean validaRFC(String rfc) throws PersistenciaException {
        if (!rfc.equals("")) {
            String patron = "^[A-ZÑ&]{3,4}\\d{6}[A-V1-9][0-9A-Z]?$|^.{0,12}$";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(rfc);
            if (matcher.matches()) {
                return true;
            } else {
                throw new PersistenciaException("RFC inválido.");
            }
        } else {
            throw new PersistenciaException("Ingresa el RFC.");
        }
    }

    /**
     * Método que valida un Numero de Serie de un vehiculo.
     *
     * @param num numero de serie a validar.
     * @return true si el formato es correcto.
     * @throws PersistenciaException en caso de que el formato no sea el
     * indicado.
     */
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

    /**
     * Método que valida un texto.
     *
     * @param texto texto a validar.
     * @param tipo
     * @return true si el formato es correcto.
     * @throws PersistenciaException en caso de que el formato no sea el
     * indicado.
     */
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

    /**
     * Método que valida el modelo de un vehiculo.
     *
     * @param modelo a validar.
     * @return true si el formato es correcto.
     * @throws PersistenciaException en caso de que el formato no sea el
     * indicado.
     */
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

    /**
     * Método que valida las placas de un automóvil.
     *
     * @param placas placas que desean validarse.
     * @return true si el formato es correcto.
     * @throws PersistenciaException en caso de que el formato no sea el
     * indicado.
     */
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

    /**
     * Método que valida una fecha.
     *
     * @param fechaNacimiento fecha que desea validarse.
     * @return true si el formato es correcto.
     * @throws PersistenciaException en caso de que el formato no sea el
     * indicado.
     */
    public boolean validaFechaNacimiento(String fechaNacimiento) throws PersistenciaException {
        if (!fechaNacimiento.equals("")) {
            String patron = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            Pattern p = Pattern.compile(patron);
            Matcher matcher = p.matcher(fechaNacimiento);
            if (matcher.matches()) {
                return true;
            } else {
                throw new PersistenciaException("Fórmato de fecha inválido.");
            }
        } else {
              throw new PersistenciaException("Ingrese una fecha.");
        }
    }
    /**
     * Método que valida una fecha.
     *
     * @param fechaNacimiento fecha que desea validarse.
     * @return true si el formato es correcto.
     * @throws PersistenciaException en caso de que el formato no sea el
     * indicado.
     */
    public boolean validaFechaNacimientoTexto(String fechaNacimiento) throws PersistenciaException {
        if (!fechaNacimiento.equals("")) {
            return true;
        } else {
              throw new PersistenciaException("Ingrese una fecha.");
        }
    }
}
