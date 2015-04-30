/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.Bloque;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que repesenta la parte logica de la entidad Bloque
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@Stateless
public class LogicaBloque {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     * Metodo que guardar el objeto c de tipo Bloque en la base de datos
     *
     * @param c Bloque a guardar
     * @return falso o verdadero, dependiendo de si se guarda satisfactoriamente
     * la informacion o no
     */
    public boolean guardar(Bloque c) {
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
     * Metodo que consulta y devuelve un objeto List(Bloque) con todas las
     * indidencias dentro de la tabla Bloque
     *
     * @return Lista(Bloque) con todas las incidencias encontradas
     */
    public List<Bloque> consultarBloques() {
        return em.createQuery("Select c from Bloque c").getResultList();
    }

    /**
     * Metedo que compara la variable de tipo Bloque c con todas las incidencias
     * de la table Bloque dentro de la base de datos y la elimina de encontrarla
     *
     * @param c Bloque a eliminar
     * @return falso o verdadero, dependiendo de si encuentra el objeto a
     * eliminar o no
     */
    public boolean eliminar(Bloque c) {
        try {
            c = (Bloque) em.
                    createQuery("Select c from Bloque c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
