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
*   PRUEBA DE GIT prueba 2 prueba 3
*/
@Entity
@Table(name = "libros", schema = "${schema}")
public class Libros implements java.io.Serializable {
    @Id
    @NotNull
    private String idLibro;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String autor;
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String genero;
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String nombreLibro;

    public Libros() {
    }

    public Libros(String idLibro, String autor, String genero,
        String nombreLibro) {
        this.idLibro = idLibro;
        this.autor = autor;
        this.genero = genero;
        this.nombreLibro = nombreLibro;
    }

    public String getIdLibro() {
        return this.idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombreLibro() {
        return this.nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
}
