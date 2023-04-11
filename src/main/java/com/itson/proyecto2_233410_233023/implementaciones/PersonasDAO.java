/**
 * Clase PersonasDAO.java creada el 03/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Discapacitado;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IPersonasDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase para implementar toda la lógica de consultas de personas.
 *
 * @author Gabriel x Kim
 */
public class PersonasDAO implements IPersonasDAO {

    /**
     * Atributo que representa una conexión con la base de datos para realizar
     * consultas, insertar o actualizar.
     */
    private final IConexionBD conexionBD;

    /**
     * Método constructor el cual inicializa el atributo conexionBD al valor del
     * parámetro enviado.
     *
     * @param conexionBD conexionBD a iniciar.
     */
    public PersonasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    /**
     * Método para realizar la inserción masiva de 20 personas a la base de
     * datos.
     *
     * @return Valor booleano.
     */
    public boolean insercionMasivaPersonas() {
        GregorianCalendar fn = new GregorianCalendar(2003, 3, 3); // año, mes y día. mes empiza del 0

        //String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Discapacitado discapacitado, Calendar fechaNacimiento
        Persona p1 = new Persona("PEGJ931015", "Juan", "Pérez", "García", Discapacitado.NO, new GregorianCalendar(2006, 3, 3));
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

        //Agregar a una lista y persistir
        conexionBD.getEM().getTransaction().begin();
        List<Persona> personas = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
        for (Persona persona : personas) {
            conexionBD.getEM().persist(persona);
        }
        conexionBD.getEM().getTransaction().commit();
        return true;
    }

    @Override
    /**
     * Método para consultar una lista de personas.
     *
     * @param config Configuración del paginado.
     * @return Lista de personas.
     */
    public List<Persona> consultarPersonas(ConfiguracionPaginado config) {
        String consulta = "SELECT p from Persona p";
        Query query = conexionBD.getEM().createQuery(consulta);
        query.setFirstResult(config.getElementosASaltar());
        query.setMaxResults(config.getElementosPorPagina());
        List<Persona> personas = query.getResultList();
        return personas;
    }

    @Override
    /**
     * Método para consultar una lista de personas a partir de los filtros
     * enviados.
     *
     * @param filtro Filtro enviado (ID,RFC o Nombre).
     * @param dato Dato recuperado.
     * @param config Configuración del paginado.
     * @return Lista de personas.
     */
    public List<Persona> consultarPersonasFiltro(String filtroSeleccionado, String dato, ConfiguracionPaginado config) {
        List<Persona> personas = new ArrayList<Persona>();
        CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> entidad = criteriaQuery.from(Persona.class);
        if (filtroSeleccionado.equals("nombre") && dato != null) {
            personas = listaPersonasNombres(dato);  // para nombre se hace una consulta especifica debido a que esa columna esta encriptada en la base de datos
//            Predicate predicate = criteriaBuilder.equal(entidad.get("nombre"), dato);
//            //Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(entidad.get("nombre")), "%" + dato.toLowerCase() + "%");
//            criteriaQuery.where(predicate);
        } else {
            Predicate filtro = criteriaBuilder.like(entidad.get(filtroSeleccionado), ("%" + dato + "%"));
            criteriaQuery.where(filtro);
            TypedQuery<Persona> typedQuery = conexionBD.getEM().createQuery(criteriaQuery);
            typedQuery.setFirstResult(config.getElementosASaltar());
            typedQuery.setMaxResults(config.getElementosPorPagina());
            personas = typedQuery.getResultList();
        }

        return personas;
    }

