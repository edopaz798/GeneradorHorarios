package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.Paralelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(Semestre.class)
public class Semestre_ { 

    public static volatile SingularAttribute<Semestre, Long> id;
    public static volatile SingularAttribute<Semestre, String> nombre;
    public static volatile ListAttribute<Semestre, Paralelo> paralelos;
    public static volatile ListAttribute<Semestre, DetalleHorario> detalleHorarios;

}