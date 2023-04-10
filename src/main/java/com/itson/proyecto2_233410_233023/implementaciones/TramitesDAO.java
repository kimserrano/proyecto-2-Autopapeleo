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
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
     * @param conexionBD
     */
    public TramitesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    /**
     * Método que se encarga de hacer el insert de una licencia a la base de
     * datos, lanza una expeción en caso de no poder.
     */
    public Boolean registrarLicencia(Licencia licencia) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(licencia);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo registrar la licencia.");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    /**
     * Método que se encarga de hacer el insert de una tramite de una licencia a
     * la base de datos, lanza una expeción en caso de no poder.
     */
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
    public void actualizarLicencia(Licencia licenciaActual, TramiteLicencia tramiteLicencia) throws Exception {
        try {
            if (licenciaActual != null && tramiteLicencia != null) {
                licenciaActual.setEstado(Estado.INACTIVA);
                licenciaActual.setFechaExpedicion(tramiteLicencia.getFechaExpedicion());
                conexionBD.getEM().merge(licenciaActual);
            }
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo actualizar la licencia ");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    /**
     * Método que se encarga de hacer el insert de una placa a la base de datos,
     * lanza una expeción en caso de no poder.
     */
    public Boolean registrarPlaca(Placa placa) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(placa);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo registrar la placa");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    /**
     * Método que hace una actualizacion de una placa en caso de existir e
     * inserta un tramite placa a la base de datos, además verifica que las
     * placas no esten dupicadas o si no se pudo realizar el trámite de esa
     * placa.
     */
    public Boolean tramitarPlaca(TramitePlaca tramite) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            Placa placa = buscarPlacaActiva(tramite);
            actualizarPlaca(placa, tramite);
            conexionBD.getEM().persist(tramite);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new PersistenciaException("Placas duplicadas, no se puede realizar el trámite.");
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo realizar el trámite");
        } finally {
            conexionBD.getEM().clear();
        }
    }

    @Override
    /**
     * Método que cambia el estado de la placa a inactiva y la fecha de
     * expedicion por la del trámite.
     */
    public void actualizarPlaca(Placa placaActual, TramitePlaca tramite) {
        if (placaActual != null) {
            placaActual.setEstado(Estado.INACTIVA);
            placaActual.setFechaRecepcion(tramite.getFechaExpedicion());
            conexionBD.getEM().merge(placaActual);
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws Exception
     */
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

    @Override
    /**
     *
     */
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

    @Override
    /**
     * Método que hace una consulta de trámites, pero solo trae aquellos que son
     * de tipo TramiteLicencia.
     */
    public List<TramiteLicencia> consultarTramitesLicencia() {
        TypedQuery<TramiteLicencia> queryTramitesLicencia = conexionBD.getEM().createQuery("SELECT e FROM Tramite e WHERE TYPE(e) = TramiteLicencia", TramiteLicencia.class);
        List<TramiteLicencia> tramitesLicencia = queryTramitesLicencia.getResultList();
        return tramitesLicencia;
    }

    @Override
    /**
     * Método que hace una consulta de trámites, pero solo trae aquellos que son
     * de tipo TramitePlaca.
     */
    public List<TramitePlaca> consultarTramitesPlaca() {
        TypedQuery<TramitePlaca> queryTramitesLicencia = conexionBD.getEM().createQuery("SELECT e FROM Tramite e WHERE TYPE(e) = TramitePlaca", TramitePlaca.class);
        List<TramitePlaca> tramitesLicencia = queryTramitesLicencia.getResultList();
        return tramitesLicencia;
    }

    @Override
    /**
     * Método que llama al Stored Procedure "calcular_dias_transcurridos" creado
     * en la base de datos, se usa para calcular los días que le quedan de
     * vigencia a la licencia actual.
     */
    public Long consultarDiasTransurridosSP(Calendar fechaInicio, Calendar fechaFin) {
        StoredProcedureQuery storedProcedure = conexionBD.getEM().createStoredProcedureQuery("calcular_dias_transcurridos");
        storedProcedure.registerStoredProcedureParameter("fecha_inicio", Calendar.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("fecha_fin", Calendar.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("dias_transcurridos", Integer.class, ParameterMode.OUT);
        storedProcedure.setParameter("fecha_inicio", fechaInicio);
        storedProcedure.setParameter("fecha_fin", fechaFin);
        storedProcedure.execute();
        Long diasTranscurridos = (Long) storedProcedure.getOutputParameterValue("dias_transcurridos");
        return diasTranscurridos;
    }

    @Override
    /**
     * Consulta los tramites registrados en la base de datos.
     */
    public List<Tramite> consultarColumnaTipoTramite() {
        List<Tramite> tramites = conexionBD.getEM().createQuery("SELECT a FROM Tramite a", Tramite.class).getResultList();
        return tramites;
    }

    @Override
    /**
     * Consulta aquellos tramites que estan dentro de el periodo enviado como
     * paramero.
     */
    public List<Tramite> periodoFechaTramite(String fechaInicio, String fechaFin) {
        CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
        CriteriaQuery<Tramite> cq = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> root = cq.from(Tramite.class);
        Predicate periodo = criteriaBuilder.between(root.get("fechaExpedicion"), fechaInicio, fechaFin);
        cq.select(root).where(periodo);
        TypedQuery<Tramite> typedQuery = conexionBD.getEM().createQuery(cq);
        List<Tramite> resultados = typedQuery.getResultList();
        return resultados;
    }
}
