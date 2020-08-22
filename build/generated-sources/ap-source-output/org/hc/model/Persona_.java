package org.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Cliente;
import org.hc.model.Empleado;
import org.hc.model.TipoDocumentoIde;
import org.hc.model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidoPaterno;
    public static volatile ListAttribute<Persona, Usuario> usuarioList;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> ubigeo;
    public static volatile SingularAttribute<Persona, TipoDocumentoIde> idTipoDocumentoIde;
    public static volatile SingularAttribute<Persona, String> nombres;
    public static volatile SingularAttribute<Persona, String> apellidoMaterno;
    public static volatile ListAttribute<Persona, Cliente> clienteList;
    public static volatile SingularAttribute<Persona, Empleado> empleado;
    public static volatile SingularAttribute<Persona, String> correo;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> nroDocumento;
    public static volatile SingularAttribute<Persona, Integer> idPersona;

}