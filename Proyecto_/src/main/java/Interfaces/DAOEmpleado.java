/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.Empleado;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOEmpleado {
    
    //Listado de empleados predeterminados:
    public List<Empleado> listarEmpleado (String nombreEmpleado) throws Exception;
    
    //Modificacion de datos:
    public void modificarEmpleado (int idEmpleado, String nuevoNombre, String nuevoDni, int nuevoTelefono) throws Exception;
    
    //Eliminacion del empleado:
    public void eliminarEmpleado(int idEmpleado) throws Exception;
    
    //Asignacion dinamica de empleado:
    public String obtenerDNIEmpleadoAleatorio() throws Exception;
    
    //Bloqueo de empleado selecciona
    public void bloquearEmpleadoPorDNI(String dniEmpleado) throws Exception;
    
    //Liberacion de empleado tras eliminacion:
    public void liberarEmpleadoPorDNI(String dniEmpleado) throws Exception;
}
