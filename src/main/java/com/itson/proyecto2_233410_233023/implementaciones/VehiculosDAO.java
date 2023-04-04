/**
 * Clase VehiculosDAO.java creada el 04/04/2023.
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Automovil;
import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Vehiculo;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IVehiculosDAO;
import javax.persistence.Query;

/**
 *
 * @author Gabriel x Kim
 */
public class VehiculosDAO implements IVehiculosDAO{
    private final IConexionBD conexionBD;  
    
    public VehiculosDAO(IConexionBD conexionBD){
         this.conexionBD = conexionBD;
    }
    @Override
    public Boolean registrarVehiculo(Vehiculo vehiculo) throws Exception {
    conexionBD.getEM().getTransaction().begin();
    conexionBD.getEM().persist(vehiculo);
    conexionBD.getEM().getTransaction().commit();
    return true;
    }
    
    @Override
    public Vehiculo obtenerVehiculo(String numeroSerie){
        try{
        String consulta = "SELECT v FROM Vehiculo v WHERE v.numeroSerie = :num";
        Query query = conexionBD.getEM().createQuery(consulta);
        query.setParameter("num", numeroSerie);
        Vehiculo vehiculo = (Vehiculo) query.getSingleResult();
        return vehiculo;
        }catch(Exception ex){
            return null;
        }
        
    }

    
}
