/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.ProfesorProhibicion;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaProfesorProhibicion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad ProfesorProhibicion
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbProfesorProhibicion")
@ViewScoped
public class MbProfesorProhibicion implements Serializable {

    @EJB
    private LogicaProfesorProhibicion logica;
    private ProfesorProhibicion profesorProhibicion;
    private List<ProfesorProhibicion> lista;

    /**
     * Metodo que instancia la variable profesorProhibicion e inicializa la
     * variable lista con todas las ocurrencias que tenga la tabla
     * ProfesorProhibicion en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        profesorProhibicion = new ProfesorProhibicion();
        lista = logica.consultarProfesorProhibicions();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable
     * profesorProhibicion en la base de datos, genera un mensaje positivo o
     * negativo dependiendo del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(profesorProhibicion)) {
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
    public String accionEditar(ProfesorProhibicion p) {
        this.profesorProhibicion = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p ProfesorProhibicion a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(ProfesorProhibicion p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable profesorProhibicion
     * que es de tipo ProfesorProhibicion
     *
     * @return retorna el valor de la variable profesorProhibicion
     * @since 1.0.0
     */
    public ProfesorProhibicion getProfesorProhibicion() {
        return profesorProhibicion;
    }

    /**
     * Metodo para guardar un valor de tipo ProfesorProhibicion en la variable
     * profesorProhibicion
     *
     * @param profesorProhibicion ProfesorProhibicion a guardar
     * @since 1.0.0
     */
    public void setProfesorProhibicion(ProfesorProhibicion profesorProhibicion) {
        this.profesorProhibicion = profesorProhibicion;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(ProfesorProhibicion)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<ProfesorProhibicion> getLista() {
        return lista;
    }

}
