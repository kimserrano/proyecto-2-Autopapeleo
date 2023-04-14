/**
 * Clase PersonasDAO.java creada el 03/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.*;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.ITramitesDAO;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 * Clase para implementar toda la lógica de consultas de trámites.
 *
 * @author Gabriel x Kim
 */
public class TramitesDAO implements ITramitesDAO {

    /**
     * Atributo que representa una conexión con la base de datos para realizar
     * consultas, insertar o actualizar.
     */
    private final IConexionBD conexionBD;

    /**
     * Constructor para inicializar la conexión con la base de datos.
     *
     * @param conexionBD conexión con la base de datos.
     */
    public TramitesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Método que se encarga de hacer el insert de una tramite de una licencia a
     * la base de datos.
     *
     * @param tramite el cual se requiere hacer un insert a la base.
     * @return true si fue posible.
     * @throws Exception lanza una expeción en caso de no poder.
     */
    @Override
    public Boolean tramitarLicencia(TramiteLicencia tramite) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(tramite);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo tramitar la licencia");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    /**
     * Método que actualiza el estado de una licencia y lanza un una excepción
     * en caso de no lograrse la actualización.
     */
    public void actualizarLicencia(Licencia licenciaActual) throws Exception {
        try {
            if (licenciaActual != null) {

                Licencia licenciaActualizada = conexionBD.getEM().find(Licencia.class, licenciaActual.getId());
                licenciaActualizada.setEstado(Estado.INACTIVA);
                EntityTransaction tx = conexionBD.getEM().getTransaction();
                tx.begin();
                conexionBD.getEM().merge(licenciaActualizada);
                tx.commit();
            }
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Método para tramitar una placa.
     *
     * @param tramite Tramite de placa a realizar.
     * @return Valor booleano.
     * @throws Exception Excepción a lanzar en caso de fallar el trámite.
     */
    @Override
    public Boolean tramitarPlaca(TramitePlaca tramite) throws Exception {
        try{
        conexionBD.getEM().getTransaction().begin();
        Placa placa = buscarPlacaActiva(tramite);
        actualizarPlaca(placa, tramite);
        conexionBD.getEM().persist(tramite);
        conexionBD.getEM().getTransaction().commit();
        return true;
        }catch(DatabaseException ex){
            throw new PersistenciaException("El número de placa ya está registrado.");
        }catch(Exception ex){
             throw new PersistenciaException("Error al realizar el trámite.");
        }finally{
            conexionBD.getEM().clear();
        }
    }
    /**
     * Método para obtener una placa a partir del número alfanumérico.
     * @param numeroAlfa Número alfanumérico.
     * @return Placa encontrada.
     * @throws Exception Excepción a lanzar en caso de fallar la búsqueda.
     */
    @Override
    public Placa obtenerPlaca(String numeroAlfa) throws Exception{
        try {
            Placa placaObtenida = conexionBD.getEM().createQuery("SELECT p FROM Placa p WHERE p.numeroAlfanumerico = :numeroAlfa", Placa.class)
                    .setParameter("numeroAlfa",numeroAlfa)
                    .getSingleResult();
            return placaObtenida;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar la búsqueda de la placa.");
        } finally {
            conexionBD.getEM().clear();
        }
    }
    /**
     * Método que cambia el estado de la placa a inactiva y la fecha de
     * expedicion por la del trámite.
     *
     * @param placaActual Placa actual.
     * @param tramite Tramite actual.
     */
    @Override
    public void actualizarPlaca(Placa placaActual, TramitePlaca tramite) {

        if (placaActual != null) {
            placaActual.setEstado(Estado.INACTIVA);
            placaActual.setFechaRecepcion(tramite.getFechaExpedicion());
            conexionBD.getEM().merge(placaActual);
        }
    }

    /**
     * Método para buscar una placa activa.
     *
     * @param tramite Tramite actual.
     * @return Placa activa encontrada.
     * @throws Exception Excepción en caso de no poder realizar la búsqueda.
     */
    @Override
    public Placa buscarPlacaActiva(TramitePlaca tramite) throws Exception {
        try {
            Placa placaActual = conexionBD.getEM().createQuery("SELECT p FROM Placa p WHERE p.estado = :estado AND p.vehiculo = :vehiculo", Placa.class)
                    .setParameter("estado", Estado.ACTIVA)
                    .setParameter("vehiculo", tramite.getPlaca().getVehiculo())
                    .getSingleResult();
            return placaActual;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar la búsqueda de la placa activa.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Método que se encarga de buscar si una persona tiene una licencia que
     * este activa.
     *
     * @param persona persona de la que se desea conoce el estado de su
     * licencia.
     * @return la licencia de la persona.
     * @throws Exception si no se encuentra la licencia activa.
     */
    @Override
    public Licencia buscarLicenciaActiva(Persona persona) throws Exception {
        try {
            Licencia licenciaActual = conexionBD.getEM().createQuery("SELECT l FROM Persona p JOIN p.tramites t JOIN TramiteLicencia tl ON t.id = tl.id JOIN tl.licencia l WHERE p = :persona AND l.estado = :estado ORDER BY l.fechaExpedicion DESC", Licencia.class)
                    .setParameter("persona", persona)
                    .setParameter("estado", Estado.ACTIVA)
                    .setMaxResults(1)
                    .getSingleResult();
            return licenciaActual;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("No se pudo realizar la búsqueda de la licencia activa.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Método que realiza una consulta de trámites de tipo licencia.
     *
     * @return lista de trámites de tipo lecencia.
     * @throws Exception si no se puede consultar la lista.
     */
    @Override
    public List<TramiteLicencia> consultarTramitesLicencia() throws Exception {
        try {
            TypedQuery<TramiteLicencia> queryTramitesLicencia = conexionBD.getEM().createQuery("SELECT e FROM Tramite e WHERE TYPE(e) = TramiteLicencia", TramiteLicencia.class);
            List<TramiteLicencia> tramitesLicencia = queryTramitesLicencia.getResultList();
            return tramitesLicencia;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo consultar la lista de trámites de licencia.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Método que consulta un Stored Procedure en la base de datos de los días
     * transcurridos.
     *
     * @param fechaInicio Inicio del periodo.
     * @param fechaFin Fin del periodo.
     * @return Días transcurridos.
     */
    @Override
    public Long consultarDiasTransurridosSP(Calendar fechaInicio, Calendar fechaFin) {
        try {
            StoredProcedureQuery storedProcedure = conexionBD.getEM().createStoredProcedureQuery("calcular_dias_transcurridos");
            storedProcedure.registerStoredProcedureParameter("fecha_inicio", Calendar.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("fecha_fin", Calendar.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("dias_transcurridos", Integer.class, ParameterMode.OUT);
            storedProcedure.setParameter("fecha_inicio", fechaInicio);
            storedProcedure.setParameter("fecha_fin", fechaFin);
            storedProcedure.execute();
            Long diasTranscurridos = (Long) storedProcedure.getOutputParameterValue("dias_transcurridos");
            return diasTranscurridos;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Consulta los trámites registrados en la base de datos.
     *
     * @return Lista de trámites.
     */
    @Override
    public List<Tramite> consultarColumnaTipoTramite() {
        try {
            List<Tramite> tramites = conexionBD.getEM().createQuery("SELECT a FROM Tramite a", Tramite.class).getResultList();
            return tramites;
        } finally {
            conexionBD.getEM().clear();
        }
    }

    /**
     * Consulta aquellos trámites que están dentro de el periodo enviado como
     * parámetro.
     *
     * @param fechaInicio Inicio del periodo.
     * @param fechaFin Fin del periodo.
     * @return Lista de tramites cuya fecha de expedición esté dentro de ese
     * periodo.
     */
    @Override
    public List<Tramite> periodoFechaTramite(String fechaInicio, String fechaFin) {
        try {
            CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
            CriteriaQuery<Tramite> cq = criteriaBuilder.createQuery(Tramite.class);
            Root<Tramite> root = cq.from(Tramite.class);
            Predicate periodo = criteriaBuilder.between(root.get("fechaExpedicion"), fechaInicio, fechaFin);
            cq.select(root).where(periodo);
            TypedQuery<Tramite> typedQuery = conexionBD.getEM().createQuery(cq);
            List<Tramite> resultados = typedQuery.getResultList();
            return resultados;
        } finally {
            conexionBD.getEM().clear();
        }
    }
}
