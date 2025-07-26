/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modificaciones;

import Interfaces.DAOReservaServUno;
import Model.DAOReservaServUnoIMPLEMENT;
import java.awt.GridLayout;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Fabrizio
 */
public class DialogEditarReservaAuto extends JDialog {
    private JComboBox<String> comboEstado;
    private JTextField txtFecha;
    private JButton btnGuardar;

    private int idReserva; // clave primaria
    private DAOReservaServUno dao = new DAOReservaServUnoIMPLEMENT();

    public DialogEditarReservaAuto(JFrame parent, int idReservaActual, String estadoActual, String fechaActual) {
        super(parent, "Modificar Reserva", true);
        this.idReserva = idReservaActual;
        initComponents(estadoActual, fechaActual);
        setSize(400, 200);
        setLocationRelativeTo(parent);
    }

    private void initComponents(String estadoActual, String fechaActual) {
        JLabel lblEstado = new JLabel("Nuevo Estado:");
        JLabel lblFecha = new JLabel("Nueva Fecha (YYYY-MM-DD):");

        comboEstado = new JComboBox<>(new String[]{"PENDIENTE", "EN PROCESO", "TERMINADO"});
        comboEstado.setSelectedItem(estadoActual);

        txtFecha = new JTextField(fechaActual);

        btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.addActionListener(e -> guardarCambios());

        setLayout(new GridLayout(3, 2, 10, 10));
        add(lblEstado); add(comboEstado);
        add(lblFecha); add(txtFecha);
        add(new JLabel()); add(btnGuardar);
    }

    private void guardarCambios() {
        try {
            String nuevoEstado = comboEstado.getSelectedItem().toString();
            Date nuevaFecha = Date.valueOf(txtFecha.getText().trim()); // formato: yyyy-MM-dd
            dao.modificarEstadoYFecha(idReserva, nuevoEstado, nuevaFecha);
            JOptionPane.showMessageDialog(this, "Reserva actualizada con éxito.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar cambios: " + ex.getMessage());
        }
    }
}
