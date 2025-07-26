/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.ReservaServDos;
import Interfaces.DAOReservaServDos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOReservaServDosIMPLEMENT extends Database implements DAOReservaServDos {

    @Override
    public void registrar(ReservaServDos rsd) throws Exception {
        try {
            this.Conectar();
            String sql = "insert into ReservaServDos(ID_Autoparte,DNI_Cliente) values (?,?)";
            PreparedStatement st = this.Conexion.prepareStatement(sql);
            st.setInt(1, rsd.getID_Autoparte());
            st.setString(2, rsd.getDNI_Cliente());
            st.executeUpdate();
            st.close();

            System.out.println("Se ha registrado correctamente la operacion.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
    }

    @Override
    public List<ReservaServDos> listarReservasServDos() throws Exception {

        List<ReservaServDos> listaReservaServDos = new ArrayList<>();

        try {
            this.Conectar();
            PreparedStatement st = this.Conexion.prepareStatement("select * from ReservaServDos");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ReservaServDos rsd = new ReservaServDos();
                rsd.setID_ReservaServDos(rs.getInt("ID_ReservaServDos"));
                rsd.setID_Autoparte(rs.getInt("ID_Autoparte"));
                rsd.setDNI_Cliente(rs.getString("DNI_Cliente"));
                rsd.setEstado_ReservaServDos(rs.getString("Estado_ReservaServDos"));
                rsd.setFecha_ReservaServDos(rs.getTimestamp("Fecha_ReservaServDos"));

                listaReservaServDos.add(rsd);
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
        return listaReservaServDos;
    }

    @Override
    public void eliminar(int idReserva) throws Exception {
        PreparedStatement st = null;

        try {
            this.Conectar();
            String sql = "delete from ReservaServDos where ID_ReservaServDos = ?";
            st = this.Conexion.prepareStatement(sql);
            st.setInt(1, idReserva);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (this.Conexion != null) {
                    this.Conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }

    //CASO DE USO 01:
    @Override
    public void modificarEstadoYFecha(int idReserva, String nuevoEstado, Date nuevaFecha) throws Exception {

        PreparedStatement ps = null;
        Connection cn = null;

        try {
            this.Conectar();
            cn = this.Conexion;
            String sql = "update ReservaServDos set Estado_ReservaServDos = ?, Fecha_ReservaServDos = ? where ID_ReservaServDos = ?";
            ps = cn.prepareStatement(sql);

            ps.setString(1, nuevoEstado);
            ps.setDate(2, nuevaFecha);
            ps.setInt(3, idReserva);

            ps.executeUpdate();
            System.out.println("Actualizacion exitosa.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar PreparedStatement: " + ex.getMessage());
            }
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }

    }
}
