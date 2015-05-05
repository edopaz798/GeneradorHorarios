/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Paralelo;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaParalelo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Paralelo
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbParalelo")
@ViewScoped
public class MbParalelo implements Serializable {

    @EJB
    private LogicaParalelo logica;
    private Paralelo paralelo;
    private List<Paralelo> lista;

    /**
     * Metodo que instancia la variable paralelo e inicializa la variable lista
     * con todas las ocurrencias que tenga la tabla Paralelo en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        paralelo = new Paralelo();
        lista = logica.consultarParalelos();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable paralelo
     * en la base de datos, genera un mensaje positivo o negativo dependiendo
     * del resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (logica.guardar(paralelo)) {
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
    public String accionEditar(Paralelo p) {
        this.paralelo = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Paralelo a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Paralelo p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable paralelo que es de
     * tipo Paralelo
     *
     * @return retorna el valor de la variable paralelo
     * @since 1.0.0
     */
    public Paralelo getParalelo() {
        return paralelo;
    }

    /**
     * Metodo para guardar un valor de tipo Paralelo en la variable paralelo
     *
     * @param paralelo Paralelo a guardar
     * @since 1.0.0
     */
    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Paralelo)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Paralelo> getLista() {
        return lista;
    }

}
