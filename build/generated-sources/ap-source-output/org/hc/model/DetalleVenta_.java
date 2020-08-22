package org.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Producto;
import org.hc.model.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile SingularAttribute<DetalleVenta, Double> precio;
    public static volatile SingularAttribute<DetalleVenta, Integer> estado;
    public static volatile SingularAttribute<DetalleVenta, Double> peso;
    public static volatile SingularAttribute<DetalleVenta, Integer> idDetalleVenta;
    public static volatile SingularAttribute<DetalleVenta, Double> cantidad;
    public static volatile SingularAttribute<DetalleVenta, Producto> idProducto;
    public static volatile SingularAttribute<DetalleVenta, Venta> idVenta;

}