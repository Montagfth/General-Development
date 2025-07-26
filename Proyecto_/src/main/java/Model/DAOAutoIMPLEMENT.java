package Model;

import DatabaseModels.Auto;
import Interfaces.DAOAutos;
import java.util.List;
import Database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOAutoIMPLEMENT extends Database implements DAOAutos {

public Auto obtenerPorID(int id) throws Exception {
    Auto auto = null;
    String sql = "SELECT * FROM Auto WHERE ID_Auto = ?";

    this.Conectar();
    PreparedStatement st = this.Conexion.prepareStatement(sql);
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();

    if (rs.next()) {
        auto = new Auto();
        auto.setID_Auto(rs.getInt("ID_Auto"));
        auto.setMarca_Auto(rs.getString("Marca_Auto"));
        auto.setModelo_Auto(rs.getString("Modelo_Auto"));
        auto.setAnio_Auto(rs.getString("Anio_Auto"));
        auto.setPrecio_Auto(rs.getInt("Precio_Auto"));
        auto.setImagen_Auto(rs.getBytes("Imagen"));
    }

    rs.close();
    st.close();
    this.CerrarConexion();

    return auto;
}


    public List<Auto> Listar(String marca) throws Exception {

        List<Auto> listarAutos = null;

        try {
            this.Conectar();
            String Query = marca.isEmpty() ? "select * from Auto" : "select * from Auto where nombre like '%" + marca + "%';";
            PreparedStatement st = this.Conexion.prepareStatement(Query);
            listarAutos = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Auto autos = new Auto();

                autos.setID_Auto(rs.getInt("ID_Auto"));
                autos.setMarca_Auto(rs.getString("Marca_Auto"));
                autos.setModelo_Auto(rs.getString("Modelo_Auto"));
                autos.setAnio_Auto(rs.getString("Anio_Auto"));
                autos.setPrecio_Auto(rs.getInt("Precio_Auto"));

                autos.setImagen_Auto(rs.getBytes("Imagen"));

                listarAutos.add(autos);
            }

            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error al listar autos: " + e.getMessage());
        }
        return listarAutos;
    }

    @Override
    public List<Auto> listarFiltrado(String anio, String modelo, String rangoPrecio) throws Exception {
        
        List<Auto> lista = new ArrayList<>();
        
        List<String> condiciones = new ArrayList<>();
        
        if (anio != null && !anio.isBlank()) condiciones.add("Anio_Auto = ?");
        if (modelo != null && !modelo.isBlank()) condiciones.add("Modelo_Auto like ?");
        if (rangoPrecio != null && !rangoPrecio.isBlank()) {
            switch (rangoPrecio) {
                case "MENOS DE 15,000", "MENOS DE 15000" -> condiciones.add("Precio_Auto < 15000");
                case "15,000 - 25,000", "15000 - 25000" -> condiciones.add("Precio_Auto between 15000 and 25000");
                case "MAS DE 25,000", "MAS DE 25000" -> condiciones.add("Precio_Auto > 25000");
                
            }
        }
        
        String sql = "select * from Auto" + (condiciones.isEmpty() ? "" : " where " + String.join(" and ", condiciones));
        
        try {
            this.Conectar();
            PreparedStatement st = this.Conexion.prepareStatement(sql);
            
            int idx = 1;
            
            if (anio != null && !anio.isBlank()) st.setString(idx++, anio);
            if (modelo != null && !modelo.isBlank()) st.setString(idx++, "%" + modelo + "%");
            
            ResultSet rs = st.executeQuery();
            
        while (rs.next()){
            Auto a = new Auto();

            a.setID_Auto(rs.getInt("ID_Auto"));
            a.setMarca_Auto(rs.getString("Marca_Auto"));
            a.setModelo_Auto(rs.getString("Modelo_Auto"));
            a.setAnio_Auto(rs.getString("Anio_Auto"));
            a.setPrecio_Auto(rs.getInt("Precio_Auto"));

            a.setImagen_Auto(rs.getBytes("Imagen"));

            lista.add(a);
        }

                
            rs.close();
            st.close();
            this.CerrarConexion();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
