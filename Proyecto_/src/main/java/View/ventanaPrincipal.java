package View;

import DatabaseModels.Cliente;
import View.*;
import Panels.*;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Services.*;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ventanaPrincipal extends javax.swing.JFrame {

    private Cliente cliente;

    /*
       public ventanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargaFechaHora();
        cargaPanelInformativo(); 
        //mostrarDatosCliente();
    }
        public ventanaPrincipal(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        this.setLocationRelativeTo(null);
        cargaFechaHora();
        mostrarDatosCliente();
        cargaPanelInformativo();
        estilosJFrameVentanaPrinicipal();
    }
     */
    public ventanaPrincipal(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        this.setLocationRelativeTo(null);
        cargaFechaHora();
        mostrarDatosCliente();
        cargaPanelInformativo();
        estilosJFrameVentanaPrinicipal();
        setTitle("TESLA Motors Inc.");
    }

    public void estilosJFrameVentanaPrinicipal() {
        //Color del boton:
        BtnAutos.setBackground(new Color(51, 51, 51));
        BtnAutopartes.setBackground(new Color(51, 51, 51));
        BtnMantenimiento.setBackground(new Color(51, 51, 51));
        BtnAutos1.setBackground(new Color(51, 51, 51));
        BtnCerrarSesion.setBackground(new Color(51, 51, 51));
        //Color del texto en el boton:
        BtnAutos.setForeground(Color.WHITE);
        BtnAutopartes.setForeground(Color.WHITE);
        BtnMantenimiento.setForeground(Color.WHITE);
        BtnAutos1.setForeground(Color.WHITE);
        BtnCerrarSesion.setForeground(Color.WHITE);
    }

    public void cargaFechaHora() {
        LocalDate now = LocalDate.now();
        Locale Regional = new Locale("es", "ES");
        LblFecha_Hora3.setText(now.format(DateTimeFormatter.ofPattern("dd '|' MMMM '|' YYYY", Regional)));
    }

    private void mostrarDatosCliente() {
        LblJerarquia5.setText(cliente.getNombre_Cliente().toUpperCase());
        LblJerarquia6.setText(cliente.getDNI_Cliente());

        // Mostrar imagen del administrador si existe
        byte[] imagenBytes = cliente.getFotoCliente();
        if (imagenBytes != null && imagenBytes.length > 0) {
            ImageIcon icon = new ImageIcon(imagenBytes);

            // Escalar imagen al tamaño del JLabel
            Image imagenEscalada = icon.getImage().getScaledInstance(
                    LblLogo2.getWidth(),
                    LblLogo2.getHeight(),
                    Image.SCALE_SMOOTH
            );

            LblLogo2.setIcon(new ImageIcon(imagenEscalada));
        } else {
            // Si no hay imagen, puedes dejar una por defecto si quieres
            //LblLogo.setIcon(new ImageIcon(getClass().getResource("ruta")));
        }
    }

    public void cargaPanelInformativo() {
        PnlContenidoPaneles.setLayout(new BorderLayout());
        panelInformativo panelInfo = new panelInformativo();
        mostrarPaneles(panelInfo);
        LblJerarquia.setText("TESLA CORPORATION");

        System.out.println("Panel informativo cargado. Componentes en PnlContenidoPaneles: " + PnlContenidoPaneles.getComponentCount());
    }

    public void mostrarPaneles(JPanel panel) {
        panel.setSize(1194, 694);

        PnlContenidoPaneles.removeAll();
        PnlContenidoPaneles.add(panel, BorderLayout.CENTER);
        PnlContenidoPaneles.revalidate();
        PnlContenidoPaneles.repaint();

        PnlContenidoPaneles.setVisible(true);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        PnlMenu = new javax.swing.JPanel();
        JSeparador01 = new javax.swing.JSeparator();
        BtnAutos = new javax.swing.JButton();
        BtnAutopartes = new javax.swing.JButton();
        BtnMantenimiento = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        LblTitulo1 = new javax.swing.JLabel();
        LblLogo2 = new javax.swing.JLabel();
        JSeparador6 = new javax.swing.JSeparator();
        LblJerarquia5 = new javax.swing.JLabel();
        LblJerarquia6 = new javax.swing.JLabel();
        LblFecha_Hora3 = new javax.swing.JLabel();
        JSeparador7 = new javax.swing.JSeparator();
        LblJerarquia8 = new javax.swing.JLabel();
        BtnAutos1 = new javax.swing.JButton();
        LblJerarquia9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        PnlEncabezado = new javax.swing.JPanel();
        LblJerarquia = new javax.swing.JLabel();
        PnlContenidoPaneles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlMenu.setPreferredSize(new java.awt.Dimension(183, 422));

        BtnAutos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnAutos.setText("AUTOS");
        BtnAutos.setBorder(null);
        BtnAutos.setBorderPainted(false);
        BtnAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAutosActionPerformed(evt);
            }
        });

        BtnAutopartes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnAutopartes.setText("AUTOPARTES");
        BtnAutopartes.setBorder(null);
        BtnAutopartes.setBorderPainted(false);
        BtnAutopartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAutopartesActionPerformed(evt);
            }
        });

        BtnMantenimiento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnMantenimiento.setText("MANTENIMIENTO");
        BtnMantenimiento.setBorder(null);
        BtnMantenimiento.setBorderPainted(false);
        BtnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMantenimientoActionPerformed(evt);
            }
        });

        BtnCerrarSesion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnCerrarSesion.setText("CERRAR SESION");
        BtnCerrarSesion.setBorder(null);
        BtnCerrarSesion.setBorderPainted(false);
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        LblTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        LblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblTitulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/letrasmenu.png"))); // NOI18N

        LblLogo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logomenu.png"))); // NOI18N

        LblJerarquia5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblJerarquia5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblJerarquia5.setText("CLIENTE");

        LblJerarquia6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblJerarquia6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblJerarquia6.setText("DNI");

        LblFecha_Hora3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblFecha_Hora3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFecha_Hora3.setText("[Fecha y hora aqui]");

        LblJerarquia8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblJerarquia8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblJerarquia8.setText("ACERCA DE LA EMPRESA");

        BtnAutos1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnAutos1.setText("TESLA");
        BtnAutos1.setBorder(null);
        BtnAutos1.setBorderPainted(false);
        BtnAutos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAutos1ActionPerformed(evt);
            }
        });

        LblJerarquia9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblJerarquia9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblJerarquia9.setText("SERVICIOS");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE");

        javax.swing.GroupLayout PnlMenuLayout = new javax.swing.GroupLayout(PnlMenu);
        PnlMenu.setLayout(PnlMenuLayout);
        PnlMenuLayout.setHorizontalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlMenuLayout.createSequentialGroup()
                        .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblTitulo1)
                            .addComponent(LblFecha_Hora3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnlMenuLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PnlMenuLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(LblLogo2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(LblJerarquia5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LblJerarquia6, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                                    .addComponent(JSeparador6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparador7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnAutopartes, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnAutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PnlMenuLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LblJerarquia9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LblJerarquia8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap())
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlMenuLayout.setVerticalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblLogo2)
                    .addGroup(PnlMenuLayout.createSequentialGroup()
                        .addComponent(LblJerarquia5)
                        .addGap(18, 18, 18)
                        .addComponent(LblJerarquia6)))
                .addGap(12, 12, 12)
                .addComponent(JSeparador6, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(LblFecha_Hora3)
                .addGap(12, 12, 12)
                .addComponent(JSeparador7, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblJerarquia9)
                .addGap(12, 12, 12)
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlMenuLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BtnAutopartes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(BtnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(LblJerarquia8)
                .addGap(12, 12, 12)
                .addComponent(BtnAutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272)
                .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LblJerarquia.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        LblJerarquia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblJerarquia.setText("[Nombre de Servicio]");

        javax.swing.GroupLayout PnlEncabezadoLayout = new javax.swing.GroupLayout(PnlEncabezado);
        PnlEncabezado.setLayout(PnlEncabezadoLayout);
        PnlEncabezadoLayout.setHorizontalGroup(
            PnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(LblJerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 1193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PnlEncabezadoLayout.setVerticalGroup(
            PnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblJerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlContenidoPaneles.setBackground(new java.awt.Color(255, 255, 255));
        PnlContenidoPaneles.setPreferredSize(new java.awt.Dimension(1211, 787));

        javax.swing.GroupLayout PnlContenidoPanelesLayout = new javax.swing.GroupLayout(PnlContenidoPaneles);
        PnlContenidoPaneles.setLayout(PnlContenidoPanelesLayout);
        PnlContenidoPanelesLayout.setHorizontalGroup(
            PnlContenidoPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PnlContenidoPanelesLayout.setVerticalGroup(
            PnlContenidoPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addComponent(PnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlContenidoPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addComponent(PnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlContenidoPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(PnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
    int response = JOptionPane.showConfirmDialog(null, "¿Esta seguro de salir de su sesion?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);

    if (response == JOptionPane.YES_OPTION) {
        loginPrototipo Ventana_Login = new loginPrototipo();
        Ventana_Login.setVisible(true);
        this.setVisible(false);
    } else {
    }
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAutosActionPerformed
        mostrarPaneles(new panelService1());
        LblJerarquia.setText("SERVICIO DE RESERVA | VENTA DE AUTOS");
    }//GEN-LAST:event_BtnAutosActionPerformed

    private void BtnAutopartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAutopartesActionPerformed
        mostrarPaneles(new panelService2());
        LblJerarquia.setText("SERVICIO DE RESERVA | VENTA DE AUTOPARTES");
    }//GEN-LAST:event_BtnAutopartesActionPerformed

    private void BtnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMantenimientoActionPerformed
        mostrarPaneles(new panelService3());
        LblJerarquia.setText("SERVICIO DE RESERVA | MANTENIMIENTO DE AUTO");
    }//GEN-LAST:event_BtnMantenimientoActionPerformed

    private void BtnAutos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAutos1ActionPerformed

        cargaPanelInformativo();
    }//GEN-LAST:event_BtnAutos1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAutopartes;
    private javax.swing.JButton BtnAutos;
    private javax.swing.JButton BtnAutos1;
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnMantenimiento;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador6;
    private javax.swing.JSeparator JSeparador7;
    private javax.swing.JLabel LblFecha_Hora3;
    private javax.swing.JLabel LblJerarquia;
    private javax.swing.JLabel LblJerarquia5;
    private javax.swing.JLabel LblJerarquia6;
    private javax.swing.JLabel LblJerarquia8;
    private javax.swing.JLabel LblJerarquia9;
    private javax.swing.JLabel LblLogo2;
    private javax.swing.JLabel LblTitulo1;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlContenidoPaneles;
    private javax.swing.JPanel PnlEncabezado;
    private javax.swing.JPanel PnlMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
