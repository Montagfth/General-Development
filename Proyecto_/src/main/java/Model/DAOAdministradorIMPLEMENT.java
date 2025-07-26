
package Model;

import Database.Database;
import DatabaseModels.Administrador;
import Interfaces.DAOAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOAdministradorIMPLEMENT extends Database implements DAOAdministrador {

@Override
public Administrador buscarAdministradorPorDNI(String dni) throws Exception {

    Administrador admin = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        this.Conectar();
        String sql = "SELECT * FROM Administrador WHERE TRIM(DNI_Admin) = ?";
        st = this.Conexion.prepareStatement(sql);
        st.setString(1, dni.trim());
        
        rs = st.executeQuery();
        
        if (rs.next()) {
            admin = new Administrador();
            admin.setId(rs.getInt("ID_Admin"));
            admin.setNombre(rs.getString("Nombre_Admin"));
            admin.setCorreo(rs.getString("Correo_Admin"));
            admin.setDni(rs.getString("DNI_Admin"));
            admin.setFoto(rs.getBytes("Foto_Admin")); // 👈 AQUI se carga la imagen BLOB
        }
        
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            this.CerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return admin;
}

}
