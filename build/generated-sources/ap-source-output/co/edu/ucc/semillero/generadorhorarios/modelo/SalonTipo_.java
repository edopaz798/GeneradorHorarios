package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.Salon;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(SalonTipo.class)
public class SalonTipo_ { 

    public static volatile SingularAttribute<SalonTipo, Long> id;
    public static volatile SingularAttribute<SalonTipo, String> nombre;
    public static volatile ListAttribute<SalonTipo, Salon> salons;

}