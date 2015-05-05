/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Horario;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaHorario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Horario
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbHorario")
@ViewScoped
public class MbHorario implements Serializable {

    @EJB
    private LogicaHorario logica;
    private Horario horario;
    private List<Horario> lista;

    /**
     * Metodo que instancia la variable horario e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla Horario en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        horario = new Horario();
        lista = logica.consultarHorarios();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable horario
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(horario)) {
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
    public String accionEditar(Horario p) {
        this.horario = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Horario a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Horario p) {
        logica.eliminar(p);
        init();
        return null;
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
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Horario)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Horario> getLista() {
        return lista;
    }

}
