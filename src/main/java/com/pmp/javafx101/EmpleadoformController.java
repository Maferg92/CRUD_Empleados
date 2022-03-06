/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.javafx101;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import com.pmp.dao.Empleado;
/**
 * FXML Controller class
 *
 * @author FernandaGonzalez
 */
public class EmpleadoformController implements Initializable {


    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtCargo;
    @FXML
    private RadioButton rdbGeneroFemenino;
    @FXML
    private ToggleGroup genero;
    @FXML
    private RadioButton rdbGeneroMasculino;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnConfirmar_click(ActionEvent event) {
        
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        App.closeModal(event);
    }
    
    private Empleado _empleado;
    
    public void setEmpleadoObject(Empleado empleado)
    {
        _empleado = empleado;
        refreshUX();
        
    }
    
    private void refreshUX()
    {
    txtNombres.setText(_empleado.getNombres());
    txtApellidos.setText(_empleado.getApellidos());
    txtEmail.setText(_empleado.getEmail());
    txtTelefono.setText(_empleado.getTelefono());
    txtDireccion.setText(_empleado.getDireccion());
    txtCargo.setText(_empleado.getCargo());
    
    rdbGeneroMasculino.setSelected(_empleado.getGenero() == "M");
    rdbGeneroFemenino.setSelected(_empleado.getGenero() == "F");
    
    /*if(_empleado.getGenero() == "M")
    {
        rdbGeneroMasculino.setSelected(true);
        rdbGeneroFemenino.setSelected(false);
    }
    else
    {
        rdbGeneroMasculino.setSelected(false);
        rdbGeneroFemenino.setSelected(true);
    }
    */
  
    }
    
    
    public Empleado getEmpleadoObject()
    {
        refreshObjFromUx();
        return _empleado;
    }
    
    private void refreshObjFromUx()
    {
    _empleado.setNombres(txtNombres.getText());
    _empleado.setApellidos(txtApellidos.getText());
    _empleado.setEmail(txtEmail.getText());
    _empleado.setTelefono(txtTelefono.getText());
    _empleado.setDireccion(txtDireccion.getText());
    _empleado.setCargo(txtCargo.getText());
    
    _empleado.setGenero(rdbGeneroMasculino.isSelected()? "M":"F");
   

    }

}
