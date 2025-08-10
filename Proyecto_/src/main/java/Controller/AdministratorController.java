package Controller;

import Administrative.panelAdministrator;
import DatabaseModels.Cliente;
import DatabaseModels.Sesion;
import Interfaces.DAOCliente;
import Interfaces.DAOEmpleado;
import Interfaces.DAOReservaServDos;
import Interfaces.DAOReservaServTres;
import Interfaces.DAOReservaServUno;
import Model.DAOClienteIMPLEMENT;
import Model.DAOEmpleadosIMPLEMENT;
import Model.DAOReservaServDosIMPLEMENT;
import Model.DAOReservaServTresIMPLEMENT;
import Model.DAOReservaServUnoIMPLEMENT;
import Modificaciones.DialogEditarCliente;
import Modificaciones.DialogEditarEmpleado;
import Modificaciones.DialogEditarReservaAuto;
import Modificaciones.DialogEditarReservaAutoparte;
import Modificaciones.DialogEditarReservaServMantenimiento;
import View.loginPrototipo;
import javax.swing.JOptionPane;
import java.awt.Window;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Fabrizio
 */
public class AdministratorController {

    private final panelAdministrator Administrator_Window;
    
    //Llamado a la clase que contiene el componente:
    public AdministratorController(panelAdministrator Administrator_Window) {
        this.Administrator_Window = Administrator_Window;
    }

