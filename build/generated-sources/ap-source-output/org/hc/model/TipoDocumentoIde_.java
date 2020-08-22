package org.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hc.model.Persona;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-16T13:40:18")
@StaticMetamodel(TipoDocumentoIde.class)
public class TipoDocumentoIde_ { 

    public static volatile SingularAttribute<TipoDocumentoIde, String> descripcion;
    public static volatile SingularAttribute<TipoDocumentoIde, Integer> estado;
    public static volatile ListAttribute<TipoDocumentoIde, Persona> personaList;
    public static volatile SingularAttribute<TipoDocumentoIde, String> abrev;
    public static volatile SingularAttribute<TipoDocumentoIde, String> nombre;
    public static volatile SingularAttribute<TipoDocumentoIde, Integer> idTipoDocumentoIde;

}