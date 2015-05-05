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
 * Clase que repesenta la entidad HorarioLaborable
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class HorarioLaborable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Dia dia;
    @ManyToOne
    private Hora hora;

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
     * Metodo para guardar un valor de tipo Long en la variable hora
     *
     * @param hora Hora a guardar
     * @since 1.0.0
     */
    public void setHora(Hora hora) {
        this.hora = hora;
    }

}
