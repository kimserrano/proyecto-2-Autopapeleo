/**
 * Clase IPersonasDAO.java creada el 03/04/2023.
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.implementaciones.ConfiguracionPaginado;
import java.util.List;

/**
 *
 * @author Gabriel x Kim
 */
public interface IPersonasDAO {

    /**
     * Método para realizar la inserción masiva de 20 personas a la base de
     * datos.
     *
     * @return Valor booleano.
     */
    boolean insercionMasivaPersonas();

    /**
     * Método para consultar una lista de personas.
     *
     * @param config Configuración del paginado.
     * @return Lista de personas.
     */
    List<Persona> consultarPersonas(ConfiguracionPaginado config);

    /**
     * Método para consultar una lista de personas a partir de los filtros
     * enviados.
     *
     * @param filtro Filtro enviado (ID,RFC o Nombre).
     * @param dato Dato recuperado.
     * @param config Configuración del paginado.
     * @return Lista de personas.
     */
    List<Persona> consultarPersonasFiltro(String filtro, String dato, ConfiguracionPaginado config);

    /**
     * Método para consultar una lista de personas con un clausala where.
     *
     * @param filtroSeleccionado que se desea comparar.
     * @param dato dato con el que se desea comparar.
     * @return Lista de personas que coincidan.
     */
    List<Persona> consultarPersonasUnFiltro(String filtroSeleccionado, String dato);

    /**
     * Método para consultar una lista de personas con dos clausalas where.
     *
     * @param filtro1 que se desea comparar.
     * @param filtro2 que se desea comparar.
     * @param dato1 dato con el que se desea comparar con el filtro1.
     * @param dato2 dato con el que se desea comparar con el filtro2.
     * @return Lista de personas que coincidan.
     */
    List<Persona> consultarPersonasDosFiltro(String filtro1, String filtro2, String dato1, String dato2);

    /**
     * Método para consultar una lista de personas con tres clausalas where.
     *
     * @param filtro1 que se desea comparar.
     * @param filtro2 que se desea comparar.
     * @param filtro3 que se desea comparar.
     * @param dato1 dato con el que se desea comparar con el filtro1.
     * @param dato2 dato con el que se desea comparar con el filtro2.
     * @param dato3 dato con el que se desea comparar con el filtro3.
     * @return Lista de personas que coincidan.
     */
    List<Persona> consultasTresPersonasTresFiltro(String filtro1, String filtro2, String filtro3, String dato1, String dato2, String dato3);

    /**
     * Método que consulta a todas las personas registradas en la base de datos
     *
     * @return Lista de personas.
     */
    List<Persona> consultarPersonas();

    /**
     * Método para obtener una persona a partir de la ID enviada.
     *
     * @param id ID de la persona.
     * @return Persona obtenida.
     */
    Persona obtenerPersona(Long id);

}
