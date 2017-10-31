package com.dsof.presentation.backingBeans;

import com.dsof.exceptions.*;

import com.dsof.model.*;
import com.dsof.model.dto.VentasDTO;

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
public class VentasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VentasView.class);
    private InputText txtIdVentas;
    private InputText txtNombreLibro;
    private InputText txtPrecioLibro;
    private InputText txtNombreCliente;
    private Calendar txtFechaCompra;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<VentasDTO> data;
    private VentasDTO selectedVentas;
    private Ventas entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public VentasView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedVentas = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedVentas = null;

        if (txtIdVentas != null) {
            txtIdVentas.setValue(null);
            txtIdVentas.setDisabled(false);
        }

        if (txtNombreLibro != null) {
            txtNombreLibro.setValue(null);
            txtNombreLibro.setDisabled(false);
        }

        if (txtPrecioLibro != null) {
            txtPrecioLibro.setValue(null);
            txtPrecioLibro.setDisabled(false);
        }

        if (txtNombreCliente != null) {
            txtNombreCliente.setValue(null);
            txtNombreCliente.setDisabled(false);
        }

        if (txtFechaCompra != null) {
            txtFechaCompra.setValue(null);
            txtFechaCompra.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechaCompra() {
        Date inputDate = (Date) txtFechaCompra.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            VentasId id = new VentasId();
            id.setIdVentas((((txtIdVentas.getValue()) == null) ||
                (txtIdVentas.getValue()).equals("")) ? null
                                                     : FacesUtils.checkInteger(
                    txtIdVentas));
            id.setNombreLibro((((txtNombreLibro.getValue()) == null) ||
                (txtNombreLibro.getValue()).equals("")) ? null
                                                        : FacesUtils.checkString(
                    txtNombreLibro));
            id.setPrecioLibro((((txtPrecioLibro.getValue()) == null) ||
                (txtPrecioLibro.getValue()).equals("")) ? null
                                                        : FacesUtils.checkString(
                    txtPrecioLibro));
            id.setNombreCliente((((txtNombreCliente.getValue()) == null) ||
                (txtNombreCliente.getValue()).equals("")) ? null
                                                          : FacesUtils.checkString(
                    txtNombreCliente));
            id.setFechaCompra((((txtFechaCompra.getValue()) == null) ||
                (txtFechaCompra.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDate(
                    txtFechaCompra.getValue()));
            entity = (id != null) ? businessDelegatorView.getVentas(id) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdVentas.setDisabled(false);
            txtNombreLibro.setDisabled(false);
            txtPrecioLibro.setDisabled(false);
            txtNombreCliente.setDisabled(false);
            txtFechaCompra.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtIdVentas.setValue(entity.getId().getIdVentas());
            txtIdVentas.setDisabled(true);
            txtNombreLibro.setValue(entity.getId().getNombreLibro());
            txtNombreLibro.setDisabled(true);
            txtPrecioLibro.setValue(entity.getId().getPrecioLibro());
            txtPrecioLibro.setDisabled(true);
            txtNombreCliente.setValue(entity.getId().getNombreCliente());
            txtNombreCliente.setDisabled(true);
            txtFechaCompra.setValue(entity.getId().getFechaCompra());
            txtFechaCompra.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedVentas = (VentasDTO) (evt.getComponent().getAttributes()
                                         .get("selectedVentas"));
        txtIdVentas.setValue(selectedVentas.getIdVentas());
        txtIdVentas.setDisabled(true);
        txtNombreLibro.setValue(selectedVentas.getNombreLibro());
        txtNombreLibro.setDisabled(true);
        txtPrecioLibro.setValue(selectedVentas.getPrecioLibro());
        txtPrecioLibro.setDisabled(true);
        txtNombreCliente.setValue(selectedVentas.getNombreCliente());
        txtNombreCliente.setDisabled(true);
        txtFechaCompra.setValue(selectedVentas.getFechaCompra());
        txtFechaCompra.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedVentas == null) && (entity == null)) {
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
            entity = new Ventas();

            VentasId id = new VentasId();
            id.setIdVentas((((txtIdVentas.getValue()) == null) ||
                (txtIdVentas.getValue()).equals("")) ? null
                                                     : FacesUtils.checkInteger(
                    txtIdVentas));
            id.setNombreLibro((((txtNombreLibro.getValue()) == null) ||
                (txtNombreLibro.getValue()).equals("")) ? null
                                                        : FacesUtils.checkString(
                    txtNombreLibro));
            id.setPrecioLibro((((txtPrecioLibro.getValue()) == null) ||
                (txtPrecioLibro.getValue()).equals("")) ? null
                                                        : FacesUtils.checkString(
                    txtPrecioLibro));
            id.setNombreCliente((((txtNombreCliente.getValue()) == null) ||
                (txtNombreCliente.getValue()).equals("")) ? null
                                                          : FacesUtils.checkString(
                    txtNombreCliente));
            id.setFechaCompra((((txtFechaCompra.getValue()) == null) ||
                (txtFechaCompra.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDate(
                    txtFechaCompra.getValue()));

            entity.setId(id);
            businessDelegatorView.saveVentas(entity);
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
                VentasId id = new VentasId();
                id.setIdVentas(selectedVentas.getIdVentas());
                id.setNombreLibro(selectedVentas.getNombreLibro());
                id.setPrecioLibro(selectedVentas.getPrecioLibro());
                id.setNombreCliente(selectedVentas.getNombreCliente());
                id.setFechaCompra(selectedVentas.getFechaCompra());
                entity = businessDelegatorView.getVentas(id);
            }

            businessDelegatorView.updateVentas(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedVentas = (VentasDTO) (evt.getComponent().getAttributes()
                                             .get("selectedVentas"));

            VentasId id = new VentasId();
            id.setIdVentas(selectedVentas.getIdVentas());
            id.setNombreLibro(selectedVentas.getNombreLibro());
            id.setPrecioLibro(selectedVentas.getPrecioLibro());
            id.setNombreCliente(selectedVentas.getNombreCliente());
            id.setFechaCompra(selectedVentas.getFechaCompra());
            entity = businessDelegatorView.getVentas(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            VentasId id = new VentasId();
            id.setIdVentas((((txtIdVentas.getValue()) == null) ||
                (txtIdVentas.getValue()).equals("")) ? null
                                                     : FacesUtils.checkInteger(
                    txtIdVentas));
            id.setNombreLibro((((txtNombreLibro.getValue()) == null) ||
                (txtNombreLibro.getValue()).equals("")) ? null
                                                        : FacesUtils.checkString(
                    txtNombreLibro));
            id.setPrecioLibro((((txtPrecioLibro.getValue()) == null) ||
                (txtPrecioLibro.getValue()).equals("")) ? null
                                                        : FacesUtils.checkString(
                    txtPrecioLibro));
            id.setNombreCliente((((txtNombreCliente.getValue()) == null) ||
                (txtNombreCliente.getValue()).equals("")) ? null
                                                          : FacesUtils.checkString(
                    txtNombreCliente));
            id.setFechaCompra((((txtFechaCompra.getValue()) == null) ||
                (txtFechaCompra.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDate(
                    txtFechaCompra.getValue()));
            entity = businessDelegatorView.getVentas(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteVentas(entity);
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

    public String action_modifyWitDTO(Integer idVentas, String nombreLibro,
        String precioLibro, String nombreCliente, Date fechaCompra)
        throws Exception {
        try {
            businessDelegatorView.updateVentas(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("VentasView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdVentas() {
        return txtIdVentas;
    }

    public void setTxtIdVentas(InputText txtIdVentas) {
        this.txtIdVentas = txtIdVentas;
    }

    public InputText getTxtNombreLibro() {
        return txtNombreLibro;
    }

    public void setTxtNombreLibro(InputText txtNombreLibro) {
        this.txtNombreLibro = txtNombreLibro;
    }

    public InputText getTxtPrecioLibro() {
        return txtPrecioLibro;
    }

    public void setTxtPrecioLibro(InputText txtPrecioLibro) {
        this.txtPrecioLibro = txtPrecioLibro;
    }

    public InputText getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public void setTxtNombreCliente(InputText txtNombreCliente) {
        this.txtNombreCliente = txtNombreCliente;
    }

    public Calendar getTxtFechaCompra() {
        return txtFechaCompra;
    }

    public void setTxtFechaCompra(Calendar txtFechaCompra) {
        this.txtFechaCompra = txtFechaCompra;
    }

    public List<VentasDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataVentas();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<VentasDTO> ventasDTO) {
        this.data = ventasDTO;
    }

    public VentasDTO getSelectedVentas() {
        return selectedVentas;
    }

    public void setSelectedVentas(VentasDTO ventas) {
        this.selectedVentas = ventas;
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
