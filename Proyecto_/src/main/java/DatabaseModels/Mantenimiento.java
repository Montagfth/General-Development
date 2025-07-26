/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

/**
 *
 * @author Fabrizio
 */
public class Mantenimiento {
    
    private int ID_Mantenimiento;
    private int ID_Auto;
    private int ID_Empleado;
    private String Fecha_Mantenimiento;
    private String Descripcion_Mantenimiento;
    private int Costo_Mantenimiento;

    public int getID_Mantenimiento() {
        return ID_Mantenimiento;
    }

    public void setID_Mantenimiento(int ID_Mantenimiento) {
        this.ID_Mantenimiento = ID_Mantenimiento;
    }

    public int getID_Auto() {
        return ID_Auto;
    }

    public void setID_Auto(int ID_Auto) {
        this.ID_Auto = ID_Auto;
    }

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public String getFecha_Mantenimiento() {
        return Fecha_Mantenimiento;
    }

    public void setFecha_Mantenimiento(String Fecha_Mantenimiento) {
        this.Fecha_Mantenimiento = Fecha_Mantenimiento;
    }

    public String getDescripcion_Mantenimiento() {
        return Descripcion_Mantenimiento;
    }

    public void setDescripcion_Mantenimiento(String Descripcion_Mantenimiento) {
        this.Descripcion_Mantenimiento = Descripcion_Mantenimiento;
    }

    public int getCosto_Mantenimiento() {
        return Costo_Mantenimiento;
    }

    public void setCosto_Mantenimiento(int Costo_Mantenimiento) {
        this.Costo_Mantenimiento = Costo_Mantenimiento;
    }
    
}
