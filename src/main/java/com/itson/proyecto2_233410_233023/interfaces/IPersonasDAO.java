/**
 * Clase IPersonasDAO.java creada el 03/04/2023.
 */
package com.itson.proyecto2_233410_233023.interfaces;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.implementaciones.ConfiguracionPaginado;
import com.itson.proyecto2_233410_233023.implementaciones.PersonasDTO;
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
     * @param personasDTO Objeto con los filtros seleccionados.
     * @return Lista de personas.
     * 
     */
    List<Persona> consultarPersonasUnFiltro(PersonasDTO personasDTO);
    /**
     * Método para consultar una lista de personas con dos clausalas where.
     *
     * @param personasDTO Objeto con los filtros seleccionados.
     * @param filtro1 que se desea comparar.
     * @param filtro2 que se desea comparar.
     * @return Lista de personas.
     * 
     */
    List<Persona> consultarPersonasDosFiltro(PersonasDTO personasDTO, String filtro1, String filtro2);

    /**
     * Método para consultar una lista de personas con tres clausalas where.
     *
     * @param personasDTO Objeto conn los filtros seleccionados.
     * @return Lista de personas que coincidan.
     */
    List<Persona> consultarPersonasTresFiltro(PersonasDTO personasDTO);

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