    //Programacion de comportamientos:
    //Boton 01 | MODIFICACION DE REGISTRO/FILA
    public void modificarRegistro() {
        //Llamada a los metodos publicos en el JPanel:
        int selectedIndex = Administrator_Window.getSelectedTabIndex();
        javax.swing.JTable tablaActiva = Administrator_Window.getTablaActiva();

        if (tablaActiva == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay tabla seleccionada",
                    "Tesla Inc.",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = tablaActiva.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, seleccione una fila",
                    "Tesla Inc.",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            switch (selectedIndex) {
                case 0: { // AUTOS
                    int idReservaAuto = (int) tablaActiva.getValueAt(fila, 0);
                    String estadoActualAuto = tablaActiva.getValueAt(fila, 3).toString();
                    String fechaActualAuto = tablaActiva.getValueAt(fila, 4).toString();

                    DialogEditarReservaAuto dialogAuto = new DialogEditarReservaAuto(
                            null,
                            idReservaAuto,
                            estadoActualAuto,
                            fechaActualAuto);

                    dialogAuto.setVisible(true);
                    Administrator_Window.cargarServicio01Ops();
                    break;
                }
                case 1: { // AUTOPARTES
                    int idReservaAutoparte = (int) tablaActiva.getValueAt(fila, 0);
                    String estadoActualAutoparte = tablaActiva.getValueAt(fila, 3).toString();
                    String fechaActualAutoparte = tablaActiva.getValueAt(fila, 4).toString();

                    DialogEditarReservaAutoparte dialogAutoparte = new DialogEditarReservaAutoparte(
                            null,
                            idReservaAutoparte,
                            estadoActualAutoparte,
                            fechaActualAutoparte);

                    dialogAutoparte.setVisible(true);
                    Administrator_Window.cargarServicio02Ops();
                    break;
                }
                case 2: { // MANTENIMIENTO
                    int idReservaMantenimiento = (int) tablaActiva.getValueAt(fila, 0);
                    String fechaActualMantenimiento = tablaActiva.getValueAt(fila, 4).toString();

                    DialogEditarReservaServMantenimiento dialogMantenimiento = new DialogEditarReservaServMantenimiento(
                            null,
                            idReservaMantenimiento,
                            fechaActualMantenimiento);

                    dialogMantenimiento.setVisible(true);
                    Administrator_Window.cargarServicio03Ops();
                    break;
                }
                case 3: { // EMPLEADOS
                    int idEmpleado = (int) tablaActiva.getValueAt(fila, 0);
                    String nombreEmpleado = tablaActiva.getValueAt(fila, 1).toString();
                    String dniEmpleado = tablaActiva.getValueAt(fila, 2).toString();
                    String telefonoEmpleado = tablaActiva.getValueAt(fila, 3).toString();

                    DialogEditarEmpleado dialogEmpleado = new DialogEditarEmpleado(
                            null,
                            idEmpleado,
                            nombreEmpleado,
                            dniEmpleado,
                            telefonoEmpleado);

                    dialogEmpleado.setVisible(true);
                    Administrator_Window.cargarEmpleados();
                    break;
                }
                case 4: { // CLIENTES
                    Cliente cliente = new Cliente();
                    cliente.setID_Cliente((int) tablaActiva.getValueAt(fila, 0));
                    cliente.setNombre_Cliente(tablaActiva.getValueAt(fila, 1).toString());
                    cliente.setSegundoNombre_Cliente(tablaActiva.getValueAt(fila, 2).toString());
                    cliente.setApellido_Cliente(tablaActiva.getValueAt(fila, 3).toString());
                    cliente.setDNI_Cliente(tablaActiva.getValueAt(fila, 4).toString());
                    cliente.setCorreo_Cliente(tablaActiva.getValueAt(fila, 5).toString());
                    cliente.setTelefono_Cliente(tablaActiva.getValueAt(fila, 6).toString());
                    cliente.setSegundoTelefono_Cliente(tablaActiva.getValueAt(fila, 7).toString());

                    DialogEditarCliente dialogCliente = new DialogEditarCliente(null, cliente);
                    dialogCliente.setVisible(true);
                    Administrator_Window.cargarClientes();
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "No se reconoce la pestaña activa",
                            "Tesla Inc.",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al modificar: " + e.getMessage(),
                    "Tesla Inc.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Boton 02 | ELIMINACION DE REGISTRO/FILA
    public void eliminarRegistro() {
        int selectedIndex = Administrator_Window.getSelectedTabIndex();
        javax.swing.JTable tablaActiva = Administrator_Window.getTablaActiva();

        if (tablaActiva == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay tabla seleccionada",
                    "Tesla Inc.",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = tablaActiva.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, seleccione una fila",
                    "Tesla Inc.",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar el registro?",
                "Tesla Inc.",
                JOptionPane.YES_NO_OPTION);

        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int idRegistro = (int) tablaActiva.getValueAt(fila, 0);

            switch (selectedIndex) {
                case 0: // AUTOS
                    DAOReservaServUno daoRsU = new DAOReservaServUnoIMPLEMENT();
                    daoRsU.eliminar(idRegistro);
                    Administrator_Window.cargarServicio01Ops();
                    break;
                case 1: // AUTOPARTES
                    DAOReservaServDos daoRsD = new DAOReservaServDosIMPLEMENT();
                    daoRsD.eliminar(idRegistro);
                    Administrator_Window.cargarServicio02Ops();
                    break;
                case 2: // MANTENIMIENTO
                    //Liberacion del empleado
                    String dniEmpleado = tablaActiva.getValueAt(fila, 2).toString().trim();
                    DAOEmpleado daoEmpl = new DAOEmpleadosIMPLEMENT();
                    daoEmpl.liberarEmpleadoPorDNI(dniEmpleado);

                    //Eliminacion del registro | reserva de mantenimiento
                    DAOReservaServTres daoRsT = new DAOReservaServTresIMPLEMENT();
                    daoRsT.eliminar(idRegistro);
                    Administrator_Window.cargarServicio03Ops();
                    break;
                case 3: // EMPLEADOS
                    DAOEmpleado daoEmp = new DAOEmpleadosIMPLEMENT();
                    daoEmp.eliminarEmpleado(idRegistro);
                    Administrator_Window.cargarEmpleados();
                    break;
                case 4: // CLIENTES
                    DAOCliente daoCli = new DAOClienteIMPLEMENT();
                    daoCli.eliminar(idRegistro);
                    Administrator_Window.cargarClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "No se reconoce la pestaña activa",
                            "Tesla Inc.",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Se ha eliminado correctamente",
                    "Tesla Inc.",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al eliminar: " + e.getMessage(),
                    "Tesla Inc.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //Boton 03 | CIERRE DE SESION (ADMINISTRADOR |  CLIENTE)
    public void cerrarSesion() {

        int response = JOptionPane.showConfirmDialog(
                null,
                "¿Esta seguro de salir de su sesion?",
                "Tesla Inc.",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Cierre de sesion:
            Sesion.cerrarSesion();
            // Mostrado de ventanas:
            loginPrototipo Ventana_Login = new loginPrototipo();
            Ventana_Login.setVisible(true);
            
            Window parentFrame = javax.swing.SwingUtilities.getWindowAncestor(Administrator_Window);
            //Ventana_Login.setVisible(false);
            //Ventana_Login.dispose();
            if (parentFrame != null) {
                parentFrame.dispose();
            }
        } else {
            // OPCION : "NO" | No se programa.
        }
    }
}
