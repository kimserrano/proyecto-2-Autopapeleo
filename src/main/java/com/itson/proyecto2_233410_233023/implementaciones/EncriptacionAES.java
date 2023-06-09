/*
Clase EncryptUtils.java creada el 03/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Es una clase que se encarga de encriptar y desencriptar una cadena usando el
 * algoritmo de cifrado AES
 *
 * @author Gabriel x Kim
 */
@Converter
public class EncriptacionAES implements AttributeConverter<String, String> {

    /**
     * Llave secreta para encriptar y desencriptar
     */
    private static final String LLAVE_SECRETA = "mySecretKey12345";

    /**
     * Representa un valor aleatorio que se utiliza junto con la clave secreta
     * para cifrar los datos y asegurar que cada bloque cifrado sea diferente
     */
    private static final String INIT_VECTOR = "encryptionIntVec";

    /**
     * Método que se encarga de encriptar una columna de la base de datos
     *
     * @param palabraOriginal la palabra sin encriptar.
     * @return la palabra encriptada o null en caos de no poder.
     */
    @Override
    public String convertToDatabaseColumn(String palabraOriginal) {
        try {
            // crea un objeto IvParameterSpec utilizando el vector de inicialización
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
            // crea un objeto SecretKeySpec utilizando la llave secreta
            SecretKeySpec key = new SecretKeySpec(LLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), "AES");
            // crea un objeto Cipher con el algoritmo de cifrado 
            //AES/CBC/PKCS5PADDING y se inicializa en el modo de cifrado.
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            // se cifra la cadena 
            byte[] palabraEncriptada = cipher.doFinal(palabraOriginal.getBytes());
            // devuelve la cadena cifrada en base 64
            return Base64.getEncoder().encodeToString(palabraEncriptada);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Método que se encarga de desencriptar una palabra de la base de datos.
     *
     * @param palabraEncriptada palabra que se desea desencriptar.
     * @return la palabra desencriptada o null en caso de no poder.
     */
    @Override
    public String convertToEntityAttribute(String palabraEncriptada) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec key = new SecretKeySpec(LLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            // se desifra la palabra con el metodo cipher.doFinal
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(palabraEncriptada));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
