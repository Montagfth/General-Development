/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.ReservaServUno;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOReservaServUno {
    
    //Registro de operacion con el boton "Hacer una reserva" 
    public void registrar(ReservaServUno rsu) throws Exception;
    
    //Listado de las operaciones en el panel:
    List<ReservaServUno> listarReservaServUno() throws Exception;
    
    //Modicacion de 2 ultimas columnas mediante un jdialog
    public void modificarEstadoYFecha(int idReserva, String nuevoEstado, Date nuevaFecha) throws Exception;

    //Eliminacion de registro:
    public void eliminar(int idReserva) throws Exception;
}
