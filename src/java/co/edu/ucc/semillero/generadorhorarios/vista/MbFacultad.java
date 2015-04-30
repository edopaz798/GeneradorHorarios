/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Facultad;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaFacultad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Facultad
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbFacultad")
@ViewScoped
public class MbFacultad implements Serializable {

    @EJB
    private LogicaFacultad logica;
    private Facultad facultad;
    private List<Facultad> lista;

    /**
     * Metodo que instancia la variable facultad e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla Facultad en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        facultad = new Facultad();
        lista = logica.consultarFacultads();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable facultad
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(facultad)) {
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
    public String accionEditar(Facultad p) {
        this.facultad = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Facultad a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Facultad p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable facultad que es de
     * tipo Facultad
     *
     * @return retorna el valor de la variable facultad
     * @since 1.0.0
     */
    public Facultad getFacultad() {
        return facultad;
    }

    /**
     * Metodo para guardar un valor de tipo Facultad en la variable facultad
     *
     * @param facultad Facultad a guardar
     * @since 1.0.0
     */
    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Facultad)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Facultad> getLista() {
        return lista;
    }

}
