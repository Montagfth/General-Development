/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modificaciones;

import Interfaces.DAOEmpleado;
import Model.DAOEmpleadosIMPLEMENT;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Fabrizio
 */
public class DialogEditarEmpleado extends JDialog {

    private JTextField txtNombre, txtDni, txtTelefono;
    private JButton btnGuardar;
    private int idEmpleado;
    private DAOEmpleado daoe = new DAOEmpleadosIMPLEMENT();

    public DialogEditarEmpleado(JFrame parent, int id, String nombre, String dni, String telefono) {
        super(parent, "Editar Empleado", true);
        this.idEmpleado = id;
        initComponents(nombre, dni, telefono);
        setSize(400, 220);
        setLocationRelativeTo(parent);
    }

    private void initComponents(String nombre, String dni, String telefono) {
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblDni = new JLabel("DNI:");
        JLabel lblTelefono = new JLabel("Teléfono:");

        txtNombre = new JTextField(nombre);
        txtDni = new JTextField(dni);
        txtTelefono = new JTextField(telefono);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarCambios());

        setLayout(new GridLayout(4, 2, 10, 10));
        add(lblNombre);
        add(txtNombre);
        add(lblDni);
        add(txtDni);
        add(lblTelefono);
        add(txtTelefono);
        add(new JLabel());
        add(btnGuardar);
    }

    private void guardarCambios() {
        try {
            String nuevoNombre = txtNombre.getText().trim();
            String nuevoDni = txtDni.getText().trim();
            int nuevoTelefono = Integer.parseInt(txtTelefono.getText().trim());

            daoe.modificarEmpleado(idEmpleado, nuevoNombre, nuevoDni, nuevoTelefono);
            JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }
}
