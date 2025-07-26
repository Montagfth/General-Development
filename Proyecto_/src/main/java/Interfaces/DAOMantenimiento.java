/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.Mantenimiento;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOMantenimiento {
    
    //Registro de mantenimiento relacionado con el boton CONTINUAR
    public void Registrar(Mantenimiento mantenimiento) throws Exception;
    
    //Listado de los registros de mantenimientos en existencia:
    public List<Mantenimiento> listarMantenimiento() throws Exception;
}
