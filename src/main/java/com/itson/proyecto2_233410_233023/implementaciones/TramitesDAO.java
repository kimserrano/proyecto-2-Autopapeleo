/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Licencia;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.dominio.TramiteLicencia;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.ITramitesDAO;

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
    public Boolean tramiteLicencia(TramiteLicencia tramite) throws Exception {
         conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(tramite);
        conexionBD.getEM().getTransaction().commit();
        return true;
    }

}
