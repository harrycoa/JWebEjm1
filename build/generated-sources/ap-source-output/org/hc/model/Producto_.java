package org.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Categoria;
import org.hc.model.ClasificacionSp;
import org.hc.model.DetalleVenta;
import org.hc.model.Marca;
import org.hc.model.TipoProducto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, ClasificacionSp> idClasificacionSp;
    public static volatile SingularAttribute<Producto, String> color;
    public static volatile SingularAttribute<Producto, Double> peso;
    public static volatile ListAttribute<Producto, DetalleVenta> detalleVentaList;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;
    public static volatile SingularAttribute<Producto, Marca> idMarca;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, TipoProducto> idTipoProducto;

}