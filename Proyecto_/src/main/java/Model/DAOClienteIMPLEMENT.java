/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DatabaseModels.*;
import Interfaces.*;
import Database.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOClienteIMPLEMENT extends Database implements DAOCliente {

    //CASO DE USO 04:
    @Override
    public void registrar(Cliente cliente) throws Exception {
        //Insercion de usuarios/clientes:
        try {
            //Comunicacion con la base de datos:
            this.Conectar();
            PreparedStatement st = this.Conexion.prepareStatement(
                    "insert into cliente(ID_Cliente,"
                            + "Nombre_Cliente,"
                            + "SegundoNombre_Cliente,"
                            + "Apellido_Cliente,"
                            + "DNI_Cliente,"
                            + "Correo_Cliente,"
                            + "Telefono_Cliente,"
                            + "SegundoTelefono_Cliente) "
                            + "VALUES (?,?,?,?,?,?,?,?);");
            st.setInt(1, cliente.getID_Cliente());
            st.setString(2, cliente.getNombre_Cliente());
            st.setString(3, cliente.getSegundoNombre_Cliente());
            st.setString(4, cliente.getApellido_Cliente());
            st.setString(5, cliente.getDNI_Cliente());
            st.setString(6, cliente.getCorreo_Cliente());
            st.setString(7, cliente.getTelefono_Cliente());
            st.setString(8, cliente.getSegundoTelefono_Cliente());

            //Eejcutado y corte de la comunicacion con la base de datos:
            st.executeUpdate();
            st.close();

            System.out.println("Se ha registrado correctamente. Gracias");
        } catch (Exception e) {
            //throw e;
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
    }

    @Override
    public List<Cliente> listarCliente(String nombre) throws Exception {

        List<Cliente> listarCliente = null;

        try {
            this.Conectar();
            String Query = nombre.isEmpty() ? "select * from cliente" : "select * from Empleado where Nombre_Empleado like '%" + nombre + "%';";
            PreparedStatement st = this.Conexion.prepareStatement(Query);
            listarCliente = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setID_Cliente(rs.getInt("ID_Cliente"));
                cliente.setNombre_Cliente(rs.getString("Nombre_Cliente"));
                cliente.setSegundoNombre_Cliente(rs.getString("SegundoNombre_Cliente"));
                cliente.setApellido_Cliente(rs.getString("Apellido_Cliente"));
                cliente.setDNI_Cliente(rs.getString("DNI_Cliente"));
                cliente.setCorreo_Cliente(rs.getString("Correo_Cliente"));
                cliente.setTelefono_Cliente(rs.getString("Telefono_Cliente"));
                cliente.setSegundoTelefono_Cliente(rs.getString("SegundoTelefono_Cliente"));

                listarCliente.add(cliente);
            }
            rs.close();
            st.close();

            System.out.println("Se ha listado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return listarCliente;
    }

    //CASO DE USO 05:
    @Override
    public Cliente autenticarPorDNI(String dni) throws Exception {
        Cliente cliente = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // 1. Abrir la conexión
            this.Conectar();

            // 2. Preparar sentencia
            String sql = "SELECT * FROM cliente WHERE DNI_Cliente = ?";
            st = this.Conexion.prepareStatement(sql);
            st.setString(1, dni);

            // 3. Ejecutar y leer resultados
            rs = st.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setID_Cliente(rs.getInt("ID_Cliente"));
                cliente.setDNI_Cliente(rs.getString("DNI_Cliente"));
                cliente.setNombre_Cliente(rs.getString("Nombre_Cliente"));
                //Insercion de imagen para clientes:
                cliente.setFotoCliente(rs.getBytes("Foto_Cliente"));
                // … añade más setters si lo necesitas
            }

        } catch (Exception e) {
            // Propaga la excepción para que la capa superior pueda manejarla
            throw new Exception("Error al autenticar por DNI: " + e.getMessage(), e);

        } finally {
            // 4. Cerrar recursos en orden inverso
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            try {
                this.CerrarConexion();
            } catch (Exception ex) {
                /* log opcional */ }
        }

        return cliente;
    }

    @Override
    public void modificar(Cliente c) throws Exception {
        PreparedStatement ps = null;
        Connection cn = null;

        try {
            this.Conectar();
            cn = this.Conexion;

            String slq = "update cliente set Nombre_Cliente = ?,SegundoNombre_Cliente = ?,Apellido_Cliente = ?, DNI_Cliente = ?,Correo_Cliente = ?,Telefono_Cliente = ?,SegundoTelefono_Cliente = ? where ID_Cliente = ?";

            ps = cn.prepareStatement(slq);
            ps.setString(1, c.getNombre_Cliente());
            ps.setString(2, c.getSegundoNombre_Cliente());
            ps.setString(3, c.getApellido_Cliente());
            ps.setString(4, c.getDNI_Cliente());
            ps.setString(5, c.getCorreo_Cliente());
            ps.setString(6, c.getTelefono_Cliente()); //Analizar
            ps.setString(7, c.getSegundoTelefono_Cliente()); //Analizar
            ps.setInt(8, c.getID_Cliente());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    @Override
    public void eliminar(int idCliente) throws Exception {
        PreparedStatement ps = null;
        Connection cn = null;

        try {
            this.Conectar();
            cn = this.Conexion;
            String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }
}
