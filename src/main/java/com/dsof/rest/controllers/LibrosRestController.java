package com.dsof.rest.controllers;

import com.dsof.dto.mapper.ILibrosMapper;

import com.dsof.model.*;
import com.dsof.model.dto.LibrosDTO;

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

import java.util.List;


@RestController
@RequestMapping("/libros")
public class LibrosRestController {
    private static final Logger log = LoggerFactory.getLogger(LibrosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ILibrosMapper librosMapper;

    @PostMapping(value = "/saveLibros")
    public void saveLibros(@RequestBody
    LibrosDTO librosDTO) throws Exception {
        try {
            Libros libros = librosMapper.librosDTOToLibros(librosDTO);

            businessDelegatorView.saveLibros(libros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteLibros/{idLibro}")
    public void deleteLibros(@PathVariable("idLibro")
    String idLibro) throws Exception {
        try {
            Libros libros = businessDelegatorView.getLibros(idLibro);

            businessDelegatorView.deleteLibros(libros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateLibros/")
    public void updateLibros(@RequestBody
    LibrosDTO librosDTO) throws Exception {
        try {
            Libros libros = librosMapper.librosDTOToLibros(librosDTO);

            businessDelegatorView.updateLibros(libros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataLibros")
    public List<LibrosDTO> getDataLibros() throws Exception {
        try {
            return businessDelegatorView.getDataLibros();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getLibros/{idLibro}")
    public LibrosDTO getLibros(@PathVariable("idLibro")
    String idLibro) throws Exception {
        try {
            Libros libros = businessDelegatorView.getLibros(idLibro);

            return librosMapper.librosToLibrosDTO(libros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
