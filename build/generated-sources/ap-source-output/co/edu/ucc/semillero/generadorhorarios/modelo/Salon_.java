package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.Bloque;
import co.edu.ucc.semillero.generadorhorarios.modelo.DetalleHorario;
import co.edu.ucc.semillero.generadorhorarios.modelo.SalonTipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-30T14:11:54")
@StaticMetamodel(Salon.class)
public class Salon_ { 

    public static volatile SingularAttribute<Salon, Long> id;
    public static volatile SingularAttribute<Salon, String> nombre;
    public static volatile SingularAttribute<Salon, SalonTipo> salonTipo;
    public static volatile ListAttribute<Salon, DetalleHorario> detalleHorarios;
    public static volatile SingularAttribute<Salon, Bloque> bloque;

}