    @Override
    /**
     * Método para obtener una persona a partir de la ID enviada.
     *
     * @param id ID de la persona.
     * @return Persona obtenida.
     */
    public Persona obtenerPersona(Long id) {
        try {
            String consulta = "SELECT p FROM Persona p WHERE p.id = :id";
            Query query = conexionBD.getEM().createQuery(consulta);
            query.setParameter("id", id);
            Persona persona = (Persona) query.getSingleResult();
            return persona;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Método que toma una fecha de tipo Calendar y la convierte en un String
     *
     * @param fecha fecha Calendar que se desea convertir a String
     * @return la fecha en formato String
     */
    private String fechaString(Calendar fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha deseado
        String fechaString = dateFormat.format(fecha.getTime());
        return fechaString;
    }

    /**
     * Método para consultar una lista de personas con dos clausalas where.
     *
     * @param personasDTO Objeto con los filtros seleccionados.
     * @param filtro1 que se desea comparar.
     * @param filtro2 que se desea comparar.
     * @return Lista de personas.
     *
     */
    @Override
    public List<Persona> consultarPersonasDosFiltro(PersonasDTO personasDTO, String filtro1, String filtro2) {
        try {
            List<Persona> personas = new ArrayList<Persona>();
            List<Persona> nombres = new ArrayList<Persona>();
            CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
            CriteriaQuery<Persona> cq = criteriaBuilder.createQuery(Persona.class);
            Root<Persona> root = cq.from(Persona.class);
            if (filtro2.equals("nombre")) {
                nombres = listaPersonasNombres(personasDTO.getNombre());
                if (filtro1.equals("rfc")) {
                    for (int i = 0; i < nombres.size(); i++) {
                        if (nombres.get(i).getRfc().toLowerCase().contains(personasDTO.getRfc().toLowerCase())) {
                            personas.add(nombres.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < nombres.size(); i++) {
                        String fechaNacimiento = fechaString(nombres.get(i).getFechaNacimiento());
                        if (fechaNacimiento.toLowerCase().contains(personasDTO.getFechaNacimiento().toLowerCase())) {
                            personas.add(nombres.get(i));
                        }
                    }
                }
            }
            return personas;
        } catch (Exception ex) {
            return null;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Método para consultar una lista de personas con tres clausalas where.
     *
     * @param personasDTO Objeto conn los filtros seleccionados.
     * @return Lista de personas que coincidan.
     */
    @Override
    public List<Persona> consultarPersonasTresFiltro(PersonasDTO personasDTO) {
        try {
            List<Persona> personas = new ArrayList<Persona>();
            List<Persona> nombres = new ArrayList<Persona>();
            List<Persona> auxiliar = new ArrayList<Persona>();
            CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
            CriteriaQuery<Persona> cq = criteriaBuilder.createQuery(Persona.class);
            Root<Persona> root = cq.from(Persona.class);
            nombres = listaPersonasNombres(personasDTO.getNombre());
            for (int i = 0; i < nombres.size(); i++) {
                if (nombres.get(i).getRfc().toLowerCase().contains(personasDTO.getRfc().toLowerCase())) {
                    auxiliar.add(nombres.get(i));
                }
            }
            for (int i = 0; i < auxiliar.size(); i++) {
                String fechaNacimiento = fechaString(auxiliar.get(i).getFechaNacimiento());
                if (fechaNacimiento.toLowerCase().contains(personasDTO.getFechaNacimiento().toLowerCase())) {
                    personas.add(auxiliar.get(i));
                }
            }
            return personas;
        } catch (Exception ex) {
            return null;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    /**
     * Consulta todas las personas de la tabla personas en la base de datos
     */
    public List<Persona> consultarPersonas() {
        List<Persona> personas = conexionBD.getEM().createQuery("SELECT a FROM Persona a", Persona.class).getResultList();
        return personas;
    }

    /**
     * Método para consultar una lista de personas con un clausala where.
     *
     * @param personasDTO Objeto con los filtros seleccionados.
     * @return Lista de personas.
     *
     */
    @Override
    public List<Persona> consultarPersonasUnFiltro(PersonasDTO personasDTO) {
        try {
            List<Persona> personas = new ArrayList<Persona>();
            CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
            CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
            Root<Persona> entidad = criteriaQuery.from(Persona.class);
            if (personasDTO.getNombre() != null) {
                personas = listaPersonasNombres(personasDTO.getNombre());
            } else if (personasDTO.getRfc() != null) {
                Predicate filtro = criteriaBuilder.like(entidad.get("rfc"), ("%" + personasDTO.getRfc() + "%"));
                criteriaQuery.where(filtro);
                TypedQuery<Persona> typedQuery = conexionBD.getEM().createQuery(criteriaQuery);
                personas = typedQuery.getResultList();
            } else {
                Predicate filtro = criteriaBuilder.equal(entidad.get("fechaNacimiento"), (personasDTO.getFechaNacimiento()));
                criteriaQuery.where(filtro);
                TypedQuery<Persona> typedQuery = conexionBD.getEM().createQuery(criteriaQuery);
                personas = typedQuery.getResultList();
            }
            return personas;
        } catch (Exception ex) {
            return null;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Método que tiene una lista de todas las personas registradas en la base
     * de datos, pero filtra a las que presentan unicamente el nombre dado.
     *
     * @param dato nombre que tienen que tener las personas en la lista.
     * @return lista de personas cuyos nombres coinciden con el dato enviado
     * como parametro.
     */
    private List<Persona> listaPersonasNombres(String dato) {
        List<Persona> personas = new ArrayList<Persona>();
        List<Persona> busqueda = new ArrayList<Persona>();
        busqueda = consultarPersonas();
        for (int i = 0; i < busqueda.size(); i++) {
            if (busqueda.get(i).getNombre().toLowerCase().contains(dato.toLowerCase()) || busqueda.get(i).getApellidoPaterno().toLowerCase().contains(dato.toLowerCase())) {
                personas.add(busqueda.get(i));
            }
        }
        return personas;
    }

}
