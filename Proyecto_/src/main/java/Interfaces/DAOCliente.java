/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.*;
import java.util.List;


/**
 *
 * @author Fabrizio
 */
public interface DAOCliente {
    
    //Registro de clientes: 
    public void registrar(Cliente cliente) throws Exception;
    
    //Listado de clientes registrados:
    public List<Cliente> listarCliente (String nombre) throws Exception;
    
    //Parametrizacion de credenciales:
    public Cliente autenticarPorDNI(String dni) throws Exception;
    
    //Modificacion de datos
    public void modificar(Cliente c) throws Exception;
    
    //Eliminacion de cliente
    public void eliminar (int idCliente) throws Exception;
    
}
