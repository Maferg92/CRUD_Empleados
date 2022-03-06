/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

/**
 *
 * @author FernandaGonzalez
 */
public class Empleado {

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNombres() {
        return _nombres;
    }

    public void setNombres(String _nombres) {
        this._nombres = _nombres;
    }

    public String getApellidos() {
        return _apellidos;
    }

    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getCargo() {
        return _cargo;
    }

    public void setCargo(String _cargo) {
        this._cargo = _cargo;
    }

    public String getGenero() {
        return _genero;
    }

    public void setGenero(String _genero) {
        this._genero = _genero;
    }
    
    private String _nombres;
    private String _apellidos;
    private String _email;
    private String _telefono;
    private String _direccion;
    private String _cargo;
    private String _genero;
    private int _id;
    
    
    public String getString()
    {
        return _nombres + " " + _apellidos;
    }
    
    
}
