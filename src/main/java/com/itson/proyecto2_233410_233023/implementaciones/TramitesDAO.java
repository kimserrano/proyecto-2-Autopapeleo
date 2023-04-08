/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Placa;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;
import com.itson.proyecto2_233410_233023.dominio.TramitePlaca;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.ITramitesDAO;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;
import java.util.Date;
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
 *
 * @author Gabriel x Kim
 */
public class TramitesDAO implements ITramitesDAO {

    private final IConexionBD conexionBD;

    public TramitesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Boolean registrarLicencia(Licencia licencia) throws Exception {
        conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(licencia);
        conexionBD.getEM().getTransaction().commit();
        return true;
    }

    @Override
    public Boolean tramitarLicencia(TramiteLicencia tramite) throws Exception {
        conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(tramite);
        conexionBD.getEM().getTransaction().commit();
        return true;
    }

    @Override
    public void actualizarLicencia(Licencia licenciaActual, TramiteLicencia tramiteLicencia) {
        if (licenciaActual != null && tramiteLicencia != null) {
            licenciaActual.setEstado(Estado.INACTIVA);
            licenciaActual.setFechaExpedicion(tramiteLicencia.getFechaExpedicion());
            conexionBD.getEM().merge(licenciaActual);
        }
    }

    @Override
    public Boolean registrarPlaca(Placa placa) throws Exception {
        conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(placa);
        conexionBD.getEM().getTransaction().commit();
        return true;
    }

    @Override
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
    public void actualizarPlaca(Placa placaActual, TramitePlaca tramite) {
        if (placaActual != null) {
            placaActual.setEstado(Estado.INACTIVA);
            placaActual.setFechaRecepcion(tramite.getFechaExpedicion());
            conexionBD.getEM().merge(placaActual);
        }
    }

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
            throw new PersistenciaException("No se pudo realizar el trámite");
        }
    }

    @Override
    public List<TramiteLicencia> consultarTramitesLicencia() {
        TypedQuery<TramiteLicencia> queryTramitesLicencia = conexionBD.getEM().createQuery("SELECT e FROM Tramite e WHERE TYPE(e) = TramiteLicencia", TramiteLicencia.class);
        List<TramiteLicencia> tramitesLicencia = queryTramitesLicencia.getResultList();
        return tramitesLicencia;
    }

    @Override
    public List<TramitePlaca> consultarTramitesPlaca() {
        TypedQuery<TramitePlaca> queryTramitesLicencia = conexionBD.getEM().createQuery("SELECT e FROM Tramite e WHERE TYPE(e) = TramitePlaca", TramitePlaca.class);
        List<TramitePlaca> tramitesLicencia = queryTramitesLicencia.getResultList();
        return tramitesLicencia;
    }

    @Override
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
    public List<Tramite> consultarColumnaTipoTramite() {
        List<Tramite> tramites = conexionBD.getEM().createQuery("SELECT a FROM Tramite a", Tramite.class).getResultList();
//        for (Tramite tramite : tramites) {
//            if (tramite instanceof TramiteLicencia) {
//                return "TramiteLicencia";
//            } else if (tramite instanceof TramitePlaca) {
//                return "TramitePlaca";
//            }
//        }
        return tramites;
    }
}
