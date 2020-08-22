package org.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.EjecucionServicio;
import org.hc.model.Persona;
import org.hc.model.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Date> fechaIngreso;
    public static volatile SingularAttribute<Empleado, String> codigo;
    public static volatile SingularAttribute<Empleado, Integer> estado;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile ListAttribute<Empleado, Venta> ventaList;
    public static volatile ListAttribute<Empleado, EjecucionServicio> ejecucionServicioList;
    public static volatile SingularAttribute<Empleado, Date> fechaFin;
    public static volatile SingularAttribute<Empleado, Persona> idPersona;

}