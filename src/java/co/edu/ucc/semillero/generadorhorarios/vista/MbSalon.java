/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Salon;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaSalon;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Salon
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbSalon")
@ViewScoped
public class MbSalon implements Serializable {

    @EJB
    private LogicaSalon logica;
    private Salon salon;
    private List<Salon> lista;
    private int salonId;

    /**
     * Metodo que instancia la variable salon e inicializa la variable lista con
     * todas las ocurrencias que tenga la tabla Salon en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        salon = new Salon();
        lista = logica.consultarSalons();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable salon en
     * la base de datos, genera un mensaje positivo o negativo dependiendo del
     * resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(salon)) {
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
    public String accionEditar(Salon p) {
        this.salon = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Salon a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Salon p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable salon que es de tipo
     * Salon
     *
     * @return retorna el valor de la variable salon
     * @since 1.0.0
     */
    public String agregarSalon() {

        return null;
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
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Salon)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Salon> getLista() {
        return lista;
    }

}
