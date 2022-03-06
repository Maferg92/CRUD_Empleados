/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author FernandaGonzalez
 */
public class Empleados {
    /*private String _nombres;
    private String _apellidos;
    private String _email;
    private String _telefono;
    private String _direccion;
    private String _cargo;
    private String _genero;
    */
    private Connection _conexion = null;
    
    public Empleados(){
        _conexion=Conexion.getConexion();
        String sqlCreateTable= "CREATE TABLE IF NOT EXISTS empleados"
               + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
               + " nombres TEXT NOT NULL,"
               + " apellidos TEXT NOT NULL,"
               + " email TEXT NOT NULL,"
               + " telefono TEXT NOT NULL,"
               + " direccion TEXT NOT NULL,"
               + " cargo TEXT NOT NULL,"
               + " genero TEXT NOT NULL,";
        
        try{
            Statement comando=_conexion.createStatement();
            int resultado=comando.executeUpdate(sqlCreateTable);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Empleado> obtenerEmpleados()
    {
        try{
            ArrayList empleados = new ArrayList<Empleado>();
        Statement comandoSQL = _conexion.createStatement();
        ResultSet registroEnTabla = comandoSQL.executeQuery("Select *from productos;");
        
        while (registroEnTabla.next())
        {
            Empleado empleado = new Empleado();
            empleado.setId(registroEnTabla.getInt("id"));
            empleado.setNombres(registroEnTabla.getString("nombres"));
            empleado.setApellidos(registroEnTabla.getString("apellidos"));
            empleado.setEmail(registroEnTabla.getString("email"));
            empleado.setDireccion(registroEnTabla.getString("telefono"));
            empleado.setDireccion(registroEnTabla.getString("direccion"));
            empleado.setCargo(registroEnTabla.getString("cargo"));
            empleado.setGenero(registroEnTabla.getString("genero"));
              
              empleados.add(empleado);
        }
         return empleados;
            
        }
        catch (Exception ex)
        {
           System.err.println(ex.getMessage());
           return new ArrayList<Empleado>();            
        }
        
    }
    
    
    public Empleado obtenerEmpleado(int id)
    {
        try{
         
        PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM empleados where id=?;");
        comandoSQL.setInt(1,id);
        ResultSet registroEnTabla = comandoSQL.executeQuery();
        Empleado empleado = new Empleado();
        while (registroEnTabla.next())
        {
           
           
            empleado.setId(registroEnTabla.getInt("id"));
            empleado.setNombres(registroEnTabla.getString("nombres"));
            empleado.setApellidos(registroEnTabla.getString("apellidos"));
            empleado.setEmail(registroEnTabla.getString("email"));
            empleado.setDireccion(registroEnTabla.getString("telefono"));
            empleado.setDireccion(registroEnTabla.getString("direccion"));
            empleado.setCargo(registroEnTabla.getString("cargo"));
            empleado.setGenero(registroEnTabla.getString("genero"));
              
             break; 
             
        }
         return empleado;
            
        }
        catch (Exception ex)
        {
           System.err.println(ex.getMessage());
           return null;            
        }
        
    }
    
    
    public int agregarEmpleado(Empleado nuevoEmpleado)
    {
        try
        {
            String insertSql = "INSERT INTO empleados(nombres, apellidos, email,telefono, direccion, cargo) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement comandoSQL = _conexion.prepareStatement(insertSql);
            comandoSQL.setString(1, nuevoEmpleado.getNombres());
            comandoSQL.setString(2, nuevoEmpleado.getApellidos());
            comandoSQL.setString(3, nuevoEmpleado.getEmail());
            comandoSQL.setString (4, nuevoEmpleado.getTelefono());
            comandoSQL.setString (5, nuevoEmpleado.getDireccion());
            comandoSQL.setString (6, nuevoEmpleado.getCargo());
            
            int RegistroAfectado = comandoSQL.executeUpdate(); //ejecuta la actualizacion en la BD
            comandoSQL.close(); // para que no se acumule memoria (derroche de memoria)
            return RegistroAfectado; // va a devolver cuantos registros fueron afectados
        }   
        catch (Exception ex)
        {
           System.err.println(ex.getMessage());
           return 0;         
        }
    }
    
    public int actualizarEmpleado(Empleado updateEmpleado)
    {
        try
        {
            String updateSql = "UPDATE empleados SET nombres=?,apellidos=?,email=?,telefono=?,direccion=?,cargo=? where id=?"; //? es un parametro
            PreparedStatement comandoSQL = _conexion.prepareStatement(updateSql);
           comandoSQL.setString(1, updateEmpleado.getNombres());
            comandoSQL.setString(2, updateEmpleado.getApellidos());
            comandoSQL.setString(3, updateEmpleado.getEmail());
            comandoSQL.setString (4, updateEmpleado.getTelefono());
            comandoSQL.setString (5, updateEmpleado.getDireccion());
            comandoSQL.setString (6, updateEmpleado.getCargo());
            comandoSQL.setInt(6, updateEmpleado.getId());
            
            int RegistroAfectado = comandoSQL.executeUpdate(); //ejecuta la actualizacion en la BD
            comandoSQL.close(); // para que no se acumule memoria (derroche de memoria)
            return RegistroAfectado; // va a devolver cuantos registros fueron afectados
        }   
        catch (Exception ex)
        {
           System.err.println(ex.getMessage());
           return 0;         
        }
    }
    
    
    public int EliminarEmpleado(Empleado deleteEmpleado)
    {
        try
        {
            String deleteSql = "DELETE FROM empleados where id=?"; //? es un parametro
            PreparedStatement comandoSQL = _conexion.prepareStatement(deleteSql);
            comandoSQL.setInt(1, deleteEmpleado.getId());
            
            int RegistroAfectado = comandoSQL.executeUpdate(); //ejecuta la actualizacion en la BD
            comandoSQL.close(); // para que no se acumule memoria (derroche de memoria)
            return RegistroAfectado; // va a devolver cuantos registros fueron afectados
        }   
        catch (Exception ex)
        {
           System.err.println(ex.getMessage());
           return 0;         
        }
    }
    
    
}
