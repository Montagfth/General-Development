package View;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Administrative.panelAdministrator;
import DatabaseModels.Administrador;
import java.awt.Color;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;

public class ventanaAdministrador extends javax.swing.JFrame {

    private Administrador administrador;

    public ventanaAdministrador(Administrador administrador) {
        this.administrador = administrador;
        initComponents();
        this.setLocationRelativeTo(null);
        inicializacionPanel();
        cargaFechaHora();
        mostrarDatosAdministrador();
        estilosJFrameAdmin();
        setTitle("TESLA Motors Inc.");
    }

    public void cargaFechaHora() {

        LocalDate now = LocalDate.now();
        Locale Regional = new Locale("es", "ES");
        LblFecha_Hora.setText(now.format(DateTimeFormatter.ofPattern("dd '|' MMMM '|' YYYY", Regional)));
    }

    public void estilosJFrameAdmin() {
        BtnCerrarSesion.setBackground(new Color(51, 51, 51));
        BtnCerrarSesion.setForeground(Color.WHITE);
    }

    public void inicializacionPanel() {

        PnlContenidoPaneles.setLayout(new BorderLayout());
        mostrarPaneles(new panelAdministrator());
    }

    public void mostrarPaneles(JPanel panel) {

        panel.setSize(1194, 694);

        PnlContenidoPaneles.removeAll();
        PnlContenidoPaneles.add(panel, BorderLayout.CENTER);
        PnlContenidoPaneles.revalidate();
        PnlContenidoPaneles.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        PnlMenu = new javax.swing.JPanel();
        LblLogo = new javax.swing.JLabel();
        JSeparador01 = new javax.swing.JSeparator();
        BtnCerrarSesion = new javax.swing.JButton();
        LblJerarquia = new javax.swing.JLabel();
        LblJerarquia1 = new javax.swing.JLabel();
        JSeparador2 = new javax.swing.JSeparator();
        LblFecha_Hora = new javax.swing.JLabel();
        LblTitulo = new javax.swing.JLabel();
        JSeparador3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PnlContenidoPaneles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PnlContenedorGeneral.setVerifyInputWhenFocusTarget(false);

        LblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logomenu.png"))); // NOI18N

        BtnCerrarSesion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnCerrarSesion.setText("CERRAR SESION");
        BtnCerrarSesion.setBorder(null);
        BtnCerrarSesion.setBorderPainted(false);
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        LblJerarquia.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblJerarquia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblJerarquia.setText("ADMINISTRACION");

        LblJerarquia1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblJerarquia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblJerarquia1.setText("DNI");

        LblFecha_Hora.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblFecha_Hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFecha_Hora.setText("[Fecha y hora aqui]");

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        LblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/letrasmenu.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRADOR");

        javax.swing.GroupLayout PnlMenuLayout = new javax.swing.GroupLayout(PnlMenu);
        PnlMenu.setLayout(PnlMenuLayout);
        PnlMenuLayout.setHorizontalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlMenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(LblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LblJerarquia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblJerarquia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(LblTitulo))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSeparador3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JSeparador01)
                    .addComponent(JSeparador2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PnlMenuLayout.createSequentialGroup()
                        .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(LblFecha_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        PnlMenuLayout.setVerticalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(JSeparador2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlMenuLayout.createSequentialGroup()
                        .addComponent(LblJerarquia)
                        .addGap(18, 18, 18)
                        .addComponent(LblJerarquia1))
                    .addComponent(LblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblFecha_Hora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PnlContenidoPaneles.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PnlContenidoPanelesLayout = new javax.swing.GroupLayout(PnlContenidoPaneles);
        PnlContenidoPaneles.setLayout(PnlContenidoPanelesLayout);
        PnlContenidoPanelesLayout.setHorizontalGroup(
            PnlContenidoPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1209, Short.MAX_VALUE)
        );
        PnlContenidoPanelesLayout.setVerticalGroup(
            PnlContenidoPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addComponent(PnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(PnlContenidoPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlContenidoPaneles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            //Not to programm here.
        }
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void mostrarDatosAdministrador() {
        LblJerarquia.setText(administrador.getNombre().toUpperCase());
        LblJerarquia1.setText(administrador.getDni());

        // Mostrar imagen del administrador si existe
        byte[] imagenBytes = administrador.getFoto();
        if (imagenBytes != null && imagenBytes.length > 0) {
            ImageIcon icon = new ImageIcon(imagenBytes);

            // Escalar imagen al tamaño del JLabel
            Image imagenEscalada = icon.getImage().getScaledInstance(
                    LblLogo.getWidth(),
                    LblLogo.getHeight(),
                    Image.SCALE_SMOOTH
            );

            LblLogo.setIcon(new ImageIcon(imagenEscalada));
        } else {
            // Si no hay imagen, puedes dejar una por defecto si quieres
            //LblLogo.setIcon(new ImageIcon(getClass().getResource("ruta")));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador2;
    private javax.swing.JSeparator JSeparador3;
    private javax.swing.JLabel LblFecha_Hora;
    private javax.swing.JLabel LblJerarquia;
    private javax.swing.JLabel LblJerarquia1;
    private javax.swing.JLabel LblLogo;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlContenidoPaneles;
    private javax.swing.JPanel PnlMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
