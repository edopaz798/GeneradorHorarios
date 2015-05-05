/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.Hora;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que repesenta la parte logica de la entidad Hora
 *
 * @author Eduardo Paz
 * @version 1.0.0
 * @since 1.0.0
 */
@Stateless
public class LogicaHora {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     * Metodo que guardar el objeto c de tipo Hora en la base de datos
     *
     * @param c Hora a guardar
     * @return falso o verdadero, dependiendo de si se guarda satisfactoriamente
     * la informacion o no
     */
    public boolean guardar(Hora c) {
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
     * Metodo que consulta y devuelve un objeto List(Hora) con todas las
     * indidencias dentro de la tabla Hora
     *
     * @return Lista(Hora) con todas las incidencias encontradas
     */
    public List<Hora> consultarHoras() {
        return em.createQuery("Select c from Hora c").getResultList();
    }

    /**
     * Metedo que compara la variable de tipo Hora c con todas las incidencias
     * de la table Hora dentro de la base de datos y la elimina de encontrarla
     *
     * @param c Hora a eliminar
     * @return falso o verdadero, dependiendo de si encuentra el objeto a
     * eliminar o no
     */
    public boolean eliminar(Hora c) {
        try {
            c = (Hora) em.
                    createQuery("Select c from Hora c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
