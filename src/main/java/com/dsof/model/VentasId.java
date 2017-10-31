package com.dsof.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
public class VentasId implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idVentas;
    @Id
    @NotNull
    private String nombreLibro;
    @Id
    @NotNull
    private String precioLibro;
    @Id
    @NotNull
    private String nombreCliente;
    @Id
    @NotNull
    private Date fechaCompra;

    public VentasId() {
    }

    public Integer getIdVentas() {
        return this.idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public String getNombreLibro() {
        return this.nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getPrecioLibro() {
        return this.precioLibro;
    }

    public void setPrecioLibro(String precioLibro) {
        this.precioLibro = precioLibro;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaCompra() {
        return this.fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }

        if ((other == null)) {
            return false;
        }

        if (!(other instanceof VentasId)) {
            return false;
        }

        VentasId castOther = (VentasId) other;

        return ((this.getIdVentas() == castOther.getIdVentas()) ||
        ((this.getIdVentas() != null) && (castOther.getIdVentas() != null) &&
        this.getIdVentas().equals(castOther.getIdVentas()))) &&
        ((this.getNombreLibro() == castOther.getNombreLibro()) ||
        ((this.getNombreLibro() != null) &&
        (castOther.getNombreLibro() != null) &&
        this.getNombreLibro().equals(castOther.getNombreLibro()))) &&
        ((this.getPrecioLibro() == castOther.getPrecioLibro()) ||
        ((this.getPrecioLibro() != null) &&
        (castOther.getPrecioLibro() != null) &&
        this.getPrecioLibro().equals(castOther.getPrecioLibro()))) &&
        ((this.getNombreCliente() == castOther.getNombreCliente()) ||
        ((this.getNombreCliente() != null) &&
        (castOther.getNombreCliente() != null) &&
        this.getNombreCliente().equals(castOther.getNombreCliente()))) &&
        ((this.getFechaCompra() == castOther.getFechaCompra()) ||
        ((this.getFechaCompra() != null) &&
        (castOther.getFechaCompra() != null) &&
        this.getFechaCompra().equals(castOther.getFechaCompra())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getIdVentas() == null) ? 0 : this.getIdVentas().hashCode());
        result = (37 * result) +
            ((getNombreLibro() == null) ? 0 : this.getNombreLibro().hashCode());
        result = (37 * result) +
            ((getPrecioLibro() == null) ? 0 : this.getPrecioLibro().hashCode());
        result = (37 * result) +
            ((getNombreCliente() == null) ? 0 : this.getNombreCliente()
                                                    .hashCode());
        result = (37 * result) +
            ((getFechaCompra() == null) ? 0 : this.getFechaCompra().hashCode());

        return result;
    }
}
