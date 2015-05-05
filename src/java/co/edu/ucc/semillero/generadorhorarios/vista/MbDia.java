/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.vista;

import co.edu.ucc.semillero.generadorhorarios.modelo.Dia;
import co.edu.ucc.semillero.generadorhorarios.servicios.LogicaDia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Clase que repesenta el Managed Bean de la entidad Dia
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@ManagedBean(name = "mbDia")
@ViewScoped
public class MbDia implements Serializable {

    @EJB
    private LogicaDia logica;
    private Dia dia;
    private List<Dia> lista;

    /**
     * Metodo que instancia la variable dia e inicializa la variable lista con
     * todas las ocurrencias que tenga la tabla Dia en la base de datos
     *
     * @since 1.0.0
     */
    @PostConstruct
    public void init() {
        dia = new Dia();
        lista = logica.consultarDias();
    }

    /**
     * Metodo que ejecuta la accion de guardar el valor de la variable dia en la
     * base de datos, genera un mensaje positivo o negativo dependiendo del
     * resultado de esta accion
     *
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionGuardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("3: "+dia.getNombre());
        if (logica.guardar(dia)) {
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
    public String accionEditar(Dia p) {
        this.dia = p;
        return null;
    }

    /**
     * Metodo que elimina una incidencia en la base de datos
     *
     * @param p Dia a eliminar
     * @return null para todos los casos
     * @since 1.0.0
     */
    public String accionEliminar(Dia p) {
        logica.eliminar(p);
        init();
        return null;
    }

    /**
     * Metodo para obtener el valor actual de la variable dia que es de tipo Dia
     *
     * @return retorna el valor de la variable dia
     * @since 1.0.0
     */
    public Dia getDia() {
        return dia;
    }

    /**
     * Metodo para guardar un valor de tipo Dia en la variable dia
     *
     * @param dia Dia a guardar
     * @since 1.0.0
     */
    public void setDia(Dia dia) {
        this.dia = dia;
    }

    /**
     * Metodo para obtener el valor actual de la variable lista que es de tipo
     * List(Dia)
     *
     * @return retorna el valor de la variable lista
     * @since 1.0.0
     */
    public List<Dia> getLista() {
        return lista;
    }

}
