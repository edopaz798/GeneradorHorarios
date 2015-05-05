/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Docente;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaDocente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Docente
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbDocente")
@ViewScoped
public class MbDocente implements Serializable {

    @EJB
    private LogicaDocente logica;
    private Docente docente;
    private List<Docente> lista;

    /**
     * Metodo que instancia la variable docente e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla Docente en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        docente = new Docente();
        lista = logica.consultarDocentes();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable docente
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(docente)) {
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
    public String accionEditar(Docente p) {
        this.docente = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Docente a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Docente p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable docente que es de tipo
     * Docente
     *
     * @return retorna el valor de la variable docente
     * @since 1.0.0
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * Metodo para guardar un valor de tipo Docente en la variable docente
     *
     * @param docente Docente a guardar
     * @since 1.0.0
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Docente)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Docente> getLista() {
        return lista;
    }

}
