/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.ProfesorProhibicion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que repesenta la parte logica de la entidad ProfesorProhibicion
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Stateless
public class LogicaProfesorProhibicion {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     * Metodo que guardar el objeto c de tipo ProfesorProhibicion en la base de
     * datos
     *
     * @param c ProfesorProhibicion a guardar
     * @return falso o verdadero, dependiendo de si se guarda satisfactoriamente
     * la informacion o no
     */
    public boolean guardar(ProfesorProhibicion c) {
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
     * Metodo que consulta y devuelve un objeto List(ProfesorProhibicion) con
     * todas las indidencias dentro de la tabla ProfesorProhibicion
     *
     * @return Lista(ProfesorProhibicion) con todas las incidencias encontradas
     */
    public List<ProfesorProhibicion> consultarProfesorProhibicions() {
        return em.createQuery("Select c from ProfesorProhibicion c").getResultList();
    }

    /**
     * Metedo que compara la variable de tipo ProfesorProhibicion c con todas
     * las incidencias de la table ProfesorProhibicion dentro de la base de
     * datos y la elimina de encontrarla
     *
     * @param c ProfesorProhibicion a eliminar
     * @return falso o verdadero, dependiendo de si encuentra el objeto a
     * eliminar o no
     */
    public boolean eliminar(ProfesorProhibicion c) {
        try {
            c = (ProfesorProhibicion) em.
                    createQuery("Select c from ProfesorProhibicion c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
