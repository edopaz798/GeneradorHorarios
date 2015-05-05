package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Long> id;
    public static volatile SingularAttribute<Horario, String> momentoInicial;
    public static volatile ListAttribute<Horario, DetalleHorario> detalleHorarios;
    public static volatile SingularAttribute<Horario, String> momentoFinal;

}