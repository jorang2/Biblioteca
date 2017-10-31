package com.dsof.presentation.businessDelegate;

import com.dsof.model.Libros;
import com.dsof.model.Ventas;
import com.dsof.model.VentasId;
import com.dsof.model.control.ILibrosLogic;
import com.dsof.model.control.IVentasLogic;
import com.dsof.model.control.LibrosLogic;
import com.dsof.model.control.VentasLogic;
import com.dsof.model.dto.LibrosDTO;
import com.dsof.model.dto.VentasDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Libros> getLibros() throws Exception;

    public void saveLibros(Libros entity) throws Exception;

    public void deleteLibros(Libros entity) throws Exception;

    public void updateLibros(Libros entity) throws Exception;

    public Libros getLibros(String idLibro) throws Exception;

    public List<Libros> findByCriteriaInLibros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Libros> findPageLibros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLibros() throws Exception;

    public List<LibrosDTO> getDataLibros() throws Exception;

    public void validateLibros(Libros libros) throws Exception;

    public List<Ventas> getVentas() throws Exception;

    public void saveVentas(Ventas entity) throws Exception;

    public void deleteVentas(Ventas entity) throws Exception;

    public void updateVentas(Ventas entity) throws Exception;

    public Ventas getVentas(VentasId id) throws Exception;

    public List<Ventas> findByCriteriaInVentas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Ventas> findPageVentas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVentas() throws Exception;

    public List<VentasDTO> getDataVentas() throws Exception;

    public void validateVentas(Ventas ventas) throws Exception;
}
