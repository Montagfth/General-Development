package Panels;

import DatabaseModels.Cliente;
import Interfaces.DAOCliente;
import Model.DAOClienteIMPLEMENT;
import View.*;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Fabrizio
 */
public class panelRegistro extends javax.swing.JPanel {

    // Agregar referencia al JFrame principal
    private loginPrototipo ventanaPrincipal;

    // Constructor modificado para recibir la referencia
    public panelRegistro(loginPrototipo ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        initComponents();
        estilosPanelRegistro();
    }

    // Constructor sin parámetros para compatibilidad
    public panelRegistro() {
        initComponents();
        estilosPanelRegistro();
    }

    public void estilosPanelRegistro () {
        //Leyendas en campos de ingreso de texto:
        JTFPrimerNombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFSegundoNombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFApellido.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFIdentificacionDNI.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFNumeroPrincipal.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFNumeroSecundario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        //Color de botones:
        BtnRegistrarse.setBackground(new Color(51,51,51));
        BtnRetornar.setBackground(new Color(51,51,51));
        //Color de texto dentro de los botones:
        BtnRegistrarse.setForeground(Color.WHITE);
        BtnRetornar.setForeground(Color.WHITE);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        LblIndicaciones = new javax.swing.JLabel();
        JSeparador01 = new javax.swing.JSeparator();
        LblIdentificacionDNI = new javax.swing.JLabel();
        JTFIdentificacionDNI = new javax.swing.JTextField();
        LblPrimerNombre = new javax.swing.JLabel();
        JTFPrimerNombre = new javax.swing.JTextField();
        LblSegundoNombre = new javax.swing.JLabel();
        JTFSegundoNombre = new javax.swing.JTextField();
        LblApellido = new javax.swing.JLabel();
        JTFApellido = new javax.swing.JTextField();
        LblEmail = new javax.swing.JLabel();
        JTFEmail = new javax.swing.JTextField();
        LblNumeroPrincipal = new javax.swing.JLabel();
        JTFNumeroPrincipal = new javax.swing.JTextField();
        LblNumeroSecundario = new javax.swing.JLabel();
        JTFNumeroSecundario = new javax.swing.JTextField();
        JSeparador02 = new javax.swing.JSeparator();
        LblNotaInformativa = new javax.swing.JLabel();
        JSeparador03 = new javax.swing.JSeparator();
        BtnRegistrarse = new javax.swing.JButton();
        BtnRetornar = new javax.swing.JButton();
        LblNotaInformativa1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        PnlContenedorGeneral.setPreferredSize(new java.awt.Dimension(1366, 768));

        LblIndicaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblIndicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/letras.png"))); // NOI18N

        LblIdentificacionDNI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblIdentificacionDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblIdentificacionDNI.setText("DNI | CREDENCIAL");

        JTFIdentificacionDNI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFIdentificacionDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblPrimerNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblPrimerNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblPrimerNombre.setText("PRIMER NOMBRE");

        JTFPrimerNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFPrimerNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblSegundoNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblSegundoNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblSegundoNombre.setText("SEGUNDO NOMBRE");

        JTFSegundoNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFSegundoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblApellido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblApellido.setText("APELLIDO");

        JTFApellido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblEmail.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblEmail.setText("E-MAIL | CORREO ELECTRONICO");

        JTFEmail.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFEmailActionPerformed(evt);
            }
        });

        LblNumeroPrincipal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblNumeroPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumeroPrincipal.setText("TELEFONO | PRINCIPAL");

        JTFNumeroPrincipal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFNumeroPrincipal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFNumeroPrincipal.setPreferredSize(new java.awt.Dimension(233, 26));
        JTFNumeroPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNumeroPrincipalActionPerformed(evt);
            }
        });

        LblNumeroSecundario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblNumeroSecundario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumeroSecundario.setText("TELEFONO | SECUNDARIO");

        JTFNumeroSecundario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFNumeroSecundario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFNumeroSecundario.setPreferredSize(new java.awt.Dimension(233, 26));

        LblNotaInformativa.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblNotaInformativa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNotaInformativa.setText("NOTA: El segundo numero puede ser omitido");

        BtnRegistrarse.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnRegistrarse.setText("REGISTRARSE");
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });

        BtnRetornar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnRetornar.setText("VOLVER");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        LblNotaInformativa1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblNotaInformativa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNotaInformativa1.setText("¿Ya tiene una cuenta? Seleccione la opcion:");

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JSeparador02)
                            .addComponent(LblIndicaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                            .addComponent(JSeparador01)
                            .addComponent(JSeparador03)
                            .addComponent(LblNotaInformativa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LblPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTFPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTFSegundoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(LblSegundoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTFApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTFIdentificacionDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(LblIdentificacionDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTFEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTFNumeroPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblNumeroPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LblNumeroSecundario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTFNumeroSecundario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(610, 610, 610)
                        .addComponent(BtnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(LblNotaInformativa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LblIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblPrimerNombre)
                    .addComponent(LblSegundoNombre))
                .addGap(6, 6, 6)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(JTFSegundoNombre))
                .addGap(40, 40, 40)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblApellido)
                    .addComponent(LblIdentificacionDNI))
                .addGap(6, 6, 6)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(JTFIdentificacionDNI))
                .addGap(40, 40, 40)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEmail)
                    .addComponent(LblNumeroPrincipal))
                .addGap(6, 6, 6)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFNumeroPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(JTFEmail))
                .addGap(40, 40, 40)
                .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LblNumeroSecundario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNumeroSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblNotaInformativa)
                .addGap(12, 12, 12)
                .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnRegistrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNotaInformativa1)
                    .addComponent(BtnRetornar))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNumeroPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNumeroPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNumeroPrincipalActionPerformed

