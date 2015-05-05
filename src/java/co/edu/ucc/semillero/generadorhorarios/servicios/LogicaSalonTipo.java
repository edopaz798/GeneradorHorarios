/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.SalonTipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que repesenta la parte logica de la entidad SalonTipo
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Stateless
public class LogicaSalonTipo {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     * Metodo que guardar el objeto c de tipo SalonTipo en la base de datos
     *
     * @param c SalonTipo a guardar
     * @return falso o verdadero, dependiendo de si se guarda satisfactoriamente
     * la informacion o no
     */
    public boolean guardar(SalonTipo c) {
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
     * Metodo que consulta y devuelve un objeto List(SalonTipo) con todas las
     * indidencias dentro de la tabla SalonTipo
     *
     * @return Lista(SalonTipo) con todas las incidencias encontradas
     */
    public List<SalonTipo> consultarSalonTipos() {
        return em.createQuery("Select c from SalonTipo c").getResultList();
    }

    /**
     * Metedo que compara la variable de tipo SalonTipo c con todas las
     * incidencias de la table SalonTipo dentro de la base de datos y la elimina
     * de encontrarla
     *
     * @param c SalonTipo a eliminar
     * @return falso o verdadero, dependiendo de si encuentra el objeto a
     * eliminar o no
     */
    public boolean eliminar(SalonTipo c) {
        try {
            c = (SalonTipo) em.
                    createQuery("Select c from SalonTipo c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
