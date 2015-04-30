/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Hora;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaHora;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Hora
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbHora")
@ViewScoped
public class MbHora implements Serializable {

    @EJB
    private LogicaHora logica;
    private Hora hora;
    private List<Hora> lista;

    /**
     * Metodo que instancia la variable hora e inicializa la variable lista con
     * todas las ocurrencias que tenga la tabla Hora en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        hora = new Hora();
        lista = logica.consultarHoras();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable hora en
     * la base de datos, genera un mensaje positivo o negativo dependiendo del
     * resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(hora)) {
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
    public String accionEditar(Hora p) {
        this.hora = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Hora a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Hora p) {
        logica.eliminar(p);
        init();
        return null;
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
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Hora)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Hora> getLista() {
        return lista;
    }

}