private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
    if (ventanaPrincipal != null) {
        ventanaPrincipal.mostrarPanelLogin();
    }
}//GEN-LAST:event_BtnRetornarActionPerformed

private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
    // Registro de usuario-cliente:
    String identificacionDNI = JTFIdentificacionDNI.getText().trim();
    String primerNombre = JTFPrimerNombre.getText().trim();
    String segundoNombre = JTFSegundoNombre.getText().trim();
    String apellido = JTFApellido.getText().trim();
    String email = JTFEmail.getText().trim();
    String primerTelefono = JTFNumeroPrincipal.getText().trim();
    String segundoTelefono = JTFNumeroSecundario.getText().trim();

    // Validación mejorada de campos vacíos
    if (identificacionDNI.trim().isEmpty() || primerNombre.trim().isEmpty()
            || segundoNombre.trim().isEmpty() || apellido.trim().isEmpty()
            || email.trim().isEmpty() || primerTelefono.trim().isEmpty()) {

        JOptionPane.showMessageDialog(null,
                "Por favor, asegúrese de que todos los campos obligatorios estén completos.",
                "Tesla", JOptionPane.WARNING_MESSAGE);
        JTFPrimerNombre.requestFocus();
        return;
    }

    //Mejoras de validacion ===
    // 2. Validación específica de DNI
    if (!identificacionDNI.matches("\\d{9}")) {
        JOptionPane.showMessageDialog(null,
                "La credencial debe contener exactamente 9 dígitos numéricos.", "Tesla", JOptionPane.WARNING_MESSAGE);
        JTFIdentificacionDNI.requestFocus();
        return;
    }

    // 3. Validación de email
    if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(null,
                "Ingrese un correo electrónico válido.", "Tesla", JOptionPane.WARNING_MESSAGE);
        JTFEmail.requestFocus();
        return;
    }

    // 4. Validación de teléfonos
    if (!primerTelefono.matches("\\d{7,15}")) {
        JOptionPane.showMessageDialog(null,
                "El número de teléfono principal debe contener entre 7 y 15 dígitos.", "Tesla", JOptionPane.WARNING_MESSAGE);
        JTFNumeroPrincipal.requestFocus();
        return;
    }

    if (!segundoTelefono.isEmpty() && !segundoTelefono.matches("\\d{7,15}")) {
        JOptionPane.showMessageDialog(null,
                "El número de teléfono secundario debe contener entre 7 y 15 dígitos (si se proporciona).", "Tesla", JOptionPane.WARNING_MESSAGE);
        JTFNumeroSecundario.requestFocus();
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
        JOptionPane.showMessageDialog(null,
                "¡Registro exitoso! Bienvenido " + primerNombre + ".",
                "Tesla", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos después del registro exitoso
        limpiarCampos();

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        JOptionPane.showMessageDialog(null,
                "Error al registrar el usuario: " + e.getMessage(),
                "Tesla", JOptionPane.ERROR_MESSAGE);
    }

    // IMPORTANTE: No crear nueva ventana aquí, usar el sistema de paneles
    // ventanaPrincipal Ventana_Principal = new ventanaPrincipal();
    // Ventana_Principal.setVisible(true);
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    private void JTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFEmailActionPerformed

    // ELIMINAR este método problemático
    /*
    public void mostradorPaneles(JPanel panel) {
        panel.setLocation(0, 0);
        PnlContenedorGeneral.removeAll();
        PnlContenedorGeneral.add(panel, BorderLayout.CENTER);
        PnlContenedorGeneral.revalidate();
        PnlContenedorGeneral.repaint();
    }
     */
    // Método para limpiar campos después del registro
    private void limpiarCampos() {
        JTFIdentificacionDNI.setText("");
        JTFPrimerNombre.setText("");
        JTFSegundoNombre.setText("");
        JTFApellido.setText("");
        JTFEmail.setText("");
        JTFNumeroPrincipal.setText("");
        JTFNumeroSecundario.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JTextField JTFApellido;
    private javax.swing.JTextField JTFEmail;
    private javax.swing.JTextField JTFIdentificacionDNI;
    private javax.swing.JTextField JTFNumeroPrincipal;
    private javax.swing.JTextField JTFNumeroSecundario;
    private javax.swing.JTextField JTFPrimerNombre;
    private javax.swing.JTextField JTFSegundoNombre;
    private javax.swing.JLabel LblApellido;
    private javax.swing.JLabel LblEmail;
    private javax.swing.JLabel LblIdentificacionDNI;
    private javax.swing.JLabel LblIndicaciones;
    private javax.swing.JLabel LblNotaInformativa;
    private javax.swing.JLabel LblNotaInformativa1;
    private javax.swing.JLabel LblNumeroPrincipal;
    private javax.swing.JLabel LblNumeroSecundario;
    private javax.swing.JLabel LblPrimerNombre;
    private javax.swing.JLabel LblSegundoNombre;
    private javax.swing.JPanel PnlContenedorGeneral;
    // End of variables declaration//GEN-END:variables
}
