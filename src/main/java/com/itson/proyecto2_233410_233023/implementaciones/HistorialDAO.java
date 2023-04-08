/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.implementaciones;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.dominio.Tramite;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IHistorialDAO;
import com.itson.proyecto2_233410_233023.interfaces.IPersonasDAO;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author kim
 */
public class HistorialDAO implements IHistorialDAO {

    private final IConexionBD conexionBD;

    public HistorialDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<Persona> buscar(PersonasDTO params) {
        CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
        CriteriaQuery<Persona> criteria = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);

        List<Predicate> filtros = new LinkedList<>();
        if (params.getNombre() != null) {
            filtros.add(criteriaBuilder.like(root.get("nombre"), "%" + params.getNombre() + "%"));
        }
        if (params.getRfc() != null) {
            filtros.add(criteriaBuilder.like(root.get("rfc"), params.getRfc()));
        }
        if (params.getFechaNacimiento() != null) {
            filtros.add(criteriaBuilder.like(root.get("fechaNacimiento"), "%" + params.getFechaNacimiento() + "%"));
        }
        criteria = criteria.select(root).where(criteriaBuilder.and(filtros.toArray(new Predicate[filtros.size()])));
        TypedQuery<Persona> query = conexionBD.getEM().createQuery(criteria);

        List<Persona> personas = query.getResultList();
        return personas;
    }

//    public List<Persona> buscarPorRfc(PersonasDTO params) {
//        CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
//        CriteriaQuery<Persona> criteria = criteriaBuilder.createQuery(Persona.class);
//        Root<Persona> root = criteria.from(Persona.class);
//        List<Predicate> filtros = new LinkedList<>();
//        if (params.getRfc() != null) {
//            filtros.add(criteriaBuilder.like(root.get("rfc"), params.getRfc()));
//        }
//        criteria = criteria.select(root).where(criteriaBuilder.and(filtros.toArray(new Predicate[filtros.size()])));
//        TypedQuery<Persona> query = conexionBD.getEM().createQuery(criteria);
//
//        List<Persona> personas = query.getResultList();
//        return personas;
//    }
//
//    public List<Persona> buscarPorFechaNacimiento(PersonasDTO params) {
//        CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
//        CriteriaQuery<Persona> criteria = criteriaBuilder.createQuery(Persona.class);
//        Root<Persona> root = criteria.from(Persona.class);
//        List<Predicate> filtros = new LinkedList<>();
//        if (params.getFechaNacimiento() != null) {
//            filtros.add(criteriaBuilder.like(root.get("fechaNacimiento"), "%" + params.getFechaNacimiento() + "%"));
//        }
//        criteria = criteria.select(root).where(criteriaBuilder.and(filtros.toArray(new Predicate[filtros.size()])));
//        TypedQuery<Persona> query = conexionBD.getEM().createQuery(criteria);
//
//        List<Persona> personas = query.getResultList();
//        return personas;
//    }
//    
//      public List<Persona> buscarPorNombre(PersonasDTO params) {
//        CriteriaBuilder criteriaBuilder = conexionBD.getEM().getCriteriaBuilder();
//        CriteriaQuery<Persona> criteria = criteriaBuilder.createQuery(Persona.class);
//        Root<Persona> root = criteria.from(Persona.class);
//        List<Predicate> filtros = new LinkedList<>();
//       if (params.getNombre() != null) {
//            filtros.add(criteriaBuilder.like(root.get("nombre"), "%" + params.getNombre() + "%"));
//        }
//        criteria = criteria.select(root).where(criteriaBuilder.and(filtros.toArray(new Predicate[filtros.size()])));
//        TypedQuery<Persona> query = conexionBD.getEM().createQuery(criteria);
//
//        List<Persona> personas = query.getResultList();
//        return personas;
//    }
    
    

}
