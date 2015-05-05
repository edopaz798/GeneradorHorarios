package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.Dia;
import co.edu.ucc.semillero.generadorhorarios.modelo.Docente;
import co.edu.ucc.semillero.generadorhorarios.modelo.Hora;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(ProfesorProhibicion.class)
public class ProfesorProhibicion_ { 

    public static volatile SingularAttribute<ProfesorProhibicion, Long> id;
    public static volatile SingularAttribute<ProfesorProhibicion, Hora> hora;
    public static volatile SingularAttribute<ProfesorProhibicion, Dia> dia;
    public static volatile SingularAttribute<ProfesorProhibicion, Docente> docente;

}