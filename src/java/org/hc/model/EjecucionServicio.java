/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodol
 */
@Entity
@Table(name = "ejecucion_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EjecucionServicio.findAll", query = "SELECT e FROM EjecucionServicio e"),
    @NamedQuery(name = "EjecucionServicio.findByIdEjecucionServicio", query = "SELECT e FROM EjecucionServicio e WHERE e.idEjecucionServicio = :idEjecucionServicio"),
    @NamedQuery(name = "EjecucionServicio.findByFechaEjecucion", query = "SELECT e FROM EjecucionServicio e WHERE e.fechaEjecucion = :fechaEjecucion"),
    @NamedQuery(name = "EjecucionServicio.findByHoraIngreso", query = "SELECT e FROM EjecucionServicio e WHERE e.horaIngreso = :horaIngreso"),
    @NamedQuery(name = "EjecucionServicio.findByHoraSalida", query = "SELECT e FROM EjecucionServicio e WHERE e.horaSalida = :horaSalida"),
    @NamedQuery(name = "EjecucionServicio.findByEstado", query = "SELECT e FROM EjecucionServicio e WHERE e.estado = :estado")})
public class EjecucionServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ejecucion_servicio")
    private Integer idEjecucionServicio;
    @Column(name = "fecha_ejecucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEjecucion;
    @Column(name = "hora_ingreso")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public EjecucionServicio() {
    }

    public EjecucionServicio(Integer idEjecucionServicio) {
        this.idEjecucionServicio = idEjecucionServicio;
    }

    public Integer getIdEjecucionServicio() {
        return idEjecucionServicio;
    }

    public void setIdEjecucionServicio(Integer idEjecucionServicio) {
        this.idEjecucionServicio = idEjecucionServicio;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjecucionServicio != null ? idEjecucionServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EjecucionServicio)) {
            return false;
        }
        EjecucionServicio other = (EjecucionServicio) object;
        if ((this.idEjecucionServicio == null && other.idEjecucionServicio != null) || (this.idEjecucionServicio != null && !this.idEjecucionServicio.equals(other.idEjecucionServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hc.model.EjecucionServicio[ idEjecucionServicio=" + idEjecucionServicio + " ]";
    }
    
}
