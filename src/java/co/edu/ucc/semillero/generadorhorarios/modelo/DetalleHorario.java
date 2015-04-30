/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Clase que repesenta la entidad DetalleHorario
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class DetalleHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Dia dia;
    @ManyToOne
    private Hora hora;
    @ManyToOne
    private Salon salon;
    @ManyToOne
    private Docente docente;
    @ManyToOne
    private Materia materia;
    @ManyToOne
    private Semestre semestre;
    @ManyToOne
    private Facultad facultad;
    @ManyToOne
    private Paralelo paralelo;
    @ManyToOne
    private Horario horario;
    private int sesion;

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
     * Metodo para guardar un valor de tipo Long en la variable id
     *
     * @param id Long a guardar
     * @since 1.0.0
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el valor actual de la variable dia que es de tipo Dia
     *
     * @return retorna el valor de la variable dia
     * @since 1.0.0
     */
    public Dia getDia() {
        return dia;
    }

    /**
     * Metodo para guardar un valor de tipo Dia en la variable dia
     *
     * @param dia Dia a guardar
     * @since 1.0.0
     */
    public void setDia(Dia dia) {
        this.dia = dia;
    }

    /**
     * Metodo para obtener el valor actual de la variable hora que es de tipo
     * Hora
     *
     * @return retorna el valor de la variable hora
     * @since 1.0.0
     */
    public Hora getHora() {
        return hora;
    }

    /**
     * Metodo para guardar un valor de tipo Hora en la variable hora
     *
     * @param hora Hora a guardar
     * @since 1.0.0
     */
    public void setHora(Hora hora) {
        this.hora = hora;
    }

    /**
     * Metodo para obtener el valor actual de la variable salon que es de tipo
     * Salon
     *
     * @return retorna el valor de la variable salon
     * @since 1.0.0
     */
    public Salon getSalon() {
        return salon;
    }

    /**
     * Metodo para guardar un valor de tipo Salon en la variable salon
     *
     * @param salon Salon a guardar
     * @since 1.0.0
     */
    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    /**
     * Metodo para obtener el valor actual de la variable nombredocente que es
     * de tipo Docente
     *
     * @return retorna el valor de la variable docente
     * @since 1.0.0
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * Metodo para guardar un valor de tipo Docente en la variable docente
     *
     * @param docente Docente a guardar
     * @since 1.0.0
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Metodo para obtener el valor actual de la variable materia que es de tipo
     * Materia
     *
     * @return retorna el valor de la variable materia
     * @since 1.0.0
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Metodo para guardar un valor de tipo Materia en la variable materia
     *
     * @param materia Materia a guardar
     * @since 1.0.0
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
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
     * Metodo para obtener el valor actual de la variable paralelo que es de
     * tipo Paralelo
     *
     * @return retorna el valor de la variable paralelo
     * @since 1.0.0
     */
    public Paralelo getParalelo() {
        return paralelo;
    }

    /**
     * Metodo para guardar un valor de tipo Paralelo en la variable paralelo
     *
     * @param paralelo Paralelo a guardar
     * @since 1.0.0
     */
    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    /**
     * Metodo para obtener el valor actual de la variable horario que es de tipo
     * Horario
     *
     * @return retorna el valor de la variable horario
     * @since 1.0.0
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Metodo para guardar un valor de tipo Horario en la variable horario
     *
     * @param horario Horario a guardar
     * @since 1.0.0
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * Metodo para obtener el valor actual de la variable sesion que es de tipo
     * Sesion
     *
     * @return retorna el valor de la variable sesion
     * @since 1.0.0
     */
    public int getSesion() {
        return sesion;
    }

    /**
     * Metodo para guardar un valor de tipo Sesion en la variable sesion
     *
     * @param sesion sesion a guardar
     * @since 1.0.0
     */
    public void setSesion(int sesion) {
        this.sesion = sesion;
    }

}
