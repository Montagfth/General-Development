/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

/**
 *
 * @author Fabrizio
 */
public class Empleado {

    // ====================================================
    // ATRIBUTOS:
    // ====================================================
    private int ID_Empleado;
    private String Nombre_Empleado;
    private int DNI_Empleado;
    private int Telefono_Empleado;
    private String FechaContratacion_Empleado;
    private String Cargo_Empleado;
    private int Estado_Empleado;

    // ====================================================
    // METODOS DE MANIPULACION GLOBAL:
    // ====================================================
    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public String getNombre_Empleado() {
        return Nombre_Empleado;
    }

    public void setNombre_Empleado(String Nombre_Empleado) {
        this.Nombre_Empleado = Nombre_Empleado;
    }

    public int getDNI_Empleado() {
        return DNI_Empleado;
    }

    public void setDNI_Empleado(int DNI_Empleado) {
        this.DNI_Empleado = DNI_Empleado;
    }

    public int getTelefono_Empleado() {
        return Telefono_Empleado;
    }

    public void setTelefono_Empleado(int Telefono_Empleado) {
        this.Telefono_Empleado = Telefono_Empleado;
    }

    public String getFechaContratacion_Empleado() {
        return FechaContratacion_Empleado;
    }

    public void setFechaContratacion_Empleado(String FechaContratacion_Empleado) {
        this.FechaContratacion_Empleado = FechaContratacion_Empleado;
    }

    public String getCargo_Empleado() {
        return Cargo_Empleado;
    }

    public void setCargo_Empleado(String Cargo_Empleado) {
        this.Cargo_Empleado = Cargo_Empleado;
    }

    public int getEstado_Empleado() {
        return Estado_Empleado;
    }

    public void setEstado_Empleado(int Estado_Empleado) {
        this.Estado_Empleado = Estado_Empleado;
    }
}
