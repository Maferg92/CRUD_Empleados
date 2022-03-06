/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.javafx101;
import java.util.ArrayList;
import com.pmp.dao.Empleado;

/**
 *
 * @author FernandaGonzalez
 */
public class EmpleadosAdapterFactory {
    
    public static ArrayList<EmpleadoAdapter> getFromEmpleadoArrayList(ArrayList <Empleado> empleados)
    {
        ArrayList<EmpleadoAdapter> empleadoAdapters= new ArrayList();
        empleados.forEach((empleado) -> empleadoAdapters.add(new EmpleadoAdapter(empleado)));
        return empleadoAdapters;
    }
}
