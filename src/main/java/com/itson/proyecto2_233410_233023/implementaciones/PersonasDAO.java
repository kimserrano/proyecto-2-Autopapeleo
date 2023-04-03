/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Discapacitado;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.interfaces.IPersonasDAO;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public class PersonasDAO implements IPersonasDAO {

    @Override
    public List<Persona> insercionMasivaPersonas() {
        GregorianCalendar fn = new GregorianCalendar(2003, 3, 3); // año, mes y día. mes empiza del 0

        //String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Discapacitado discapacitado, Calendar fechaNacimiento
        Persona p1 = new Persona("PEGJ931015", "Juan", "Pérez", "García", Discapacitado.NO, new GregorianCalendar(2003, 3, 3));
        Persona p2 = new Persona("LOHA880215", "Ana", "López", "Hernández", Discapacitado.NO, new GregorianCalendar(2002, 4, 13));
        Persona p3 = new Persona("RATC800526", "Carlos", "Ramírez", "Torres", Discapacitado.NO, new GregorianCalendar(2001, 5, 7));
        Persona p4 = new Persona("MAOS960712", "Sofía", "Martínez", "Ortiz", Discapacitado.NO, new GregorianCalendar(2003, 1, 9));
        Persona p5 = new Persona("GOGD710506", "David", "González", "Gómez", Discapacitado.NO, new GregorianCalendar(1994, 2, 23));
        Persona p6 = new Persona("SARL900201", "Laura", "Sánchez", "Rodríguez", Discapacitado.NO, new GregorianCalendar(1990, 0, 10));
        Persona p7 = new Persona("HEVM850723", "Mario", "Hernández", "Vázquez", Discapacitado.SI, new GregorianCalendar(1997, 0, 11));
        Persona p8 = new Persona("FOGA930713", "Alejandra", "Flores", "Gutiérrez", Discapacitado.SI, new GregorianCalendar(1999, 1, 10));
        Persona p9 = new Persona("GORL820317", "Luis", "Gómez", "Rodríguez", Discapacitado.SI, new GregorianCalendar(1999, 2, 12));
        Persona p10 = new Persona("TOHM950609", "Mariana", "Torres", "Hernández", Discapacitado.SI, new GregorianCalendar(1999, 2, 13));
        Persona p11 = new Persona("PELM751020", "Manuel", "Pérez", "López", Discapacitado.SI, new GregorianCalendar(2000, 6, 20));

        //String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Discapacitado discapacitado, String telefono, Calendar fechaNacimiento
        Persona p12 = new Persona("GAFK940708", "Ana Karen", "García", "Flores", Discapacitado.SI, "55 1234 5678", new GregorianCalendar(2000, 6, 11));
        Persona p13 = new Persona("TOJJ800125", "José", "Torres", "Jiménez", Discapacitado.SI, "33 9876 5432", new GregorianCalendar(2001, 9, 2));
        Persona p14 = new Persona("MARB911126", "Brenda", "Martínez", "Rivera", Discapacitado.SI, "81 2345 6789", new GregorianCalendar(2001, 9, 2));
        Persona p15 = new Persona("HEGA900318", "Alejandro", "Hernández", "García", Discapacitado.NO, "664 123 4567", new GregorianCalendar(2004, 8, 28));
        Persona p16 = new Persona("GOSR921021", "Rosa", "González", "Sánchez", Discapacitado.NO, "686 987 6543", new GregorianCalendar(1990, 7, 24));
        Persona p17 = new Persona("RAVC771109", "Carlos", "Ramírez", "Vázquez", Discapacitado.NO, "33 4567 8901", new GregorianCalendar(1998, 10, 18));
        Persona p18 = new Persona("MAPA851225", "Adriana", "Martínez", "Pérez", Discapacitado.NO, "951 234 5678", new GregorianCalendar(1995, 11, 29));
        Persona p19 = new Persona("MAPE908902", "Adrian", "Martínez", "Pérez", Discapacitado.NO, "662 901 2345", new GregorianCalendar(1984, 11, 29));
        Persona p20 = new Persona("JIMA871218", "Alejandra", "Jiménez", "Martínez", Discapacitado.NO, "744 987 6543", new GregorianCalendar(1985, 12, 30));

        //Agregar a una lista
        List<Persona> personas = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);

        return personas;
    }
}
