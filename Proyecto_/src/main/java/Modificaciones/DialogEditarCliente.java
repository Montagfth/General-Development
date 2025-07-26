package Modificaciones;

import DatabaseModels.Cliente;
import Interfaces.DAOCliente;
import Model.DAOClienteIMPLEMENT;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DialogEditarCliente extends JDialog{
    private JTextField txtNombre, txtSegundoNombre, txtApellido, txtDni, txtCorreo, txtTelefono, txtSegundoTelefono;
    private JButton btnGuardar;
    private Cliente cliente;
    private DAOCliente dao = new DAOClienteIMPLEMENT();

    public DialogEditarCliente(JFrame parent, Cliente c) {
        super(parent, "Editar Cliente", true);
        this.cliente = c;
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        txtNombre = new JTextField(cliente.getNombre_Cliente());
        txtSegundoNombre = new JTextField(cliente.getSegundoNombre_Cliente());
        txtApellido = new JTextField(cliente.getApellido_Cliente());
        txtDni = new JTextField(cliente.getDNI_Cliente());
        txtCorreo = new JTextField(cliente.getCorreo_Cliente());
        txtTelefono = new JTextField(String.valueOf(cliente.getTelefono_Cliente()));
        txtSegundoTelefono = new JTextField(String.valueOf(cliente.getSegundoTelefono_Cliente()));
        btnGuardar = new JButton("Guardar");

        btnGuardar.addActionListener(e -> guardarCambios());

        setLayout(new GridLayout(8, 2, 5, 5));
        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Segundo Nombre:")); add(txtSegundoNombre);
        add(new JLabel("Apellido:")); add(txtApellido);
        add(new JLabel("DNI:")); add(txtDni);
        add(new JLabel("Correo:")); add(txtCorreo);
        add(new JLabel("Teléfono:")); add(txtTelefono);
        add(new JLabel("Segundo Teléfono:")); add(txtSegundoTelefono);
        add(new JLabel()); add(btnGuardar);
    }

    private void guardarCambios() {
        try {
            cliente.setNombre_Cliente(txtNombre.getText());
            cliente.setSegundoNombre_Cliente(txtSegundoNombre.getText());
            cliente.setApellido_Cliente(txtApellido.getText());
            cliente.setDNI_Cliente(txtDni.getText());
            cliente.setCorreo_Cliente(txtCorreo.getText());
            cliente.setTelefono_Cliente(txtTelefono.getText()); //Analizar
            cliente.setSegundoTelefono_Cliente(txtSegundoTelefono.getText()); //Analizar

            dao.modificar(cliente);
            JOptionPane.showMessageDialog(this, "Cliente actualizado con éxito.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }
}
