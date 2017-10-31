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

import com.dsof.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ILibrosLogic librosLogic;
    @Autowired
    private IVentasLogic ventasLogic;

    public List<Libros> getLibros() throws Exception {
        return librosLogic.getLibros();
    }

    public void saveLibros(Libros entity) throws Exception {
        librosLogic.saveLibros(entity);
    }

    public void deleteLibros(Libros entity) throws Exception {
        librosLogic.deleteLibros(entity);
    }

    public void updateLibros(Libros entity) throws Exception {
        librosLogic.updateLibros(entity);
    }

    public Libros getLibros(String idLibro) throws Exception {
        Libros libros = null;

        try {
            libros = librosLogic.getLibros(idLibro);
        } catch (Exception e) {
            throw e;
        }

        return libros;
    }

    public List<Libros> findByCriteriaInLibros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return librosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Libros> findPageLibros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return librosLogic.findPageLibros(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberLibros() throws Exception {
        return librosLogic.findTotalNumberLibros();
    }

    public List<LibrosDTO> getDataLibros() throws Exception {
        return librosLogic.getDataLibros();
    }

    public void validateLibros(Libros libros) throws Exception {
        librosLogic.validateLibros(libros);
    }

    public List<Ventas> getVentas() throws Exception {
        return ventasLogic.getVentas();
    }

    public void saveVentas(Ventas entity) throws Exception {
        ventasLogic.saveVentas(entity);
    }

    public void deleteVentas(Ventas entity) throws Exception {
        ventasLogic.deleteVentas(entity);
    }

    public void updateVentas(Ventas entity) throws Exception {
        ventasLogic.updateVentas(entity);
    }

    public Ventas getVentas(VentasId id) throws Exception {
        Ventas ventas = null;

        try {
            ventas = ventasLogic.getVentas(id);
        } catch (Exception e) {
            throw e;
        }

        return ventas;
    }

    public List<Ventas> findByCriteriaInVentas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return ventasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Ventas> findPageVentas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return ventasLogic.findPageVentas(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberVentas() throws Exception {
        return ventasLogic.findTotalNumberVentas();
    }

    public List<VentasDTO> getDataVentas() throws Exception {
        return ventasLogic.getDataVentas();
    }

    public void validateVentas(Ventas ventas) throws Exception {
        ventasLogic.validateVentas(ventas);
    }
}