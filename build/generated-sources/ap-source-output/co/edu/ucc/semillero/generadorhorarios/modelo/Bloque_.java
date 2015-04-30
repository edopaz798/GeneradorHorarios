package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.Salon;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-30T14:11:54")
@StaticMetamodel(Bloque.class)
public class Bloque_ { 

    public static volatile SingularAttribute<Bloque, Long> id;
    public static volatile SingularAttribute<Bloque, String> nombre;
    public static volatile ListAttribute<Bloque, Salon> salons;

}