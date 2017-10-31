package com.dsof.model.control;

import com.dsof.model.Libros;
import com.dsof.model.dto.LibrosDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ILibrosLogic {
    public List<Libros> getLibros() throws Exception;

    /**
         * Save an new Libros entity
         */
    public void saveLibros(Libros entity) throws Exception;

    /**
         * Delete an existing Libros entity
         *
         */
    public void deleteLibros(Libros entity) throws Exception;

    /**
        * Update an existing Libros entity
        *
        */
    public void updateLibros(Libros entity) throws Exception;

    /**
         * Load an existing Libros entity
         *
         */
    public Libros getLibros(String idLibro) throws Exception;

    public List<Libros> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Libros> findPageLibros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLibros() throws Exception;

    public List<LibrosDTO> getDataLibros() throws Exception;

    public void validateLibros(Libros libros) throws Exception;
}
