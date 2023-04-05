/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.ILicenciasDAO;

/**
 *
 * @author Gabriel x Kim
 */
public class LicenciasDAO implements ILicenciasDAO {

    private final IConexionBD conexionBD;

    public LicenciasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Boolean registrarLicencia(Licencia licencia) throws Exception {
        conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(licencia);
        conexionBD.getEM().getTransaction().commit();
        return true;
    }

}
