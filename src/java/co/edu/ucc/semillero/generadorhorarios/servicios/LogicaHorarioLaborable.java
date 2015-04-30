/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.HorarioLaborable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eduardo
 */
@Stateless
public class LogicaHorarioLaborable {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     *
     * @param c
     * @return
     */
    public boolean guardar(HorarioLaborable c) {
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
     *
     * @return
     */
    public List<HorarioLaborable> consultarHorarioLaborables() {
        return em.createQuery("Select c from HorarioLaborable c").getResultList();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean eliminar(HorarioLaborable c) {
        try {
            c = (HorarioLaborable) em.
                    createQuery("Select c from HorarioLaborable c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}