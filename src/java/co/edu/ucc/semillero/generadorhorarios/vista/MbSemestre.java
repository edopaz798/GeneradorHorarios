/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Semestre;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaSemestre;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Semestre
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbSemestre")
@ViewScoped
public class MbSemestre implements Serializable {

    @EJB
    private LogicaSemestre logica;
    private Semestre semestre;
    private List<Semestre> lista;

    /**
     * Metodo que instancia la variable semestre e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla Semestre en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        semestre = new Semestre();
        lista = logica.consultarSemestres();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable semestre
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(semestre)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Se ha registrado correctamente"));
            init();
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Error al guardar"));
        }
        return null;
    }

    /**
     * Metodo No Implementado
     *
     * @param p
     * @return
     * @since 1.0.0
     */
    public String accionEditar(Semestre p) {
        this.semestre = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Semestre a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Semestre p) {
        logica.eliminar(p);
        init();
        return null;
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
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Semestre)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Semestre> getLista() {
        return lista;
    }

}
