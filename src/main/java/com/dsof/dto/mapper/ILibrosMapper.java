package com.dsof.dto.mapper;

import com.dsof.model.Libros;
import com.dsof.model.dto.LibrosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ILibrosMapper {
    public LibrosDTO librosToLibrosDTO(Libros libros) throws Exception;

    public Libros librosDTOToLibros(LibrosDTO librosDTO)
        throws Exception;

    public List<LibrosDTO> listLibrosToListLibrosDTO(List<Libros> libross)
        throws Exception;

    public List<Libros> listLibrosDTOToListLibros(List<LibrosDTO> librosDTOs)
        throws Exception;
}
