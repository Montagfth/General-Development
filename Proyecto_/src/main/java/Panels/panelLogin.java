package Panels;

import View.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import DatabaseModels.Administrador;
import DatabaseModels.Cliente;
import DatabaseModels.Sesion;
import Interfaces.DAOAdministrador;
import Interfaces.DAOCliente;
import Model.DAOAdministradorIMPLEMENT;
import Model.DAOClienteIMPLEMENT;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.SwingUtilities;

public class panelLogin extends javax.swing.JPanel {

    public panelLogin() {
        initComponents();
        JTFCredencial.requestFocus();
        estilosPanelLogin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        LblLogo = new javax.swing.JLabel();
        LblBienvenida1 = new javax.swing.JLabel();
        JSeparador2 = new javax.swing.JSeparator();
        LblCredencial = new javax.swing.JLabel();
        JTFCredencial = new javax.swing.JTextField();
        BtnInicioSesion = new javax.swing.JButton();
        JSeparador01 = new javax.swing.JSeparator();
        LblInformativo02 = new javax.swing.JLabel();
        BtnRegistrarse = new javax.swing.JButton();
        LblIndicaciones = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 51, 153));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        PnlContenedorGeneral.setPreferredSize(new java.awt.Dimension(1366, 768));

        LblLogo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblLogo.setText("Electric Cars, Solar & Clean Energy");

        LblBienvenida1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblBienvenida1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblBienvenida1.setText("¡Bienvenido! Ingrese su credencial para iniciar sesion");

        LblCredencial.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblCredencial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblCredencial.setText("CREDENCIALES : ADMINISTRADOR | CLIENTE");

        JTFCredencial.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFCredencial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFCredencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFCredencialActionPerformed(evt);
            }
        });

        BtnInicioSesion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnInicioSesion.setText("INICIAR SESION");
        BtnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioSesionActionPerformed(evt);
            }
        });

        LblInformativo02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblInformativo02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblInformativo02.setText("¿No tienes una cuenta?");

        BtnRegistrarse.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnRegistrarse.setText("REGISTRARSE");
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });

        LblIndicaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblIndicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/letras.png"))); // NOI18N

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(563, 563, 563)
                        .addComponent(LblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(LblBienvenida1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(JSeparador01))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(LblInformativo02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparador2)
                            .addComponent(JTFCredencial)
                            .addComponent(LblCredencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(540, 540, 540))
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblIndicaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContenedorGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(612, 612, 612))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(LblIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LblLogo)
                .addGap(32, 32, 32)
                .addComponent(LblBienvenida1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(JSeparador2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(LblCredencial, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFCredencial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnInicioSesion)
                .addGap(56, 56, 56)
                .addComponent(JSeparador01, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(LblInformativo02, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(201, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContenedorGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRegistrarse)
                        .addGap(198, 198, 198))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 1391, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        loginPrototipo ventanaPrincipal = (loginPrototipo) SwingUtilities.getWindowAncestor(this);
        ventanaPrincipal.mostrarPanelRegistro();
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    public void estilosPanelLogin() {
        //Leyendas en campo de ingreso de texto:
        JTFCredencial.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese sus credenciales");
        //Color de los botones:
        BtnInicioSesion.setBackground(new Color(51, 51, 51));
        BtnRegistrarse.setBackground(new Color(51, 51, 51));
        //Color del texto dentro del boton:
        BtnRegistrarse.setForeground(Color.WHITE);
        BtnRegistrarse.setForeground(Color.WHITE);
    }


private void BtnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioSesionActionPerformed

    //Validacion de credenciales:
    String dni = JTFCredencial.getText();

    if (dni.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe completar el campo con sus credenciales.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        JTFCredencial.setText("");
        JTFCredencial.requestFocus();
        return;
    }

    if (!dni.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "La credencial debe contener solo números.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        JTFCredencial.setText("");
        JTFCredencial.requestFocus();
        return;
    }

    if (dni.length() != 9 || !dni.matches("\\d{9}")) {
        JOptionPane.showMessageDialog(null, "La credencial debe tener exactamente 9 dígitos.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        JTFCredencial.setText("");
        JTFCredencial.requestFocus();
        return;
    }

    try {
        DAOAdministrador daoAdmin = new DAOAdministradorIMPLEMENT();
        Administrador admin = daoAdmin.buscarAdministradorPorDNI(dni);

        if (admin != null) {
            Sesion.adminLogueado = admin;

            // Pasamos el objeto admin al constructor
            ventanaAdministrador ventanaAdmin = new ventanaAdministrador(admin);
            ventanaAdmin.setVisible(true);

            // Cerramos el login actual
            SwingUtilities.getWindowAncestor(this).dispose();
            return;
        }

        DAOCliente daoCliente = new DAOClienteIMPLEMENT();
        Cliente cliente = daoCliente.autenticarPorDNI(dni);

        if (cliente != null) {
            Sesion.clienteLogueado = cliente;

            ventanaPrincipal ventanaPrincipal = new ventanaPrincipal(cliente);
            ventanaPrincipal.setVisible(true);

            // Cerramos el login actual
            SwingUtilities.getWindowAncestor(this).dispose();
        } else {
            JOptionPane.showMessageDialog(null, "DNI no encontrado. Verifique sus datos.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}//GEN-LAST:event_BtnInicioSesionActionPerformed


    private void JTFCredencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFCredencialActionPerformed
        //Not to code here.
    }//GEN-LAST:event_JTFCredencialActionPerformed

    public void mostradorPaneles(JPanel panel) {

        panel.setSize(759, 446);
        panel.setLocation(0, 0);

        PnlContenedorGeneral.removeAll();
        PnlContenedorGeneral.add(panel, BorderLayout.CENTER);
        PnlContenedorGeneral.revalidate();
        PnlContenedorGeneral.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInicioSesion;
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador2;
    private javax.swing.JTextField JTFCredencial;
    private javax.swing.JLabel LblBienvenida1;
    private javax.swing.JLabel LblCredencial;
    private javax.swing.JLabel LblIndicaciones;
    private javax.swing.JLabel LblInformativo02;
    private javax.swing.JLabel LblLogo;
    private javax.swing.JPanel PnlContenedorGeneral;
    // End of variables declaration//GEN-END:variables
}
