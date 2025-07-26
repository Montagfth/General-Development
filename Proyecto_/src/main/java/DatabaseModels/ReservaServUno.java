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
public class ReservaServUno {
    
    private int ID_ReservaServUno;
    private int ID_Auto;
    private String Estado_ReservaServUno;
    private Timestamp Fecha_ReservaServUno;
    private String DNI_Cliente;
    
    public int getID_ReservaServUno() {
        return ID_ReservaServUno;
    }

    public void setID_ReservaServUno(int ID_ReservaServUno) {
        this.ID_ReservaServUno = ID_ReservaServUno;
    }

    public int getID_Auto() {
        return ID_Auto;
    }

    public void setID_Auto(int ID_Auto) {
        this.ID_Auto = ID_Auto;
    }

    public String getEstado_ReservaServUno() {
        return Estado_ReservaServUno;
    }

    public void setEstado_ReservaServUno(String Estado_ReservaServUno) {
        this.Estado_ReservaServUno = Estado_ReservaServUno;
    }

    public Timestamp getFecha_ReservaServUno() {
        return Fecha_ReservaServUno;
    }

    public void setFecha_ReservaServUno(Timestamp Fecha_ReservaServUno) {
        this.Fecha_ReservaServUno = Fecha_ReservaServUno;
    }

    public String getDNI_Cliente() {
        return DNI_Cliente;
    }

    public void setDNI_Cliente(String DNI_Cliente) {
        this.DNI_Cliente = DNI_Cliente;
    }
    
}
