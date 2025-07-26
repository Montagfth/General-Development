/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modificaciones;

import Interfaces.DAOReservaServTres;
import Model.DAOReservaServTresIMPLEMENT;
import java.awt.GridLayout;
import java.sql.Date;
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
public class DialogEditarReservaServMantenimiento extends JDialog{
    private JTextField txtFecha;
    private JButton btnGuardar;
    private int idReserva;
    private DAOReservaServTres dao = new DAOReservaServTresIMPLEMENT();

    public DialogEditarReservaServMantenimiento(JFrame parent, int idReservaActual, String fechaActual) {
        super(parent, "Modificar Fecha de Mantenimiento", true);
        this.idReserva = idReservaActual;
        initComponents(fechaActual);
        setSize(350, 150);
        setLocationRelativeTo(parent);
    }

    private void initComponents(String fechaActual) {
        JLabel lblFecha = new JLabel("Nueva Fecha (YYYY-MM-DD):");
        txtFecha = new JTextField(fechaActual);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());

        setLayout(new GridLayout(2, 2, 10, 10));
        add(lblFecha); add(txtFecha);
        add(new JLabel()); add(btnGuardar);
    }

    private void guardar() {
        try {
            Date nuevaFecha = Date.valueOf(txtFecha.getText().trim());
            dao.modificarFecha(idReserva, nuevaFecha);
            JOptionPane.showMessageDialog(null, "Fecha actualizada.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
