/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import java.util.List;

/**
 *
 * @author kim
 */
public class PaginacionLista {

    private List<Persona> lista;
    private int elementosPorPagina;
    private int paginaActual;

    public PaginacionLista(List<Persona> lista, int elementosPorPagina, int paginaActual) {
        this.lista = lista;
        this.elementosPorPagina = elementosPorPagina;
        this.paginaActual = paginaActual;
    }

    public List<Persona> obtenerPaginaActual() {

        int inicio = paginaActual * elementosPorPagina;
        int fin = Math.min(inicio + elementosPorPagina, lista.size());
        if (inicio <= fin && fin <= lista.size()) {
        return lista.subList(inicio, fin);
        } else{
            return null;
            //System.out.println("ya no hay consultas");
        }
        
    }

}
