package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.Facultad;
import co.edu.ucc.semillero.generadorhorarios.modelo.Semestre;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-30T14:11:54")
@StaticMetamodel(Paralelo.class)
public class Paralelo_ { 

    public static volatile SingularAttribute<Paralelo, Long> id;
    public static volatile SingularAttribute<Paralelo, String> nombre;
    public static volatile SingularAttribute<Paralelo, Semestre> semestre;
    public static volatile SingularAttribute<Paralelo, Facultad> facultad;
    public static volatile ListAttribute<Paralelo, DetalleHorario> detalleHorarios;

}