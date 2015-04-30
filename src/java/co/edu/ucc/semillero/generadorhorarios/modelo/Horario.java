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
 * Clase que repesenta la entidad Horario
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Horario implements Serializable {

    @OneToMany(mappedBy = "horario")
    private List<DetalleHorario> detalleHorarios;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String momentoInicial;
    private String momentoFinal;

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
     * Metodo para obtener el valor actual de la variable momentoInicial que es
     * de tipo String
     *
     * @return retorna el valor de la variable momentoInicial
     * @since 1.0.0
     */
    public String getMomentoInicial() {
        return momentoInicial;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable momentoInicial
     *
     * @param momentoInicial String a guardar
     * @since 1.0.0
     */
    public void setMomentoInicial(String momentoInicial) {
        this.momentoInicial = momentoInicial;
    }

    /**
     * Metodo para obtener el valor actual de la variable momentoFinal que es de
     * tipo String
     *
     * @return retorna el valor de la variable momentoFinal
     * @since 1.0.0
     */
    public String getMomentoFinal() {
        return momentoFinal;
    }

    /**
     * Metodo para guardar un valor de tipo String en la variable momentoFinal
     *
     * @param momentoFinal String a guardar
     * @since 1.0.0
     */
    public void setMomentoFinal(String momentoFinal) {
        this.momentoFinal = momentoFinal;
    }

}
