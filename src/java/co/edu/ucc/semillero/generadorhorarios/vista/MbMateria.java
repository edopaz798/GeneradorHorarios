/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Materia;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaMateria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Materia
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbMateria")
@ViewScoped
public class MbMateria implements Serializable {

    @EJB
    private LogicaMateria logica;
    private Materia materia;
    private List<Materia> lista;

    /**
     * Metodo que instancia la variable materia e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla Materia en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        materia = new Materia();
        lista = logica.consultarMaterias();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable materia
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(materia)) {
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
    public String accionEditar(Materia p) {
        this.materia = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Materia a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Materia p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable materia que es de tipo
     * Materia
     *
     * @return retorna el valor de la variable materia
     * @since 1.0.0
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Metodo para guardar un valor de tipo Materia en la variable materia
     *
     * @param materia Materia a guardar
     * @since 1.0.0
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Materia)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Materia> getLista() {
        return lista;
    }

}
