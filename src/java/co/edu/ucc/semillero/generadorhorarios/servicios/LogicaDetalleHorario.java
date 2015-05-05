/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que repesenta la parte logica de la entidad DetalleHorario
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Stateless
public class LogicaDetalleHorario {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     * Metodo que guardar el objeto c de tipo DetalleHorario en la base de datos
     *
     * @param c DetalleHorario a guardar
     * @return falso o verdadero, dependiendo de si se guarda satisfactoriamente
     * la informacion o no
     */
    public boolean guardar(DetalleHorario c) {
        try {
            if (c.getId() == null) {
                em.persist(c);
            } else {
                em.merge(c);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que consulta y devuelve un objeto List(DetalleHorario) con todas
     * las indidencias dentro de la tabla DetalleHorario
     *
     * @return Lista(DetalleHorario) con todas las incidencias encontradas
     */
    public List<DetalleHorario> consultarDetalleHorarios() {
        return em.createQuery("Select c from DetalleHorario c").getResultList();
    }

    /**
     * Metedo que compara la variable de tipo DetalleHorario c con todas las
     * incidencias de la table DetalleHorario dentro de la base de datos y la
     * elimina de encontrarla
     *
     * @param c DetalleHorario a eliminar
     * @return falso o verdadero, dependiendo de si encuentra el objeto a
     * eliminar o no
     */
    public boolean eliminar(DetalleHorario c) {
        try {
            c = (DetalleHorario) em.
                    createQuery("Select c from DetalleHorario c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
