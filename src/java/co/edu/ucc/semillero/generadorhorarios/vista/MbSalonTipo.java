/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.SalonTipo;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaSalonTipo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad SalonTipo
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbSalonTipo")
@ViewScoped
public class MbSalonTipo implements Serializable {

    @EJB
    private LogicaSalonTipo logica;
    private SalonTipo salonTipo;
    private List<SalonTipo> lista;

    /**
     * Metodo que instancia la variable salonTipo e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla SalonTipo en la base de
     * datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        salonTipo = new SalonTipo();
        lista = logica.consultarSalonTipos();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable salonTipo
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(salonTipo)) {
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
    public String accionEditar(SalonTipo p) {
        this.salonTipo = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p SalonTipo a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(SalonTipo p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable salonTipo que es de
     * tipo SalonTipo
     *
     * @return retorna el valor de la variable salonTipo
     * @since 1.0.0
     */
    public SalonTipo getSalonTipo() {
        return salonTipo;
    }

    /**
     * Metodo para guardar un valor de tipo SalonTipo en la variable salonTipo
     *
     * @param salonTipo SalonTipo a guardar
     * @since 1.0.0
     */
    public void setSalonTipo(SalonTipo salonTipo) {
        this.salonTipo = salonTipo;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(SalonTipo)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<SalonTipo> getLista() {
        return lista;
    }

}
