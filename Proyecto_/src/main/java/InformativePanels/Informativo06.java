/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package InformativePanels;

import Panels.panelInformativo;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Fabrizio
 */
public class Informativo06 extends javax.swing.JPanel {

    /**
     * Creates new form Informativo06
     */
    public Informativo06() {
        initComponents();
        BtnRetornar.setVisible(false);
    }

    public void mostraPaneles(JPanel panel) {
        PanelContendor.removeAll();
        PanelContendor.add(panel, BorderLayout.CENTER);
        PanelContendor.revalidate();
        PanelContendor.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContendor = new javax.swing.JPanel();
        TxtTitulo = new javax.swing.JLabel();
        TxtInformativo01 = new javax.swing.JLabel();
        Separador01 = new javax.swing.JSeparator();
        TxtInformativo02 = new javax.swing.JLabel();
        TxtInformativo03 = new javax.swing.JLabel();
        TxtInformativo04 = new javax.swing.JLabel();
        TxtInformativo05 = new javax.swing.JLabel();
        Separador02 = new javax.swing.JSeparator();
        TxtInformativo06 = new javax.swing.JLabel();
        TxtInformativo07 = new javax.swing.JLabel();
        TxtInformativo08 = new javax.swing.JLabel();
        TxtInformativo09 = new javax.swing.JLabel();
        Separador03 = new javax.swing.JSeparator();
        TxtInformativo10 = new javax.swing.JLabel();
        TxtInformativo11 = new javax.swing.JLabel();
        BtnRetornar = new javax.swing.JButton();
        Separador2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1211, 768));
        setMinimumSize(new java.awt.Dimension(1211, 768));

        PanelContendor.setPreferredSize(new java.awt.Dimension(1211, 768));

        TxtTitulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        TxtTitulo.setText("AÑO 2017 | TESLA SEMI Y ROADSTER II");

        TxtInformativo01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo01.setText("En un evento doble, Tesla sorprende con dos nuevos vehículos revolucionarios.");

        TxtInformativo02.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo02.setText("· TESLA SEMI:");

        TxtInformativo03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo03.setText("- Camión eléctrico para transporte de carga.");

        TxtInformativo04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo04.setText(" - Autonomía: hasta 800 km.");

        TxtInformativo05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo05.setText("- Menor coste operativo vs. camiones diésel.");

        TxtInformativo06.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo06.setText("· ROADSTER 2da GENERACION:");

        TxtInformativo07.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo07.setText("- Aceleración: 0-100 km/h en 1.9 seg.");

        TxtInformativo08.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo08.setText("- Velocidad Máxima: +400 km/h.");

        TxtInformativo09.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo09.setText("- Autonomía estimada: 1000 km.");

        TxtInformativo10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        TxtInformativo10.setText("DATO CURIOSO:");

        TxtInformativo11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TxtInformativo11.setText("- Evento impactante que proyectó a Tesla hacia nuevos mercados.");

        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/7.png"))); // NOI18N

        javax.swing.GroupLayout PanelContendorLayout = new javax.swing.GroupLayout(PanelContendor);
        PanelContendor.setLayout(PanelContendorLayout);
        PanelContendorLayout.setHorizontalGroup(
            PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContendorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Separador01)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContendorLayout.createSequentialGroup()
                        .addComponent(TxtTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Separador2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContendorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnRetornar)
                            .addGroup(PanelContendorLayout.createSequentialGroup()
                                .addGroup(PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelContendorLayout.createSequentialGroup()
                                        .addGroup(PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Separador03, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Separador02, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo01, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                                        .addGap(40, 40, 40))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContendorLayout.createSequentialGroup()
                                        .addGroup(PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(TxtInformativo10, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo11, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo06, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo07, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo08, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo09, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo03, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo02, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo04, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo05, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)))
                .addGap(0, 0, 0))
        );
        PanelContendorLayout.setVerticalGroup(
            PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContendorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtTitulo)
                .addGap(12, 12, 12)
                .addComponent(Separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtInformativo01)
                .addGap(18, 18, 18)
                .addComponent(Separador01, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContendorLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelContendorLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(TxtInformativo02)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo03)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo04)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo05)
                        .addGap(31, 31, 31)
                        .addComponent(Separador02, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(TxtInformativo06)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo07)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo08)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo09)
                        .addGap(33, 33, 33)
                        .addComponent(Separador03, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtInformativo10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo11)))
                .addGap(18, 18, 18)
                .addComponent(BtnRetornar)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostraPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JPanel PanelContendor;
    private javax.swing.JSeparator Separador01;
    private javax.swing.JSeparator Separador02;
    private javax.swing.JSeparator Separador03;
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
