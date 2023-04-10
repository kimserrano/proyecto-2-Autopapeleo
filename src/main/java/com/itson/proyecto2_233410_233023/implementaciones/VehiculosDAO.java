/**
 * Clase VehiculosDAO.java creada el 04/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Estado;
import com.itson.proyecto2_233410_233023.dominio.Vehiculo;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IVehiculosDAO;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Gabriel x Kim
 */
public class VehiculosDAO implements IVehiculosDAO {
    /**
     * Atributo que representa la conexión de la base de datos.
     */
    private final IConexionBD conexionBD;
    /**
     * Método constructor que inicializa el atributo al valor de los parámetros enviados.
     * @param conexionBD Conexión con la base de datos.
     */
    public VehiculosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    /**
     * Método para registrar un vehículo en la base de datos.
     * @param vehiculo Vehículo a registrar.
     * @return Valor booleano.
     * @throws Exception Excepción a lanzar. 
     */
    @Override
    public Boolean registrarVehiculo(Vehiculo vehiculo) throws Exception {
        try {
            conexionBD.getEM().getTransaction().begin();
            conexionBD.getEM().persist(vehiculo);
            conexionBD.getEM().getTransaction().commit();
            return true;
        }catch (Exception ex) {
            throw new PersistenciaException("No se pudo registrar el Vehículo.");
        } finally {
            conexionBD.getEM().clear();
        }

    }
    /**
     * Método para obtener un vehículo a partir del número de serie.
     * @param numeroSerie Número de serie del vehículo.
     * @return Vehículo obtenido.
     * @throws Exception Excepción a lanzar.
     */
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
    /**
     * Método para obtener un vehículo usado a partir de su placa actual.
     * @param placa Placa del vehículo.
     * @return Vehículo obtenido.
     * @throws Exception Excepción a lanzar.
     */
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
    /**
     * Método para obtener un vehículo sin historial a partir de su número de serie.
     * @param numeroSerie Número de serie del vehículo.
     * @return Vehículo obtenido.
     * @throws Exception Excepción a lanzar.
     */
    public Vehiculo obtenerVehiculoSinHistorial(String numeroSerie) throws Exception {
        try {
            String consulta = "SELECT v FROM Vehiculo v WHERE v.numeroSerie = :num AND NOT EXISTS "
                    + "(SELECT p FROM Placa p WHERE p.vehiculo = v)";
            Query query = conexionBD.getEM().createQuery(consulta, Vehiculo.class);
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
}
