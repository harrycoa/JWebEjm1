package org.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Persona;
import org.hc.model.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> descripcion;
    public static volatile SingularAttribute<Cliente, Date> fechaIngreso;
    public static volatile SingularAttribute<Cliente, String> codigo;
    public static volatile SingularAttribute<Cliente, Integer> estado;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Double> creditoMin;
    public static volatile ListAttribute<Cliente, Venta> ventaList;
    public static volatile SingularAttribute<Cliente, Double> creditoMax;
    public static volatile SingularAttribute<Cliente, Persona> idPersona;

}