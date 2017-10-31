package com.dsof.dto.mapper;

import com.dsof.model.*;
import com.dsof.model.Libros;
import com.dsof.model.control.*;
import com.dsof.model.dto.LibrosDTO;

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
public class LibrosMapper implements ILibrosMapper {
    private static final Logger log = LoggerFactory.getLogger(LibrosMapper.class);

    @Transactional(readOnly = true)
    public LibrosDTO librosToLibrosDTO(Libros libros) throws Exception {
        try {
            LibrosDTO librosDTO = new LibrosDTO();

            librosDTO.setIdLibro(libros.getIdLibro());
            librosDTO.setAutor((libros.getAutor() != null) ? libros.getAutor()
                                                           : null);
            librosDTO.setGenero((libros.getGenero() != null)
                ? libros.getGenero() : null);
            librosDTO.setNombreLibro((libros.getNombreLibro() != null)
                ? libros.getNombreLibro() : null);

            return librosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Libros librosDTOToLibros(LibrosDTO librosDTO)
        throws Exception {
        try {
            Libros libros = new Libros();

            libros.setIdLibro(librosDTO.getIdLibro());
            libros.setAutor((librosDTO.getAutor() != null)
                ? librosDTO.getAutor() : null);
            libros.setGenero((librosDTO.getGenero() != null)
                ? librosDTO.getGenero() : null);
            libros.setNombreLibro((librosDTO.getNombreLibro() != null)
                ? librosDTO.getNombreLibro() : null);

            return libros;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<LibrosDTO> listLibrosToListLibrosDTO(List<Libros> listLibros)
        throws Exception {
        try {
            List<LibrosDTO> librosDTOs = new ArrayList<LibrosDTO>();

            for (Libros libros : listLibros) {
                LibrosDTO librosDTO = librosToLibrosDTO(libros);

                librosDTOs.add(librosDTO);
            }

            return librosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Libros> listLibrosDTOToListLibros(List<LibrosDTO> listLibrosDTO)
        throws Exception {
        try {
            List<Libros> listLibros = new ArrayList<Libros>();

            for (LibrosDTO librosDTO : listLibrosDTO) {
                Libros libros = librosDTOToLibros(librosDTO);

                listLibros.add(libros);
            }

            return listLibros;
        } catch (Exception e) {
            throw e;
        }
    }
}
