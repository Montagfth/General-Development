/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

import java.sql.Timestamp;

/**
 *
 * @author Fabrizio
 */
public class ReservaServDos {

    private int ID_ReservaServDos;
    private int ID_Autoparte;
    //private int ID_Cliente;
    private String DNI_Cliente;
    private String Estado_ReservaServDos;
    private Timestamp Fecha_ReservaServDos;

    public int getID_ReservaServDos() {
        return ID_ReservaServDos;
    }

    public void setID_ReservaServDos(int ID_ReservaServDos) {
        this.ID_ReservaServDos = ID_ReservaServDos;
    }

    public int getID_Autoparte() {
        return ID_Autoparte;
    }

    public void setID_Autoparte(int ID_Autoparte) {
        this.ID_Autoparte = ID_Autoparte;
    }
    /*
       public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
    */
 

    public String getEstado_ReservaServDos() {
        return Estado_ReservaServDos;
    }

    public void setEstado_ReservaServDos(String Estado_ReservaServDos) {
        this.Estado_ReservaServDos = Estado_ReservaServDos;
    }

    public Timestamp getFecha_ReservaServDos() {
        return Fecha_ReservaServDos;
    }

    public void setFecha_ReservaServDos(Timestamp Fecha_ReservaServDos) {
        this.Fecha_ReservaServDos = Fecha_ReservaServDos;
    }

    public String getDNI_Cliente() {
        return DNI_Cliente;
    }

    public void setDNI_Cliente(String DNI_Cliente) {
        this.DNI_Cliente = DNI_Cliente;
    }

    
}
