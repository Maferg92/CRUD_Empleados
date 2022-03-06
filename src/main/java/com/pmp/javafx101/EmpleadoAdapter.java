/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.javafx101;
import com.pmp.dao.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author FernandaGonzalez
 */
public class EmpleadoAdapter {

    public String getNombres() {
        return nombres.get();
    }

    public void setNombres(String _nombres) {
        this.nombres.set(_nombres);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String _apellidos) {
        this.apellidos.set(_apellidos);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String _email) {
        this.email.set(_email);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String _telefono) {
        this.telefono.set( _telefono);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String _direccion) {
        this.direccion.set(_direccion);
    }

    public String getCargo() {
        return cargo.get();
    }

    public void setCargo(String _cargo) {
        this.cargo.set(_cargo);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String _genero) {
        this.genero.set(_genero);
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int _id) {
        this.id.set(_id);
    }
    
    private Empleado _empleado;
    
    public Empleado getEmpleado(){
        _empleado.setNombres(nombres.get());
        _empleado.setApellidos(apellidos.get());
        _empleado.setEmail(email.get());
        _empleado.setTelefono(telefono.get());
        _empleado.setCargo(cargo.get());
        _empleado.setGenero(genero.get());
        _empleado.setDireccion(direccion.get());
        _empleado.setId(id.get());
      
        return this._empleado;
    }
    
    public EmpleadoAdapter()
    {
        this._empleado = new Empleado();
        nombres= new SimpleStringProperty("");
        apellidos= new SimpleStringProperty("");
        email= new SimpleStringProperty("");
        telefono= new SimpleStringProperty("");
        direccion= new SimpleStringProperty("");
        cargo= new SimpleStringProperty("");
        genero= new SimpleStringProperty("");
    }
    
        public EmpleadoAdapter(Empleado _empleado)
    {
        this._empleado = _empleado;
        nombres= new SimpleStringProperty("");
        apellidos= new SimpleStringProperty("");
        email= new SimpleStringProperty("");
        telefono= new SimpleStringProperty("");
        direccion= new SimpleStringProperty("");
        cargo= new SimpleStringProperty("");
        genero= new SimpleStringProperty("");
        id = new SimpleIntegerProperty(0);
        
        this._empleado = new Empleado();
        nombres.set(_empleado.getNombres());
        apellidos.set(_empleado.getApellidos());
        email.set(_empleado.getEmail());
        telefono.set(_empleado.getTelefono());
        direccion.set(_empleado.getDireccion());
        cargo.set(_empleado.getCargo());
        genero.set(_empleado.getGenero());
        id.set(_empleado.getId());
    }
    
    private SimpleStringProperty nombres;
    private SimpleStringProperty apellidos;
    private SimpleStringProperty email;
    private SimpleStringProperty telefono;
    private SimpleStringProperty direccion;
    private SimpleStringProperty cargo;
    private SimpleStringProperty genero;
    private SimpleIntegerProperty id;
}
