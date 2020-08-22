package org.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(ClasificacionSp.class)
public class ClasificacionSp_ { 

    public static volatile SingularAttribute<ClasificacionSp, String> descripcion;
    public static volatile SingularAttribute<ClasificacionSp, Integer> estado;
    public static volatile SingularAttribute<ClasificacionSp, Integer> idClasificacionSp;
    public static volatile ListAttribute<ClasificacionSp, Producto> productoList;
    public static volatile SingularAttribute<ClasificacionSp, String> nombre;

}