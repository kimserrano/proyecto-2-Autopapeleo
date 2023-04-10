/**
 * Clase PaginacionLista.java creada el 10/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import java.util.List;

/**
 * Clase para realizar una paginación con una lisa de personas.
 * @author Gabriel x Kim
 */
public class PaginacionLista {

    /**
     * Representa la lista de personas de las cual se quiere hacer una paginación.
     */
    private List<Persona> lista;
    /**
     * Representa la cantidad de elementos que se desean tener por página.
     */
    private int elementosPorPagina;
    /**
     * Representa la página actual que se estará visualizando.
     */
    private int paginaActual;

    /**
     * Constructor que se utiliza para inicializar los atributos de la clase.
     * @param lista la lista de personas de las cual se quiere hacer una paginación.
     * @param elementosPorPagina  cantidad de elementos que se desean tener por página.
     * @param paginaActual  página actual que se estará visualizando.
     */
    public PaginacionLista(List<Persona> lista, int elementosPorPagina, int paginaActual) {
        this.lista = lista;
        this.elementosPorPagina = elementosPorPagina;
        this.paginaActual = paginaActual;
    }

    /**
     * Método que se encarga de hacer las cuentas necesarias para saber cuantas páginas 
     * deben mostrarse dependiendo de la cantidad de elementos y los elementos que queremos
     * visualizar por página.
     * @return regresa una lista con los elementos correspondientes a la página actual.
     */
    public List<Persona> obtenerPaginaActual() {
        int inicio = paginaActual * elementosPorPagina;
        int fin = Math.min(inicio + elementosPorPagina, lista.size());
        if (inicio <= fin && fin <= lista.size()) {
        return lista.subList(inicio, fin);
        } else{
            return null;
        }
        
    }

}
