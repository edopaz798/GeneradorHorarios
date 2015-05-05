/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.HorarioLaborable;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaHorarioLaborable;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad HorarioLaborable
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbHorarioLaborable")
@ViewScoped
public class MbHorarioLaborable implements Serializable {

    @EJB
    private LogicaHorarioLaborable logica;
    private HorarioLaborable horarioLaborable;
    private List<HorarioLaborable> lista;

    /**
     * Metodo que instancia la variable horarioLaborable e inicializa la
     * variable lista con todas las ocurrencias que tenga la tabla
     * HorarioLaborable en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        horarioLaborable = new HorarioLaborable();
        lista = logica.consultarHorarioLaborables();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable
     * horarioLaborable en la base de datos, genera un mensaje positivo o
     * negativo dependiendo del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(horarioLaborable)) {
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
    public String accionEditar(HorarioLaborable p) {
        this.horarioLaborable = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p HorarioLaborable a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(HorarioLaborable p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable horarioLaborable que
     * es de tipo HorarioLaborable
     *
     * @return retorna el valor de la variable horarioLaborable
     * @since 1.0.0
     */
    public HorarioLaborable getHorarioLaborable() {
        return horarioLaborable;
    }

    /**
     * Metodo para guardar un valor de tipo HorarioLaborable en la variable
     * horarioLaborable
     *
     * @param horarioLaborable HorarioLaborable a guardar
     * @since 1.0.0
     */
    public void setHorarioLaborable(HorarioLaborable horarioLaborable) {
        this.horarioLaborable = horarioLaborable;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(HorarioLaborable)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<HorarioLaborable> getLista() {
        return lista;
    }

}
