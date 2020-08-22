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
@Table(name = "clasificacion_sp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasificacionSp.findAll", query = "SELECT c FROM ClasificacionSp c"),
    @NamedQuery(name = "ClasificacionSp.findByIdClasificacionSp", query = "SELECT c FROM ClasificacionSp c WHERE c.idClasificacionSp = :idClasificacionSp"),
    @NamedQuery(name = "ClasificacionSp.findByEstado", query = "SELECT c FROM ClasificacionSp c WHERE c.estado = :estado")})
public class ClasificacionSp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clasificacion_sp")
    private Integer idClasificacionSp;
    @Lob
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasificacionSp")
    private List<Producto> productoList;

    public ClasificacionSp() {
    }

    public ClasificacionSp(Integer idClasificacionSp) {
        this.idClasificacionSp = idClasificacionSp;
    }

    public Integer getIdClasificacionSp() {
        return idClasificacionSp;
    }

    public void setIdClasificacionSp(Integer idClasificacionSp) {
        this.idClasificacionSp = idClasificacionSp;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasificacionSp != null ? idClasificacionSp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasificacionSp)) {
            return false;
        }
        ClasificacionSp other = (ClasificacionSp) object;
        if ((this.idClasificacionSp == null && other.idClasificacionSp != null) || (this.idClasificacionSp != null && !this.idClasificacionSp.equals(other.idClasificacionSp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hc.model.ClasificacionSp[ idClasificacionSp=" + idClasificacionSp + " ]";
    }
    
}
