/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.Mantenimiento;
import Interfaces.DAOMantenimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOMantenimientoIMPLEMENT extends Database implements DAOMantenimiento {

    @Override
    public void Registrar(Mantenimiento mantenimiento) throws Exception {
        try {
            this.Conectar();
            String sql = "insert into Mantenimiento (ID_Auto,ID_Empleado,Fecha_Mantenimiento,Descripcion_Mantenimiento,Costo_Mantenimiento) values (?,?,?,?,?)";
            PreparedStatement st = this.Conexion.prepareStatement(sql);

            st.setInt(1, mantenimiento.getID_Auto());
            st.setInt(2, mantenimiento.getID_Empleado());
            st.setString(3, mantenimiento.getDescripcion_Mantenimiento());
            st.setInt(4, mantenimiento.getCosto_Mantenimiento());

            st.executeUpdate();
            st.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
    }

    @Override
    public List<Mantenimiento> listarMantenimiento() throws Exception {

        List<Mantenimiento> listaMantenimiento = new ArrayList<>();

        try {
            this.Conectar();
            String sql = "select * from Mantenimento";
            PreparedStatement st = this.Conexion.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Mantenimiento mantenimiento = new Mantenimiento();
                mantenimiento.setID_Mantenimiento(rs.getInt("ID_Mantenimiento"));
                mantenimiento.setID_Auto(rs.getInt("ID_Auto"));
                mantenimiento.setID_Empleado(rs.getInt("ID_Empleado"));
                mantenimiento.setFecha_Mantenimiento(rs.getString("Fecha_Mantenimiento"));
                mantenimiento.setDescripcion_Mantenimiento(rs.getString("Descripcion_Mantenimiento"));
                mantenimiento.setCosto_Mantenimiento(rs.getInt("Costo_Mantenimiento"));

                listaMantenimiento.add(mantenimiento);

            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
        return listaMantenimiento;
    }
}
