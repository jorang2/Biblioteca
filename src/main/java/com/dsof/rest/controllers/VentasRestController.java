package com.dsof.rest.controllers;

import com.dsof.dto.mapper.IVentasMapper;

import com.dsof.model.*;
import com.dsof.model.dto.VentasDTO;

import com.dsof.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/ventas")
public class VentasRestController {
    private static final Logger log = LoggerFactory.getLogger(VentasRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IVentasMapper ventasMapper;

    @PostMapping(value = "/saveVentas")
    public void saveVentas(@RequestBody
    VentasDTO ventasDTO) throws Exception {
        try {
            Ventas ventas = ventasMapper.ventasDTOToVentas(ventasDTO);

            businessDelegatorView.saveVentas(ventas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteVentas/{idVentas}/{nombreLibro}/{precioLibro}/{nombreCliente}/{fechaCompra}")
    public void deleteVentas(@PathVariable("idVentas")
    Integer idVentas, @PathVariable("nombreLibro")
    String nombreLibro, @PathVariable("precioLibro")
    String precioLibro, @PathVariable("nombreCliente")
    String nombreCliente, @PathVariable("fechaCompra")
    Date fechaCompra) throws Exception {
        try {
            VentasId id = new VentasId();

            id.setIdVentas(idVentas);
            id.setNombreLibro(nombreLibro);
            id.setPrecioLibro(precioLibro);
            id.setNombreCliente(nombreCliente);
            id.setFechaCompra(fechaCompra);

            Ventas ventas = businessDelegatorView.getVentas(id);

            businessDelegatorView.deleteVentas(ventas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateVentas/")
    public void updateVentas(@RequestBody
    VentasDTO ventasDTO) throws Exception {
        try {
            Ventas ventas = ventasMapper.ventasDTOToVentas(ventasDTO);

            businessDelegatorView.updateVentas(ventas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataVentas")
    public List<VentasDTO> getDataVentas() throws Exception {
        try {
            return businessDelegatorView.getDataVentas();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getVentas/{idVentas}/{nombreLibro}/{precioLibro}/{nombreCliente}/{fechaCompra}")
    public VentasDTO getVentas(@PathVariable("idVentas")
    Integer idVentas, @PathVariable("nombreLibro")
    String nombreLibro, @PathVariable("precioLibro")
    String precioLibro, @PathVariable("nombreCliente")
    String nombreCliente, @PathVariable("fechaCompra")
    Date fechaCompra) throws Exception {
        try {
            VentasId id = new VentasId();

            id.setIdVentas(idVentas);
            id.setNombreLibro(nombreLibro);
            id.setPrecioLibro(precioLibro);
            id.setNombreCliente(nombreCliente);
            id.setFechaCompra(fechaCompra);

            Ventas ventas = businessDelegatorView.getVentas(id);

            return ventasMapper.ventasToVentasDTO(ventas);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
