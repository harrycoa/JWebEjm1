package org.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Cliente;
import org.hc.model.DetalleVenta;
import org.hc.model.EjecucionServicio;
import org.hc.model.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> estado;
    public static volatile SingularAttribute<Venta, Cliente> idCliente;
    public static volatile SingularAttribute<Venta, Empleado> idEmpleado;
    public static volatile SingularAttribute<Venta, Date> fechaRegistro;
    public static volatile ListAttribute<Venta, DetalleVenta> detalleVentaList;
    public static volatile ListAttribute<Venta, EjecucionServicio> ejecucionServicioList;
    public static volatile SingularAttribute<Venta, Double> subTotal;
    public static volatile SingularAttribute<Venta, Double> porcImpuesto;
    public static volatile SingularAttribute<Venta, Double> montoImpuesto;
    public static volatile SingularAttribute<Venta, Double> montoTotal;
    public static volatile SingularAttribute<Venta, Integer> idVenta;

}