package com.dsof.model.control;

import com.dsof.model.Ventas;
import com.dsof.model.VentasId;
import com.dsof.model.dto.VentasDTO;

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
public interface IVentasLogic {
    public List<Ventas> getVentas() throws Exception;

    /**
         * Save an new Ventas entity
         */
    public void saveVentas(Ventas entity) throws Exception;

    /**
         * Delete an existing Ventas entity
         *
         */
    public void deleteVentas(Ventas entity) throws Exception;

    /**
        * Update an existing Ventas entity
        *
        */
    public void updateVentas(Ventas entity) throws Exception;

    /**
         * Load an existing Ventas entity
         *
         */
    public Ventas getVentas(VentasId id) throws Exception;

    public List<Ventas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Ventas> findPageVentas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVentas() throws Exception;

    public List<VentasDTO> getDataVentas() throws Exception;

    public void validateVentas(Ventas ventas) throws Exception;
}
