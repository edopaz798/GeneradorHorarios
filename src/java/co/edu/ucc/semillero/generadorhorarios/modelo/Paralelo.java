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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Clase que repesenta la entidad Paralelo
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Paralelo implements Serializable {

    @OneToMany(mappedBy = "paralelo")
    private List<DetalleHorario> detalleHorarios;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @ManyToOne
    private Semestre semestre;
    @ManyToOne
    private Facultad facultad;

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
     * Metodo para obtener el valor actual de la variable id que es de tipo Long
     *
     * @return retorna el valor de la variable id
     * @since 1.0.0
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para guardar un valor de tipo Long en la variable nombre
     *
     * @param id Long a guardar
     * @since 1.0.0
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el valor actual de la variable semestre que es de
     * tipo Semestre
     *
     * @return retorna el valor de la variable semestre
     * @since 1.0.0
     */
    public Semestre getSemestre() {
        return semestre;
    }

    /**
     * Metodo para guardar un valor de tipo Semestre en la variable semestre
     *
     * @param semestre Semestre a guardar
     * @since 1.0.0
     */
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    /**
     * Metodo para obtener el valor actual de la variable facultad que es de
     * tipo Facultad
     *
     * @return retorna el valor de la variable facultad
     * @since 1.0.0
     */
    public Facultad getFacultad() {
        return facultad;
    }

    /**
     * Metodo para guardar un valor de tipo Facultad en la variable facultad
     *
     * @param facultad Facultad a guardar
     * @since 1.0.0
     */
    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
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
