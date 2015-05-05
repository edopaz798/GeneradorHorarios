package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.HorarioLaborable;
import co.edu.ucc.semillero.generadorhorarios.modelo.ProfesorProhibicion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(Hora.class)
public class Hora_ { 

    public static volatile SingularAttribute<Hora, Long> id;
    public static volatile SingularAttribute<Hora, String> nombre;
    public static volatile ListAttribute<Hora, HorarioLaborable> horarioLaborables;
    public static volatile ListAttribute<Hora, ProfesorProhibicion> profesorProhibicions;
    public static volatile ListAttribute<Hora, DetalleHorario> detalleHorarios;
    public static volatile SingularAttribute<Hora, String> intervalo;

}