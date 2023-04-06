/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.Placa;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;
import com.itson.proyecto2_233410_233023.dominio.TramitePlaca;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.ITramitesDAO;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.persistence.NoResultException;

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
    public Boolean registrarPlaca(Placa placa) throws Exception {
        conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(placa);
        conexionBD.getEM().getTransaction().commit();
        return true;
    }
    @Override
    public Boolean tramitarPlaca(TramitePlaca tramite) throws Exception {
        try{   
        conexionBD.getEM().getTransaction().begin();
        Placa placa = buscarPlacaActiva(tramite);
        actualizarPlaca(placa,tramite); 
        conexionBD.getEM().persist(tramite);
        conexionBD.getEM().getTransaction().commit();
        return true;
        }catch(SQLIntegrityConstraintViolationException ex){
            throw new PersistenciaException("Placas duplicadas, no se puede realizar el trámite.");
        }catch(Exception ex){
            throw new PersistenciaException("No se pudo realizar el trámite");
        }finally{
        conexionBD.getEM().clear();
        }
    }
    
    @Override
    public void actualizarPlaca(Placa placaActual, TramitePlaca tramite){
        if(placaActual!=null){
        placaActual.setEstado(Estado.INACTIVA);
        placaActual.setFechaRecepcion(tramite.getFechaExpedicion());
        conexionBD.getEM().merge(placaActual);
    }
}
    @Override
    public Placa buscarPlacaActiva(TramitePlaca tramite) throws Exception{
       try{
        Placa placaActual = conexionBD.getEM().createQuery("SELECT p FROM Placa p WHERE p.estado = :estado AND p.vehiculo = :vehiculo", Placa.class)
                .setParameter("estado", Estado.ACTIVA)
                .setParameter("vehiculo", tramite.getPlaca().getVehiculo())
        .getSingleResult();
        return placaActual;
       }catch(NoResultException ex){
           return null;
       }catch(Exception ex){
            throw new PersistenciaException("No se pudo realizar el trámite");
       }
    }
}
