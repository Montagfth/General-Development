package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabrizio
 */
public class Database {

    protected Connection Conexion;
    //NOTA: Buscar el JDBC correspondiente para su implementacion en el campo:
    private final String JDBCDriver = "com.mysql.jdbc.Driver"; //com.mysql.jdbc.Driver
    private final String URL = "jdbc:mysql://localhost:3306/basededatosiiproyecto"; // jdbc:mysql://localhost:3306/basededatosiiproyecto

    private final String Usuario = "root";
    private final String Contraseña = "123456";

    public void Conectar() throws ClassNotFoundException {
        
        try {
            Conexion = DriverManager.getConnection(URL, Usuario, Contraseña);
            Class.forName(JDBCDriver);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CerrarConexion() throws SQLException {
        if (Conexion != null) {
            if (!Conexion.isClosed()) {
                Conexion.close();
            }
        }
    }
}
