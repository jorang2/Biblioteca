package com.dsof.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "ventas", schema = "${schema}")
public class Ventas implements java.io.Serializable {
    @Id
    @NotNull
    private VentasId id;

    public Ventas() {
    }

    public Ventas(VentasId id) {
        this.id = id;
    }

    public VentasId getId() {
        return this.id;
    }

    public void setId(VentasId id) {
        this.id = id;
    }
}
