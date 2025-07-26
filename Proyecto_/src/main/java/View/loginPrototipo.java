package View;

import javax.swing.JPanel;
import Panels.*;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class loginPrototipo extends javax.swing.JFrame {

    public loginPrototipo() {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializacion();
        //Titulo de aplicativo:
        setTitle("TESLA Motors Inc.");
        //Logo de la empresa:
        //ImageIcon icono = new ImageIcon(getClass().getResource("C:/Users/Fabrizio/OneDrive/Escritorio/47964e79-97f9-4612-bb3f-e569a345ffeb.jpg"));
        //setIconImage(icono.getImage());
    }
    
    public void inicializacion(){
        PnlContenedorPaneles.setLayout(new BorderLayout());
        mostrarPaneles(new panelLogin());
    }

    public void mostrarPaneles(JPanel panel) {
        PnlContenedorPaneles.removeAll();
        PnlContenedorPaneles.add(panel, BorderLayout.CENTER);
        PnlContenedorPaneles.revalidate();
        PnlContenedorPaneles.repaint();
    }
    
    // Método específico para mostrar el panel de registro
    public void mostrarPanelRegistro() {
        mostrarPaneles(new panelRegistro(this));
    }
    
    // Método específico para mostrar el panel de login
    public void mostrarPanelLogin() {
        mostrarPaneles(new panelLogin());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        PnlContenedorPaneles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        PnlContenedorGeneral.setMaximumSize(new java.awt.Dimension(1366, 768));
        PnlContenedorGeneral.setMinimumSize(new java.awt.Dimension(1366, 768));
        PnlContenedorGeneral.setPreferredSize(new java.awt.Dimension(1366, 768));

        PnlContenedorPaneles.setBackground(new java.awt.Color(255, 255, 255));
        PnlContenedorPaneles.setMaximumSize(new java.awt.Dimension(1366, 768));
        PnlContenedorPaneles.setMinimumSize(new java.awt.Dimension(1366, 768));
        PnlContenedorPaneles.setPreferredSize(new java.awt.Dimension(1366, 768));

        javax.swing.GroupLayout PnlContenedorPanelesLayout = new javax.swing.GroupLayout(PnlContenedorPaneles);
        PnlContenedorPaneles.setLayout(PnlContenedorPanelesLayout);
        PnlContenedorPanelesLayout.setHorizontalGroup(
            PnlContenedorPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        PnlContenedorPanelesLayout.setVerticalGroup(
            PnlContenedorPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorPaneles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginPrototipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPrototipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPrototipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPrototipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPrototipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlContenedorPaneles;
    // End of variables declaration//GEN-END:variables
}
