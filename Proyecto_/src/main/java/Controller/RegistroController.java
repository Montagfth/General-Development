/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatabaseModels.Cliente;
import Interfaces.DAOCliente;
import Model.DAOClienteIMPLEMENT;
import Panels.panelRegistro;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabrizio
 */
public class RegistroController {

    // =============================================
    // INCIALIZACION DE VARIABLES DE MANIPULACION:
    // =============================================
    private panelRegistro panel;

    // =============================================
    // CONSTRUCTOR PARAMETRIZADO:
    // =============================================
    public RegistroController(panelRegistro panel) {
        this.panel = panel;
    }

    // =============================================
    // PROGRAMACION DE FUNCIONALIDADES:
    // =============================================
    // BOTON 01 | REGISTRO DE CLIENTE:
    public void registrarCliente() {
        // Registro de usuario-cliente:
        String primerNombre = panel.getJTFPrimerNombre().getText().trim();
        String segundoNombre = panel.getJTFSegundoNombre().getText().trim();
        String apellido = panel.getJTFApellido().getText().trim();
        String identificacionDNI = panel.getJTFIdentificacionDNI().getText().trim();
        String email = panel.getJTFEmail().getText().trim();
        String primerTelefono = panel.getJTFNumeroPrincipal().getText().trim();
        String segundoTelefono = panel.getJTFNumeroSecundario().getText().trim();

        // Validación mejorada de campos vacíos
        if (identificacionDNI.trim().isEmpty() 
                || primerNombre.trim().isEmpty()
                || segundoNombre.trim().isEmpty() 
                || apellido.trim().isEmpty()
                || email.trim().isEmpty() 
                || primerTelefono.trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, asegúrese de que todos los campos obligatorios estén completos.",
                    "Tesla",
                    JOptionPane.WARNING_MESSAGE);
            panel.getJTFPrimerNombre().requestFocus();
            return;
        }

        // 2. Validación específica de DNI
        if (!identificacionDNI.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(
                    null,
                    "La credencial debe contener exactamente 9 dígitos numéricos.",
                    "Tesla",
                    JOptionPane.WARNING_MESSAGE);
            panel.getJTFIdentificacionDNI().requestFocus();
            return;
        }

        // 3. Validación de email
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un correo electrónico válido.",
                    "Tesla",
                    JOptionPane.WARNING_MESSAGE);
            panel.getJTFEmail().requestFocus();
            return;
        }

        // 4. Validación de teléfonos
        if (!primerTelefono.matches("\\d{7,15}")) {
            JOptionPane.showMessageDialog(
                    null,
                    "El número de teléfono principal debe contener entre 7 y 15 dígitos.", 
                    "Tesla", 
                    JOptionPane.WARNING_MESSAGE);
            panel.getJTFNumeroPrincipal().requestFocus();
            return;
        }

        if (!segundoTelefono.isEmpty() && !segundoTelefono.matches("\\d{7,15}")) {
            JOptionPane.showMessageDialog(
                    null,
                    "El número de teléfono secundario debe contener entre 7 y 15 dígitos (si se proporciona).", 
                    "Tesla", 
                    JOptionPane.WARNING_MESSAGE);
            panel.getJTFNumeroSecundario().requestFocus();
            return;
        }
        // ====

        try {
            Cliente cliente = new Cliente();
            cliente.setDNI_Cliente(identificacionDNI);
            cliente.setNombre_Cliente(primerNombre);
            cliente.setSegundoNombre_Cliente(segundoNombre);
            cliente.setApellido_Cliente(apellido);
            cliente.setCorreo_Cliente(email);
            cliente.setTelefono_Cliente(primerTelefono);
            cliente.setSegundoTelefono_Cliente(segundoTelefono);

            DAOCliente daoCl = new DAOClienteIMPLEMENT();
            daoCl.registrar(cliente);

            System.out.println("Se ha registrado correctamente.");

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(
                    null,
                    "¡Registro exitoso! Bienvenido " + primerNombre + ".",
                    "Tesla",
                    JOptionPane.INFORMATION_MESSAGE);
            // Limpiar campos después del registro exitoso
            panel.limpiezaCampos();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(
                    null,
                    "Error al registrar el usuario: " + e.getMessage(),
                    "Tesla",
                    JOptionPane.ERROR_MESSAGE);
        }

        // IMPORTANTE: No crear nueva ventana aquí, usar el sistema de paneles
        // ventanaPrincipal Ventana_Principal = new ventanaPrincipal();
        // Ventana_Principal.setVisible(true);
    }

}
