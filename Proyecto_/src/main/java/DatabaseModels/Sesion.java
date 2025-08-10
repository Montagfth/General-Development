/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

/**
 *
 * @author Fabrizio
 */
public class Sesion {

    // ==========================================
    // INICIALIZACION DE VARIABLES DE ACCESO
    // ==========================================
    public static Cliente clienteLogueado = null;
    public static Administrador adminLogueado = null;

    // =======================================================
    // AUTENTICACION DE ADMINISTRADORES | PERSONAL | CLIENTES
    // =======================================================
    public static boolean esAdmin() {
        return adminLogueado != null;
    }

    public static boolean esCliente() {
        return clienteLogueado != null;
    }

    public static void cerrarSesion() {
        clienteLogueado = null;
        adminLogueado = null;
    }
}
