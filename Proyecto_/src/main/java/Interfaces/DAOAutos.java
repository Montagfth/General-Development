package Interfaces;

import DatabaseModels.Auto;
import java.util.List;

public interface DAOAutos {
    
    //Para el listado de los autos
    public List<Auto> Listar(String marca) throws Exception;
    
    //Filtrado dinamico de autos:
    public List<Auto> listarFiltrado (String anio, String modelo, String rangoPrecio) throws Exception;

    Auto obtenerPorID(int id) throws Exception;

}
