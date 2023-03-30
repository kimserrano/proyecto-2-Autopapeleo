/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gabriel x Kim
 */
@Entity
@Table(name="Vehiculos")
public class Vehiculo implements Serializable {

   
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_serie",nullable=false,length=6)
    private String numeroSerie;
    @Column(name = "modelo",nullable=false,length=50)
    private String modelo;
    @Column(name = "marca",nullable=false,length=50)
    private String marca;
    @Column(name = "linea",nullable=false,length=50)
    private String linea;
    @Column(name = "color",nullable=false,length=30)
    private String color;
    @ManyToOne()
    @JoinColumn(name="id_persona",nullable=false) 
    private Persona persona;
    @OneToMany(mappedBy = "vehiculo") 
    private List<Placa> placas;
    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie, String modelo, String marca, String linea, String color, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
    }

    public Vehiculo(String numeroSerie, String modelo, String marca, String linea, String color, Persona persona, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
        this.placas = placas;
    }
    
    

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itson.proyecto2_233410_233023.dominio.Vehiculo[ id=" + id + " ]";
    }
    
}
