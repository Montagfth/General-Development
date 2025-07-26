/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

/**
 *
 * @author Fabrizio
 */
public class Cliente {

    //Campos de captura de informacion: First Name, Second Name, Surname
    
    public int ID_Cliente;
    public String Nombre_Cliente;
    public String SegundoNombre_Cliente; //Agregados 08/06/25
    public String Apellido_Cliente; //Agregados 08/06/25
    public String DNI_Cliente;
    public String Correo_Cliente;
    public String Telefono_Cliente;
    public String SegundoTelefono_Cliente; //Agregados 08/06/25
    public byte [] fotoCliente;
    
    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getSegundoNombre_Cliente() {
        return SegundoNombre_Cliente;
    }

    public void setSegundoNombre_Cliente(String SegundoNombre_Cliente) {
        this.SegundoNombre_Cliente = SegundoNombre_Cliente;
    }

    public String getApellido_Cliente() {
        return Apellido_Cliente;
    }

    public void setApellido_Cliente(String Apellido_Cliente) {
        this.Apellido_Cliente = Apellido_Cliente;
    }

    public String getDNI_Cliente() {
        return DNI_Cliente;
    }

    public void setDNI_Cliente(String DNI_Cliente) {
        this.DNI_Cliente = DNI_Cliente;
    }

    public String getCorreo_Cliente() {
        return Correo_Cliente;
    }

    public void setCorreo_Cliente(String Correo_Cliente) {
        this.Correo_Cliente = Correo_Cliente;
    }

    public String getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(String Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public String getSegundoTelefono_Cliente() {
        return SegundoTelefono_Cliente;
    }

    public void setSegundoTelefono_Cliente(String SegundoTelefono_Cliente) {
        this.SegundoTelefono_Cliente = SegundoTelefono_Cliente;
    }

    public byte[] getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(byte[] fotoCliente) {
        this.fotoCliente = fotoCliente;
    }
    
}
