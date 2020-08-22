package org.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, String> descripcion;
    public static volatile SingularAttribute<Marca, Date> fechaEliminacion;
    public static volatile SingularAttribute<Marca, Integer> estado;
    public static volatile SingularAttribute<Marca, Date> fechaModificacion;
    public static volatile ListAttribute<Marca, Producto> productoList;
    public static volatile SingularAttribute<Marca, Date> fechaCreacion;
    public static volatile SingularAttribute<Marca, String> usuario;
    public static volatile SingularAttribute<Marca, Integer> idMarca;
    public static volatile SingularAttribute<Marca, String> nombre;

}