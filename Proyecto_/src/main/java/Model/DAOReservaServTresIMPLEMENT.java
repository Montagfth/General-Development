/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.ReservaServTres;
import Interfaces.DAOReservaServTres;
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
public class DAOReservaServTresIMPLEMENT extends Database implements DAOReservaServTres {

    //CASO DE USO 02:
    @Override
    public void registrar(ReservaServTres r) throws Exception {

        PreparedStatement ps = null;

        try {
            this.Conectar();
            String sql = """
                                     INSERT INTO ReservaServTres
                                     (TipoVehiculo, ServicioSolicitado, NumeroMotor, NumeroSerie, Kilometraje,
                                      MarcaVehiculo, ModeloVehiculo, AnioVehiculo, TipoMotor, Observacion,
                                      FechaCita, Precio, DNI_Cliente, DNI_Empleado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                         """;
            ps = this.Conexion.prepareStatement(sql);

            ps.setString(1, r.getTipoVehiculo());
            ps.setString(2, r.getServicioSolicitado());
            ps.setString(3, r.getNumeroMotor());
            ps.setString(4, r.getNumeroSerie());
            ps.setObject(5, r.getKilometraje());
            ps.setString(6, r.getMarcaVehiculo());
            ps.setString(7, r.getModeloVehiculo());
            ps.setObject(8, r.getAnioVehiculo());
            ps.setString(9, r.getTipoMotor());
            ps.setString(10, r.getObservacion());
            ps.setDate(11, Date.valueOf(r.getFechaCita()));
            ps.setBigDecimal(12, r.getPrecio());
            ps.setString(13, r.getDniCliente());
            ps.setString(14, r.getDniEmpleado());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            try {
                this.CerrarConexion();
            } catch (Exception ex) {
                /* log opcional */ }
        }
    }

    @Override
    public List<ReservaServTres> listarReservaServTres() throws Exception {

        List<ReservaServTres> listaReservServTres = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            this.Conectar();

            String sql = "select * from ReservaServTres order by ID_ReservaServTres desc";
            ps = this.Conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ReservaServTres r = new ReservaServTres();
                r.setIdReserva(rs.getInt("ID_ReservaServTres"));
                r.setTipoVehiculo(rs.getString("TipoVehiculo"));
                r.setServicioSolicitado(rs.getString("ServicioSolicitado"));
                r.setNumeroMotor(rs.getString("NumeroMotor"));
                r.setNumeroSerie(rs.getString("NumeroSerie"));
                r.setKilometraje((Integer) rs.getObject("Kilometraje"));
                r.setMarcaVehiculo(rs.getString("MarcaVehiculo"));
                r.setModeloVehiculo(rs.getString("ModeloVehiculo"));
                r.setAnioVehiculo((Integer) rs.getObject("AnioVehiculo"));
                r.setTipoMotor(rs.getString("TipoMotor"));
                r.setObservacion(rs.getString("Observacion"));
                r.setFechaCita(rs.getDate("FechaCita").toLocalDate());
                r.setPrecio(rs.getBigDecimal("Precio"));
                r.setDniCliente(rs.getString("DNI_Cliente"));
                r.setDniEmpleado(rs.getString("DNI_Empleado"));

                listaReservServTres.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            this.CerrarConexion();
        }

        return listaReservServTres;
    }

    @Override
    public void asignarEmpleado(int idReserva, String dniEmpleado) throws Exception {

        PreparedStatement ps = null;

        try {
            this.Conectar();

            String sql = "update ReservaServTres sset DNI_Empleado = ? where ID_ReservaServTres = ?";

            ps = this.Conexion.prepareStatement(sql);
            ps.setString(1, dniEmpleado);
            ps.setInt(2, idReserva);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            this.CerrarConexion();
        }
    }

    @Override
    public void modificarFecha(int idReserva, Date nuevaFecha) throws Exception {

        PreparedStatement ps = null;
        Connection cn = null;

        try {
            this.Conectar();
            cn = this.Conexion;

            String sql = "UPDATE ReservaServTres SET FechaCita = ? WHERE ID_ReservaServTres = ?";

            ps = cn.prepareStatement(sql);
            ps.setDate(1, nuevaFecha);
            ps.setInt(2, idReserva);

            ps.executeUpdate();
            System.out.println("ACtualizacion exitosa");

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

        PreparedStatement ps = null;
        Connection cn = null;

        try {
            this.Conectar();
            cn = this.Conexion;
            String sql = "DELETE FROM ReservaServTres WHERE ID_ReservaServTres = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idReserva);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.out.println("Error cerrando ps: " + e.getMessage());
            }
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error cerrando conexión: " + e.getMessage());
            }
        }

    }
}
