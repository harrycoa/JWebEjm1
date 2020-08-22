/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rodol
 */
@Entity
@Table(name = "tipo_documento_ide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentoIde.findAll", query = "SELECT t FROM TipoDocumentoIde t"),
    @NamedQuery(name = "TipoDocumentoIde.findByIdTipoDocumentoIde", query = "SELECT t FROM TipoDocumentoIde t WHERE t.idTipoDocumentoIde = :idTipoDocumentoIde"),
    @NamedQuery(name = "TipoDocumentoIde.findByAbrev", query = "SELECT t FROM TipoDocumentoIde t WHERE t.abrev = :abrev"),
    @NamedQuery(name = "TipoDocumentoIde.findByEstado", query = "SELECT t FROM TipoDocumentoIde t WHERE t.estado = :estado")})
public class TipoDocumentoIde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_documento_ide")
    private Integer idTipoDocumentoIde;
    @Lob
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocumentoIde")
    private List<Persona> personaList;

    public TipoDocumentoIde() {
    }

    public TipoDocumentoIde(Integer idTipoDocumentoIde) {
        this.idTipoDocumentoIde = idTipoDocumentoIde;
    }

    public Integer getIdTipoDocumentoIde() {
        return idTipoDocumentoIde;
    }

    public void setIdTipoDocumentoIde(Integer idTipoDocumentoIde) {
        this.idTipoDocumentoIde = idTipoDocumentoIde;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocumentoIde != null ? idTipoDocumentoIde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentoIde)) {
            return false;
        }
        TipoDocumentoIde other = (TipoDocumentoIde) object;
        if ((this.idTipoDocumentoIde == null && other.idTipoDocumentoIde != null) || (this.idTipoDocumentoIde != null && !this.idTipoDocumentoIde.equals(other.idTipoDocumentoIde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hc.model.TipoDocumentoIde[ idTipoDocumentoIde=" + idTipoDocumentoIde + " ]";
    }
    
}
