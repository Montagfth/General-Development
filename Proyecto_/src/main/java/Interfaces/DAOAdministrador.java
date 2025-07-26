package Interfaces;

import DatabaseModels.Administrador;

public interface DAOAdministrador {

    public Administrador buscarAdministradorPorDNI(String dni) throws Exception;
}
