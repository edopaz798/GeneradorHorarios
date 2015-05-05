/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Clase que repesenta la entidad Docente
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Docente implements Serializable {

    @OneToMany(mappedBy = "docente")
    private List<ProfesorProhibicion> profesorProhibicions;
    @OneToMany(mappedBy = "docente")
    private List<DetalleHorario> detalleHorarios;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer cedula;

    /**
     * Metodo para obtener el valor actual de la variable id que es de tipo Long
     *
     * @return retorna el valor de la variable id
     * @since 1.0.0
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable id
     *
     * @param id Long a guardar
     * @since 1.0.0
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el valor actual de la variable nombre que es de tipo
     * String
     *
     * @return retorna el valor de la variable nombre
     * @since 1.0.0
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable nombre
     *
     * @param nombre String a guardar
     * @since 1.0.0
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el valor actual de la variable apellido que es de
     * tipo String
     *
     * @return retorna el valor de la variable apellido
     * @since 1.0.0
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable apellido
     *
     * @param apellido String a guardar
     * @since 1.0.0
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Metodo para obtener el valor actual de la variable cedula que es de tipo
     * Integer
     *
     * @return retorna el valor de la variable cedula
     * @since 1.0.0
     */
    public Integer getCedula() {
        return cedula;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable cedula
     *
     * @param cedula Integer a guardar
     * @since 1.0.0
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo para obtener el valor actual de la variable profesorProhibicions
     * que es de tipo List(ProfesorProhibicion)
     *
     * @return retorna el valor de la variable profesorProhibicions
     * @since 1.0.0
     */
    public List<ProfesorProhibicion> getProfesorProhibicions() {
        return profesorProhibicions;
    }

    /**
     * Metodo para obtener el valor actual de la variable detalleHorarios que es
     * de tipo List(DetalleHorario)
     *
     * @return retorna el valor de la variable detalleHorarios
     * @since 1.0.0
     */
    public List<DetalleHorario> getDetalleHorarios() {
        return detalleHorarios;
    }

}
