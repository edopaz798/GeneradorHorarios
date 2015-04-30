/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaDetalleHorario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad DetalleHorario
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbDetalleHorario")
@ViewScoped
public class MbDetalleHorario implements Serializable {

    @EJB
    private LogicaDetalleHorario logica;
    private DetalleHorario detalleHorario;
    private List<DetalleHorario> lista;

    /**
     * Metodo que instancia la variable detalleHorario e inicializa la variable
     * lista con todas las ocurrencias que tenga la tabla DetalleHorario en la
     * base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        detalleHorario = new DetalleHorario();
        lista = logica.consultarDetalleHorarios();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable
     * detalleHorario en la base de datos, genera un mensaje positivo o negativo
     * dependiendo del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(detalleHorario)) {
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
    public String accionEditar(DetalleHorario p) {
        this.detalleHorario = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p DetalleHorario a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(DetalleHorario p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable detalleHorario que es
     * de tipo DetalleHorario
     *
     * @return retorna el valor de la variable detalleHorario
     * @since 1.0.0
     */
    public DetalleHorario getDetalleHorario() {
        return detalleHorario;
    }

    /**
     * Metodo para guardar un valor de tipo DetalleHorario en la variable
     * detalleHorario
     *
     * @param detalleHorario DetalleHorario a guardar
     * @since 1.0.0
     */
    public void setDetalleHorario(DetalleHorario detalleHorario) {
        this.detalleHorario = detalleHorario;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(DetalleHorario)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<DetalleHorario> getLista() {
        return lista;
    }

}
