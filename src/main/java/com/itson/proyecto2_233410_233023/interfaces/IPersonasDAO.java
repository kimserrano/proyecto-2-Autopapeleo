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

    List<Persona> consultarPersonasUnFiltro(String filtroSeleccionado, String dato);

    List<Persona> consultarPersonasDosFiltro(String filtro1, String filtro2, String dato1, String dato2);

    List<Persona> consultasTresPersonasTresFiltro(String filtro1, String filtro2, String filtro3, String dato1, String dato2, String dato3);

    List<Persona> consultarPersonas();

    /**
     * Método para obtener una persona a partir de la ID enviada.
     *
     * @param id ID de la persona.
     * @return Persona obtenida.
     */
    Persona obtenerPersona(Long id);

}
