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
 * Clase que repesenta la entidad Hora
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Hora implements Serializable {

    @OneToMany(mappedBy = "hora")
    private List<ProfesorProhibicion> profesorProhibicions;
    @OneToMany(mappedBy = "hora")
    private List<HorarioLaborable> horarioLaborables;
    @OneToMany(mappedBy = "hora")
    private List<DetalleHorario> detalleHorarios;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String intervalo;

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
     * Metodo para obtener el valor actual de la variable intervalo que es de
     * tipo String
     *
     * @return retorna el valor de la variable intervalo
     * @since 1.0.0
     */
    public String getIntervalo() {
        return intervalo;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable intervalo
     *
     * @param intervalo String a guardar
     * @since 1.0.0
     */
    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
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
     * Metodo para obtener el valor actual de la variable horarioLaborables que
     * es de tipo List(HorarioLaborable)
     *
     * @return retorna el valor de la variable horarioLaborables
     * @since 1.0.0
     */
    public List<HorarioLaborable> getHorarioLaborables() {
        return horarioLaborables;
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
