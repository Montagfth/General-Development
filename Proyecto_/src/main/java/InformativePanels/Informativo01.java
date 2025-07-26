package InformativePanels;

import Panels.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Informativo01 extends javax.swing.JPanel {

    public Informativo01() {
        initComponents();
        BtnRetornar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        TxtTitulo = new javax.swing.JLabel();
        TxtInformativo01 = new javax.swing.JLabel();
        TxtInformativo02 = new javax.swing.JLabel();
        Separador01 = new javax.swing.JSeparator();
        TxtInformativo03 = new javax.swing.JLabel();
        TxtInformativo04 = new javax.swing.JLabel();
        TxtInformativo05 = new javax.swing.JLabel();
        Separador02 = new javax.swing.JSeparator();
        TxtInformativo06 = new javax.swing.JLabel();
        TxtInformativo07 = new javax.swing.JLabel();
        Separador03 = new javax.swing.JSeparator();
        TxtInformativo08 = new javax.swing.JLabel();
        TxtInformativo09 = new javax.swing.JLabel();
        Separador04 = new javax.swing.JSeparator();
        TxtInformativo10 = new javax.swing.JLabel();
        TxtInformativo11 = new javax.swing.JLabel();
        BtnRetornar = new javax.swing.JButton();
        Separador2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1211, 768));

        PanelContenedor.setPreferredSize(new java.awt.Dimension(1211, 768));

        TxtTitulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        TxtTitulo.setText("AÑO 2003 | FUNDACION DE TESLA");

        TxtInformativo01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo01.setText("Fue fundada en julio de 2003 por los ingenieros Martin Eberhard y Marc Tarpenning como Tesla Motors. El nombre de la empresa es un tributo al inventor e ingeniero eléctrico serbio Nikola Tesla");

        TxtInformativo02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo02.setText("Su visión: desarrollar vehículos eléctricos sin comprometer el rendimiento.");

        TxtInformativo03.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo03.setText("· ENFOQUE INICIAL:");

        TxtInformativo04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo04.setText("- Reducir la dependencia del petróleo. ");

        TxtInformativo05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo05.setText("- Innovar en baterías de ion-litio y sistemas eléctricos.");

        TxtInformativo06.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo06.setText("· NOMBRE:");

        TxtInformativo07.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo07.setText("- Un homenaje a Nikola Tesla, pionero en la electricidad. ");

        TxtInformativo08.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo08.setText("· FINANCIACION INICIAL:");

        TxtInformativo09.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo09.setText("- Inversores ángeles y entusiasmo del sector tecnológico.");

        TxtInformativo10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo10.setText("· FRASE DESTACADA:");

        TxtInformativo11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo11.setText("“Queríamos demostrar que los autos eléctricos podían ser emocionantes.”");

        BtnRetornar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador01)
                    .addComponent(Separador2)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtTitulo)
                            .addComponent(TxtInformativo02)
                            .addComponent(TxtInformativo01))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnRetornar)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtInformativo03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtInformativo04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtInformativo05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtInformativo06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtInformativo07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Separador02, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtInformativo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtInformativo11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Separador04, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtInformativo08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtInformativo09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Separador03, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separador01, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtInformativo01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtInformativo02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(TxtInformativo03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(Separador02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(TxtInformativo06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(Separador03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(TxtInformativo08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(Separador04, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(TxtInformativo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo11, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(BtnRetornar)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
public void mostrarPaneles(JPanel panel) {
    // Limpiar el panel contenedor actual
    this.removeAll();
    
    // Establecer nuevo layout
    this.setLayout(new BorderLayout());
    
    // Configurar el panel que se va a mostrar
    panel.setPreferredSize(new Dimension(1211, 768));
    
    // Agregar el panel
    this.add(panel, BorderLayout.CENTER);
    
    // Actualizar la vista
    this.revalidate();
    this.repaint();
}



    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostrarPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JSeparator Separador01;
    private javax.swing.JSeparator Separador02;
    private javax.swing.JSeparator Separador03;
    private javax.swing.JSeparator Separador04;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JLabel TxtInformativo01;
    private javax.swing.JLabel TxtInformativo02;
    private javax.swing.JLabel TxtInformativo03;
    private javax.swing.JLabel TxtInformativo04;
    private javax.swing.JLabel TxtInformativo05;
    private javax.swing.JLabel TxtInformativo06;
    private javax.swing.JLabel TxtInformativo07;
    private javax.swing.JLabel TxtInformativo08;
    private javax.swing.JLabel TxtInformativo09;
    private javax.swing.JLabel TxtInformativo10;
    private javax.swing.JLabel TxtInformativo11;
    private javax.swing.JLabel TxtTitulo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
