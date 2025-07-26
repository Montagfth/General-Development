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

    public static Cliente clienteLogueado;

    public static Administrador adminLogueado;

    public static void cerrarSesion() {
        clienteLogueado = null;
        adminLogueado = null;
    }

    public static boolean esAdmin() {
        return adminLogueado != null;
    }

    public static boolean esCliente() {
        return clienteLogueado != null;
    }
}
