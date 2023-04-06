/**
 * Clase VehiculosDAO.java creada el 04/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Automovil;
import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Vehiculo;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IVehiculosDAO;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gabriel x Kim
 */
public class VehiculosDAO implements IVehiculosDAO {

    private final IConexionBD conexionBD;

    public VehiculosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Boolean registrarVehiculo(Vehiculo vehiculo) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(vehiculo);
            conexionBD.getEM().getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo registrar el Vehículo.");
        } finally {
           conexionBD.getEM().clear();
        }

    }

    @Override
    public Vehiculo obtenerVehiculo(String numeroSerie) throws Exception {
        try {
            String consulta = "SELECT v FROM Vehiculo v WHERE v.numeroSerie = :num";
            Query query = conexionBD.getEM().createQuery(consulta);
            query.setParameter("num", numeroSerie);
            Vehiculo vehiculo = (Vehiculo) query.getSingleResult();
            return vehiculo;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo recuperar el Vehículo.");
        } finally {
          conexionBD.getEM().clear();
        }

    }

    @Override
    public Vehiculo obtenerVehiculoUsado(String placa) throws Exception {
        conexionBD.getEM().clear();
        try {
            String consulta = "SELECT v FROM Vehiculo v INNER JOIN v.placas p WHERE p.numeroAlfanumerico = :numeroAlfanumerico AND p.estado = :estado";
            Query query = conexionBD.getEM().createQuery(consulta);
            query.setParameter("numeroAlfanumerico", placa);
            query.setParameter("estado", Estado.ACTIVA);
            Vehiculo vehiculo = (Vehiculo) query.getSingleResult();
            return vehiculo;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo recuperar el Vehículo.");
        } finally {
           conexionBD.getEM().clear();
        }
    }
    
    public Vehiculo obtenerVehiculoSinHistorial(String numeroSerie) throws Exception {
        try {
        String consulta = "SELECT v FROM Vehiculo v WHERE v.numeroSerie = :num AND NOT EXISTS "
                + "(SELECT p FROM Placa p WHERE p.vehiculo = v)";
        Query query = conexionBD.getEM().createQuery(consulta, Vehiculo.class);
        query.setParameter("num", numeroSerie);
        Vehiculo vehiculo = (Vehiculo)query.getSingleResult();
        return vehiculo;
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            throw new PersistenciaException("No se pudo recuperar el Vehículo.");
        } finally {
           conexionBD.getEM().clear();
        }
    }
//    public Vehiculo obtenerVehiculoRegistrado(String numSerie){
//        
//    }
}
