package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.ProfesorProhibicion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(Docente.class)
public class Docente_ { 

    public static volatile SingularAttribute<Docente, Long> id;
    public static volatile SingularAttribute<Docente, String> nombre;
    public static volatile SingularAttribute<Docente, String> apellido;
    public static volatile ListAttribute<Docente, ProfesorProhibicion> profesorProhibicions;
    public static volatile ListAttribute<Docente, DetalleHorario> detalleHorarios;
    public static volatile SingularAttribute<Docente, Integer> cedula;

}