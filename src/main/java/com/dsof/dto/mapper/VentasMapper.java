package com.dsof.dto.mapper;

import com.dsof.model.*;
import com.dsof.model.Ventas;
import com.dsof.model.control.*;
import com.dsof.model.dto.VentasDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class VentasMapper implements IVentasMapper {
    private static final Logger log = LoggerFactory.getLogger(VentasMapper.class);

    @Transactional(readOnly = true)
    public VentasDTO ventasToVentasDTO(Ventas ventas) throws Exception {
        try {
            VentasDTO ventasDTO = new VentasDTO();

            ventasDTO.setIdVentas(ventas.getId().getIdVentas());
            ventasDTO.setNombreLibro(ventas.getId().getNombreLibro());
            ventasDTO.setPrecioLibro(ventas.getId().getPrecioLibro());
            ventasDTO.setNombreCliente(ventas.getId().getNombreCliente());
            ventasDTO.setFechaCompra(ventas.getId().getFechaCompra());

            return ventasDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Ventas ventasDTOToVentas(VentasDTO ventasDTO)
        throws Exception {
        try {
            Ventas ventas = new Ventas();

            VentasId ventasId = new VentasId();

            if ((ventasDTO.getIdVentas() != null) &&
                    (ventasDTO.getIdVentas().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            ventasId.setIdVentas((ventasDTO.getIdVentas() != null)
                ? ventasDTO.getIdVentas() : null);

            if ((ventasDTO.getNombreLibro() != null) &&
                    (ventasDTO.getNombreLibro().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            ventasId.setNombreLibro((ventasDTO.getNombreLibro() != null)
                ? ventasDTO.getNombreLibro() : null);

            if ((ventasDTO.getPrecioLibro() != null) &&
                    (ventasDTO.getPrecioLibro().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            ventasId.setPrecioLibro((ventasDTO.getPrecioLibro() != null)
                ? ventasDTO.getPrecioLibro() : null);

            if ((ventasDTO.getNombreCliente() != null) &&
                    (ventasDTO.getNombreCliente().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            ventasId.setNombreCliente((ventasDTO.getNombreCliente() != null)
                ? ventasDTO.getNombreCliente() : null);

            if ((ventasDTO.getFechaCompra() != null) &&
                    (ventasDTO.getFechaCompra().toString().length() <= 0)) {
                throw new Exception("La llave no puede ser nula");
            }

            ventasId.setFechaCompra((ventasDTO.getFechaCompra() != null)
                ? ventasDTO.getFechaCompra() : null);
            ventas.setId(ventasId);

            return ventas;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<VentasDTO> listVentasToListVentasDTO(List<Ventas> listVentas)
        throws Exception {
        try {
            List<VentasDTO> ventasDTOs = new ArrayList<VentasDTO>();

            for (Ventas ventas : listVentas) {
                VentasDTO ventasDTO = ventasToVentasDTO(ventas);

                ventasDTOs.add(ventasDTO);
            }

            return ventasDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Ventas> listVentasDTOToListVentas(List<VentasDTO> listVentasDTO)
        throws Exception {
        try {
            List<Ventas> listVentas = new ArrayList<Ventas>();

            for (VentasDTO ventasDTO : listVentasDTO) {
                Ventas ventas = ventasDTOToVentas(ventasDTO);

                listVentas.add(ventas);
            }

            return listVentas;
        } catch (Exception e) {
            throw e;
        }
    }
}
