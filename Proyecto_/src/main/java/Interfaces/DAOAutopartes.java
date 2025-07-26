/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.Autopartes;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOAutopartes {
    
    //Listado de productos - autopartes:
    public List<Autopartes> Listar (String categoria) throws Exception;
    
    //Metodo abstracto de decremento de stock:
    public boolean disminuirStock(int idAutoparte) throws Exception;
}
