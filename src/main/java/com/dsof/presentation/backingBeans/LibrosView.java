package com.dsof.presentation.backingBeans;

import com.dsof.exceptions.*;

import com.dsof.model.*;
import com.dsof.model.dto.LibrosDTO;

import com.dsof.presentation.businessDelegate.*;

import com.dsof.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class LibrosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LibrosView.class);
    private InputText txtAutor;
    private InputText txtGenero;
    private InputText txtNombreLibro;
    private InputText txtIdLibro;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LibrosDTO> data;
    private LibrosDTO selectedLibros;
    private Libros entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public LibrosView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedLibros = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLibros = null;

        if (txtAutor != null) {
            txtAutor.setValue(null);
            txtAutor.setDisabled(true);
        }

        if (txtGenero != null) {
            txtGenero.setValue(null);
            txtGenero.setDisabled(true);
        }

        if (txtNombreLibro != null) {
            txtNombreLibro.setValue(null);
            txtNombreLibro.setDisabled(true);
        }

        if (txtIdLibro != null) {
            txtIdLibro.setValue(null);
            txtIdLibro.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            String idLibro = FacesUtils.checkString(txtIdLibro);
            entity = (idLibro != null)
                ? businessDelegatorView.getLibros(idLibro) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAutor.setDisabled(false);
            txtGenero.setDisabled(false);
            txtNombreLibro.setDisabled(false);
            txtIdLibro.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAutor.setValue(entity.getAutor());
            txtAutor.setDisabled(false);
            txtGenero.setValue(entity.getGenero());
            txtGenero.setDisabled(false);
            txtNombreLibro.setValue(entity.getNombreLibro());
            txtNombreLibro.setDisabled(false);
            txtIdLibro.setValue(entity.getIdLibro());
            txtIdLibro.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLibros = (LibrosDTO) (evt.getComponent().getAttributes()
                                         .get("selectedLibros"));
        txtAutor.setValue(selectedLibros.getAutor());
        txtAutor.setDisabled(false);
        txtGenero.setValue(selectedLibros.getGenero());
        txtGenero.setDisabled(false);
        txtNombreLibro.setValue(selectedLibros.getNombreLibro());
        txtNombreLibro.setDisabled(false);
        txtIdLibro.setValue(selectedLibros.getIdLibro());
        txtIdLibro.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLibros == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Libros();

            String idLibro = FacesUtils.checkString(txtIdLibro);

            entity.setAutor(FacesUtils.checkString(txtAutor));
            entity.setGenero(FacesUtils.checkString(txtGenero));
            entity.setIdLibro(idLibro);
            entity.setNombreLibro(FacesUtils.checkString(txtNombreLibro));
            businessDelegatorView.saveLibros(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                String idLibro = new String(selectedLibros.getIdLibro());
                entity = businessDelegatorView.getLibros(idLibro);
            }

            entity.setAutor(FacesUtils.checkString(txtAutor));
            entity.setGenero(FacesUtils.checkString(txtGenero));
            entity.setNombreLibro(FacesUtils.checkString(txtNombreLibro));
            businessDelegatorView.updateLibros(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLibros = (LibrosDTO) (evt.getComponent().getAttributes()
                                             .get("selectedLibros"));

            String idLibro = new String(selectedLibros.getIdLibro());
            entity = businessDelegatorView.getLibros(idLibro);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            String idLibro = FacesUtils.checkString(txtIdLibro);
            entity = businessDelegatorView.getLibros(idLibro);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLibros(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String autor, String genero,
        String idLibro, String nombreLibro) throws Exception {
        try {
            entity.setAutor(FacesUtils.checkString(autor));
            entity.setGenero(FacesUtils.checkString(genero));
            entity.setNombreLibro(FacesUtils.checkString(nombreLibro));
            businessDelegatorView.updateLibros(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LibrosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(InputText txtAutor) {
        this.txtAutor = txtAutor;
    }

    public InputText getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(InputText txtGenero) {
        this.txtGenero = txtGenero;
    }

    public InputText getTxtNombreLibro() {
        return txtNombreLibro;
    }

    public void setTxtNombreLibro(InputText txtNombreLibro) {
        this.txtNombreLibro = txtNombreLibro;
    }

    public InputText getTxtIdLibro() {
        return txtIdLibro;
    }

    public void setTxtIdLibro(InputText txtIdLibro) {
        this.txtIdLibro = txtIdLibro;
    }

    public List<LibrosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLibros();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LibrosDTO> librosDTO) {
        this.data = librosDTO;
    }

    public LibrosDTO getSelectedLibros() {
        return selectedLibros;
    }

    public void setSelectedLibros(LibrosDTO libros) {
        this.selectedLibros = libros;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
