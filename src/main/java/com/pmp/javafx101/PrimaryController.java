package com.pmp.javafx101;

import java.net.URL;
import com.pmp.dao.Empleado;
import com.pmp.dao.Empleados;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.scene.control.cell.PropertyValueFactory;

import com.pmp.dao.Empleado;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
    int contador = 0;
    @FXML
    private Button primaryButton;
    @FXML
    private Label labelContador;
    @FXML
    private TableView tblEmpleado;
    @FXML
    private TableColumn clmNombres;
    @FXML
    private TableColumn clmApellidos;
    @FXML
    private TableColumn clmEmail;
    @FXML
    private TableColumn clmTelefono;
    @FXML
    private TableColumn clmCargo;
    
    
    private ObservableList<EmpleadoAdapter> listaEmpleado;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        this.clmNombres.setCellValueFactory(new PropertyValueFactory<>("_nombres"));
        this.clmApellidos.setCellValueFactory(new PropertyValueFactory<>("_apellidos"));
        this.clmEmail.setCellValueFactory(new PropertyValueFactory<>("_email"));
        this.clmTelefono.setCellValueFactory(new PropertyValueFactory<>("_telefono"));
        this.clmCargo.setCellValueFactory(new PropertyValueFactory<>("_cargo"));
        this.initializeDummyData();
        this.tblEmpleado.getItems().addAll(listaEmpleado);
    }
    
    private void initializeDummyData()
    {
       Empleado empleado = new Empleado();
       empleado.setNombres("Maria");
       empleado.setApellidos("Gonzalez");
       empleado.setDireccion("Tegucigalpa");
       empleado.setEmail("mf_gonzalezr@unicah.edu");
       empleado.setGenero("M");
       empleado.setCargo("Gerente");
       empleado.setTelefono("0000-0000");
       EmpleadoAdapter eadapter = new EmpleadoAdapter(empleado);
       this.listaEmpleado.add(eadapter);
    }
    @FXML
    private void switchToSecondary() throws IOException {
        
       try{
        FXMLLoader win = App.getFXMLLoader("empleadoform");
       Parent winObject = win.load();
       EmpleadoformController empleadoWin = (EmpleadoformController) win.getController();
       
       
       Empleado empleado = new Empleado();
       empleado.setNombres("Maria");
       empleado.setApellidos("Gonzalez");
       empleado.setDireccion("Tegucigalpa");
       empleado.setEmail("mf_gonzalezr@unicah.edu");
       empleado.setGenero("M");
       empleado.setCargo("Gerente");
       empleado.setTelefono("0000-0000");
       
       empleadoWin.setEmpleadoObject(empleado);
       
       
       App.loadFXMLModal(winObject);
       empleado = empleadoWin.getEmpleadoObject();
       System.out.println(empleado.getString());
       }
       catch(IOException ex){
           System.err.println(ex);
       }
    
       
       
    }
}
