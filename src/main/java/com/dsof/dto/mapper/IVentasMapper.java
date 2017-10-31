package com.dsof.dto.mapper;

import com.dsof.model.Ventas;
import com.dsof.model.dto.VentasDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IVentasMapper {
    public VentasDTO ventasToVentasDTO(Ventas ventas) throws Exception;

    public Ventas ventasDTOToVentas(VentasDTO ventasDTO)
        throws Exception;

    public List<VentasDTO> listVentasToListVentasDTO(List<Ventas> ventass)
        throws Exception;

    public List<Ventas> listVentasDTOToListVentas(List<VentasDTO> ventasDTOs)
        throws Exception;
}
