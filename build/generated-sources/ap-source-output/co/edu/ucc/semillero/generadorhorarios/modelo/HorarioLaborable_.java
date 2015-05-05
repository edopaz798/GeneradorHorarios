package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.Dia;
import co.edu.ucc.semillero.generadorhorarios.modelo.Hora;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(HorarioLaborable.class)
public class HorarioLaborable_ { 

    public static volatile SingularAttribute<HorarioLaborable, Long> id;
    public static volatile SingularAttribute<HorarioLaborable, Hora> hora;
    public static volatile SingularAttribute<HorarioLaborable, Dia> dia;

}