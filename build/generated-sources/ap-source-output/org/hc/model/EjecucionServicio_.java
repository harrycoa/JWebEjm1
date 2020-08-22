package org.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Empleado;
import org.hc.model.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(EjecucionServicio.class)
public class EjecucionServicio_ { 

    public static volatile SingularAttribute<EjecucionServicio, Integer> estado;
    public static volatile SingularAttribute<EjecucionServicio, Date> horaIngreso;
    public static volatile SingularAttribute<EjecucionServicio, Empleado> idEmpleado;
    public static volatile SingularAttribute<EjecucionServicio, Integer> idEjecucionServicio;
    public static volatile SingularAttribute<EjecucionServicio, Date> fechaEjecucion;
    public static volatile SingularAttribute<EjecucionServicio, Date> horaSalida;
    public static volatile SingularAttribute<EjecucionServicio, Venta> idVenta;

}