/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IHistorialDAO;
import com.itson.proyecto2_233410_233023.interfaces.IPersonasDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public class HistorialDAO implements IHistorialDAO {

    private final IConexionBD conexionBD;

    public HistorialDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Persona> buscar(PersonasDTO params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
