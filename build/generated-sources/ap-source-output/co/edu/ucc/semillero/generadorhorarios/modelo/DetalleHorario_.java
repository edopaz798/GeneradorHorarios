package co.edu.ucc.semillero.generadorhorarios.modelo;

import co.edu.ucc.semillero.generadorhorarios.modelo.Dia;
import co.edu.ucc.semillero.generadorhorarios.modelo.Docente;
import co.edu.ucc.semillero.generadorhorarios.modelo.Facultad;
import co.edu.ucc.semillero.generadorhorarios.modelo.Hora;
import co.edu.ucc.semillero.generadorhorarios.modelo.Horario;
import co.edu.ucc.semillero.generadorhorarios.modelo.Materia;
import co.edu.ucc.semillero.generadorhorarios.modelo.Paralelo;
import co.edu.ucc.semillero.generadorhorarios.modelo.Salon;
import co.edu.ucc.semillero.generadorhorarios.modelo.Semestre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-05T13:02:22")
@StaticMetamodel(DetalleHorario.class)
public class DetalleHorario_ { 

    public static volatile SingularAttribute<DetalleHorario, Long> id;
    public static volatile SingularAttribute<DetalleHorario, Hora> hora;
    public static volatile SingularAttribute<DetalleHorario, Salon> salon;
    public static volatile SingularAttribute<DetalleHorario, Horario> horario;
    public static volatile SingularAttribute<DetalleHorario, Materia> materia;
    public static volatile SingularAttribute<DetalleHorario, Paralelo> paralelo;
    public static volatile SingularAttribute<DetalleHorario, Semestre> semestre;
    public static volatile SingularAttribute<DetalleHorario, Facultad> facultad;
    public static volatile SingularAttribute<DetalleHorario, Integer> sesion;
    public static volatile SingularAttribute<DetalleHorario, Dia> dia;
    public static volatile SingularAttribute<DetalleHorario, Docente> docente;

}