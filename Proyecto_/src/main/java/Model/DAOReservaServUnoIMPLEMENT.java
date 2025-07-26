/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.ReservaServUno;
import DatabaseModels.Sesion;
import Interfaces.DAOReservaServUno;
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
public class DAOReservaServUnoIMPLEMENT extends Database implements DAOReservaServUno {

    @Override
    public void registrar(ReservaServUno rsu) throws Exception {
        try {
            this.Conectar();
            String sql = "insert into ReservaServUno(ID_Auto,DNI_Cliente) values (?,?)";
            PreparedStatement st = this.Conexion.prepareStatement(sql);
            st.setInt(1, rsu.getID_Auto());
            st.setString(2, Sesion.clienteLogueado.getDNI_Cliente());
            
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
    public List<ReservaServUno> listarReservaServUno() throws Exception {

        List<ReservaServUno> listaReservaServUno = new ArrayList<>();

        try {
            this.Conectar();
            PreparedStatement st = this.Conexion.prepareStatement("select * from ReservaServUno");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ReservaServUno rsu = new ReservaServUno();
                rsu.setID_ReservaServUno(rs.getInt("ID_ReservaServUno"));
                rsu.setID_Auto(rs.getInt("ID_Auto"));
                rsu.setDNI_Cliente(Sesion.clienteLogueado.getDNI_Cliente());
                rsu.setEstado_ReservaServUno(rs.getString("Estado_ReservaServUno"));
                rsu.setFecha_ReservaServUno(rs.getTimestamp("Fecha_ReservaServUno"));

                listaReservaServUno.add(rsu);
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
        return listaReservaServUno;
    }

    @Override
    public void modificarEstadoYFecha(int idReserva, String nuevoEstado, Date nuevaFecha) throws Exception {

        PreparedStatement ps = null;
        Connection cn = null;

        try {
            this.Conectar();
            cn = this.Conexion;
            String sql = "update ReservaServUno set Estado_ReservaServUno = ?, Fecha_ReservaServUno = ? where ID_ReservaServUno = ?";
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

    @Override
    public void eliminar(int idReserva) throws Exception {

        PreparedStatement st = null;

        try {
            this.Conectar();
            String sql = "delete from ReservaServUno where ID_ReservaServUno = ?";
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
}
