/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.implementaciones.PersonasDTO;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public interface IHistorialDAO {

    public List<Persona> buscar(PersonasDTO params);
}
