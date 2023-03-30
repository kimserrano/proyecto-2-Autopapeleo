/*
Clase Persona.Java creada el 29/03/2023.
*/
package com.itson.proyecto2_233410_233023.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la entidad Persona para ser mapeada en la base de datos
 * @author Gabriel x Kim
 */
@Table(name = "Personas")
@Entity
public class Persona implements Serializable {

    /**
     * Atributo que sirve para identificar a una persona en especifico 
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Atributo que identifica a una persona de otra
     */
    @Column(name = "rfc", nullable= false, length=13)
    private String rfc;
    
    /**
     * Atributo para conocer los nombres que tiene la persona 
     */
    @Column(name = "nombres", nullable= false, length=50)
    private String nombres;
    
    /**
     * Atributo para conocer el apellido paterno de la persona
     */
    @Column(name = "apellidoPaterno", nullable=false, length=50)
    private String apellidoPaterno;
    
    /**
     * Atributo para conoces el apellido Materno de la persona
     */
    @Column(name = "apellidoMaterno", nullable= false, length=50)
    private String apellidoMaterno;
    
    /**
     * Atributo para conocer si una persona presenta alguna discapacidad 
     */
    @Column(name = "discapacitado", nullable= false)
    @Enumerated(EnumType.STRING)
    private Discapacitado discapacitado;
    
    /**
     * Atributo que syuda a conocer el telefono de una persona para su contacto
     */
    @Column(name = "telefono", nullable=true, length=50)
    private String telefono;
    
    /**
     * Atributo para conocer el dia en que nacio una persona para asi conocer su 
     * edad 
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable= false)
    private Calendar fechaNacimiento;
    
    
    @OneToMany(mappedBy = "persona") 
    private List<Vehiculo> vehiculos;
    /**
     * Constructor por defecto para crear personas dentro de la base de datos 
     */
    public Persona() {
    }

    /**
     * Constructor para registrar a una persona dentro de la base de datos, especificando 
     * algunos atributos 
     * @param rfc especifica el rfc de la persona
     * @param nombres son los nombres que tiene la persona
     * @param apellidoPaterno apellido paterno de la persona 
     * @param apellidoMaterno apellido materno de la persona 
     * @param discapacitado para conocer si la persona es discapacitada
     * @param telefono para una forma de contacto con la persona 
     * @param fechaNacimiento para saber la fecha en que nacio la persona 
     */
    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Discapacitado discapacitado, String telefono, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.discapacitado = discapacitado;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor para registrar a una persona dentro de la base de datos, especificando 
     * algunos atributos 
     * @param rfc especifica el rfc de la persona
     * @param nombres son los nombres que tiene la persona
     * @param apellidoPaterno apellido paterno de la persona 
     * @param apellidoMaterno apellido materno de la persona 
     * @param discapacitado para conocer si la persona es discapacitada
     * @param fechaNacimiento para saber la fecha en que nacio la persona 
     */
    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Discapacitado discapacitado, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.discapacitado = discapacitado;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Para obtener el rfc de la persona 
     * @return string que representa el rfc de la persona
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Para definirle un rfc a la persona 
     * @param rfc rfc de la persona 
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene los nombres de la persona
     * @return string con los nombres de la persona
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece el nombre de la persona 
     * @param nombres nombres de la persona
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno de la persona 
     * @return apellido paterno de la persona 
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona 
     * @param apellidoPaterno apellido paterno de la persona
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno de la persona 
     * @return apellido materno de la persona
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona
     * @param apellidoMaterno apellido materno de la persona
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene si una persona presenta una discapacidad 
     * @return la discapacidad de la persona 
     */
    public Discapacitado getDiscapacitado() {
        return discapacitado;
    }

    /**
     * Establece si una persona es discapacitada 
     * @param discapacitado la discapacidad de la persona 
     */
    public void setDiscapacitado(Discapacitado discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     * Obtiene el telefono de la persona 
     * @return string con el telefono de la persona
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el telefono de la persona 
     * @param telefono el telefono de la persona 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona
     * @return la fecha de nacimiento de la persona
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona
     * @param fechaNacimiento la fecha de nacimiento de la persona
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * Obtiene la lista de vehículos de la persona
     * @return lista de vehículos de la persona
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /**
     * Establece los vehículos de la persona
     * @param vehiculos vehículos de la persona
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene el id que identifica a esa persona 
     * @return id que identifica a esa persona
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id que identifica a esa persona 
     * @param id id que identifica a esa persona 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Para obtener el numero hash de la persona
     * @return numero hash 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Para comparar un objeto con otro 
     * @param object objeto que deseas comprar
     * @return regresa falso si son distintos y verdadero en caso contrario 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo usado para escribir y con ello conocer los atributos de la persona
     * @return atributos de la persona en orden
     */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", rfc=" + rfc + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", discapacitado=" + discapacitado + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
