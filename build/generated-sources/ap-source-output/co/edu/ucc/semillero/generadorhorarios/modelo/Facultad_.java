package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.Paralelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-30T14:11:54")
@StaticMetamodel(Facultad.class)
public class Facultad_ { 

    public static volatile SingularAttribute<Facultad, Long> id;
    public static volatile SingularAttribute<Facultad, String> nombre;
    public static volatile ListAttribute<Facultad, Paralelo> paralelos;
    public static volatile ListAttribute<Facultad, DetalleHorario> detalleHorarios;

}