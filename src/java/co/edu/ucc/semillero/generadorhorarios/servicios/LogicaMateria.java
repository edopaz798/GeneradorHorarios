/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.semillero.generadorhorarios.servicios;

import co.edu.ucc.semillero.generadorhorarios.modelo.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que repesenta la parte logica de la entidad Materia
 *
 * @author Eduardo
 * @version 1.0.0
 * @since 1.0.0
 */
@Stateless
public class LogicaMateria {

    @PersistenceContext(unitName = "GeneradorHorariosPU")
    private EntityManager em;

    /**
     * Metodo que guardar el objeto c de tipo Materia en la base de datos
     *
     * @param c Materia a guardar
     * @return falso o verdadero, dependiendo de si se guarda satisfactoriamente
     * la informacion o no
     */
    public boolean guardar(Materia c) {
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
     * Metodo que consulta y devuelve un objeto List(Materia) con todas las
     * indidencias dentro de la tabla Materia
     *
     * @return Lista(Materia) con todas las incidencias encontradas
     */
    public List<Materia> consultarMaterias() {
        return em.createQuery("Select c from Materia c").getResultList();
    }

    /**
     * Metedo que compara la variable de tipo Materia c con todas las
     * incidencias de la table Materia dentro de la base de datos y la elimina
     * de encontrarla
     *
     * @param c Materia a eliminar
     * @return falso o verdadero, dependiendo de si encuentra el objeto a
     * eliminar o no
     */
    public boolean eliminar(Materia c) {
        try {
            c = (Materia) em.
                    createQuery("Select c from Materia c where c.id=:i")
                    .setParameter("i", c.getId()).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
