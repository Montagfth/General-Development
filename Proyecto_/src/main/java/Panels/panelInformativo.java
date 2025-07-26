package Panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import InformativePanels.*;

/**
 *
 * @author Fabrizio
 */
public class panelInformativo extends javax.swing.JPanel {

    public panelInformativo() {
        initComponents();
        // Asegurar que el panel tenga el tamaño correcto
        this.setSize(1211, 768);
        this.setOpaque(true);
        this.setVisible(true);
    }

    public void mostrarPaneles(JPanel panel) {
        panel.setSize(1211, 768);
        panel.setLocation(0, 0);

        // Verificar que PnlContenedorGeneral existe antes de usarlo
        if (PnlContenedorGeneral != null) {
            PnlContenedorGeneral.removeAll();
            PnlContenedorGeneral.add(panel, BorderLayout.CENTER);
            PnlContenedorGeneral.revalidate();
            PnlContenedorGeneral.repaint();
        } else {
            // Si no existe PnlContenedorGeneral, usar el panel principal
            this.removeAll();
            this.setLayout(new BorderLayout());
            this.add(panel, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        LblSubtitulo = new javax.swing.JLabel();
        JSeparador02 = new javax.swing.JSeparator();
        LblEventosTesla = new javax.swing.JLabel();
        JSeparador03 = new javax.swing.JSeparator();
        LblEvento01 = new javax.swing.JLabel();
        BtnEvento01 = new javax.swing.JButton();
        LblEvento02 = new javax.swing.JLabel();
        BtnEvento02 = new javax.swing.JButton();
        LblEvento03 = new javax.swing.JLabel();
        BtnEvento03 = new javax.swing.JButton();
        LblEvento04 = new javax.swing.JLabel();
        BtnEvento04 = new javax.swing.JButton();
        LblEvento05 = new javax.swing.JLabel();
        BtnEvento05 = new javax.swing.JButton();
        LblEvento06 = new javax.swing.JLabel();
        BtnEvento06 = new javax.swing.JButton();
        LblEvento07 = new javax.swing.JLabel();
        BtnEvento07 = new javax.swing.JButton();
        LblEvento08 = new javax.swing.JLabel();
        BtnEvento08 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1211, 787));

        LblSubtitulo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblSubtitulo.setText("\"Acelerando la transicion del mundo hacia la energia sostenible\"");

        LblEventosTesla.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LblEventosTesla.setText("EVENTOS CLAVE EN TESLA");

        LblEvento01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento01.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento01.setText("Fundación de Tesla Motors por Martin Eberhard y Marc Tarpenning ...");

        BtnEvento01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento01.setText("Ver mas..");
        BtnEvento01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento01ActionPerformed(evt);
            }
        });

        LblEvento02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento02.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento02.setText("Elon Musk invierte en Tesla y se convierte en presidente de la junta ...");

        BtnEvento02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento02.setText("Ver mas..");
        BtnEvento02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento02ActionPerformed(evt);
            }
        });

        LblEvento03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento03.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento03.setText("Lanzamiento del Tesla Roadster, primer auto deportivo 100% eléctrico ...");

        BtnEvento03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento03.setText("Ver mas..");
        BtnEvento03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento03ActionPerformed(evt);
            }
        });

        LblEvento04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento04.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento04.setText("Lanzamiento del Model S: sedán eléctrico de alto rendimiento ...");

        BtnEvento04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento04.setText("Ver mas..");
        BtnEvento04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento04ActionPerformed(evt);
            }
        });

        LblEvento05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento05.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento05.setText("Anuncio de Powerwall: baterías para hogares ...");

        BtnEvento05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento05.setText("Ver mas..");
        BtnEvento05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento05ActionPerformed(evt);
            }
        });

        LblEvento06.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento06.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento06.setText("Presentación del Tesla Semi y el Roadster de segunda generación ...");

        BtnEvento06.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento06.setText("Ver mas..");
        BtnEvento06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento06ActionPerformed(evt);
            }
        });

        LblEvento07.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento07.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento07.setText("Tesla entra al S&P 500 como una de las empresas más valiosas del mundo ...");

        BtnEvento07.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento07.setText("Ver mas..");
        BtnEvento07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento07ActionPerformed(evt);
            }
        });

        LblEvento08.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblEvento08.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEvento08.setText("Avances en conducción autónoma y expansión global de Gigafábricas ...");

        BtnEvento08.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEvento08.setText("Ver mas..");
        BtnEvento08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEvento08ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("FUNDACION | 2003");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("INVERSION | 2004");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("PRIMER AUTO | 2008");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("MODEL S | 2012");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("POWERWALL | 2015");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("SEGUNDA GENERACION | 2017");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("CATEGORIZACION | 2020");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel9.setText("NUEVOS AVANCES | 2023");

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addComponent(LblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(791, 791, 791))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEventosTesla, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LblEvento02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LblEvento03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BtnEvento03, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BtnEvento02, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblEvento01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnEvento01)))
                                .addGap(4, 4, 4))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEvento07, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEvento07))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEvento04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEvento05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEvento06, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnEvento05)
                                    .addComponent(BtnEvento04)
                                    .addComponent(BtnEvento06)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContenedorGeneralLayout.createSequentialGroup()
                                .addComponent(LblEvento08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEvento08)))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(LblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblEventosTesla, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento01)
                            .addComponent(BtnEvento01))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento02)
                            .addComponent(BtnEvento02))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento03)
                            .addComponent(BtnEvento03))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento04)
                            .addComponent(BtnEvento04))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento05)
                            .addComponent(BtnEvento05))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento06)
                            .addComponent(BtnEvento06))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento07)
                            .addComponent(BtnEvento07))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEvento08)
                            .addComponent(BtnEvento08))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEvento08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento08ActionPerformed
        mostrarPaneles(new Informativo08());
    }//GEN-LAST:event_BtnEvento08ActionPerformed

    private void BtnEvento07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento07ActionPerformed
        mostrarPaneles(new Informativo07());
    }//GEN-LAST:event_BtnEvento07ActionPerformed

    private void BtnEvento06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento06ActionPerformed
        mostrarPaneles(new Informativo06());
    }//GEN-LAST:event_BtnEvento06ActionPerformed

    private void BtnEvento05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento05ActionPerformed
        mostrarPaneles(new Informativo05());
    }//GEN-LAST:event_BtnEvento05ActionPerformed

    private void BtnEvento04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento04ActionPerformed
        mostrarPaneles(new Informativo04());
    }//GEN-LAST:event_BtnEvento04ActionPerformed

    private void BtnEvento03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento03ActionPerformed
        mostrarPaneles(new Informativo03());
    }//GEN-LAST:event_BtnEvento03ActionPerformed

    private void BtnEvento02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento02ActionPerformed
        mostrarPaneles(new Informativo02());
    }//GEN-LAST:event_BtnEvento02ActionPerformed

    private void BtnEvento01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEvento01ActionPerformed
        mostrarPaneles(new Informativo01());
    }//GEN-LAST:event_BtnEvento01ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEvento01;
    private javax.swing.JButton BtnEvento02;
    private javax.swing.JButton BtnEvento03;
    private javax.swing.JButton BtnEvento04;
    private javax.swing.JButton BtnEvento05;
    private javax.swing.JButton BtnEvento06;
    private javax.swing.JButton BtnEvento07;
    private javax.swing.JButton BtnEvento08;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JLabel LblEvento01;
    private javax.swing.JLabel LblEvento02;
    private javax.swing.JLabel LblEvento03;
    private javax.swing.JLabel LblEvento04;
    private javax.swing.JLabel LblEvento05;
    private javax.swing.JLabel LblEvento06;
    private javax.swing.JLabel LblEvento07;
    private javax.swing.JLabel LblEvento08;
    private javax.swing.JLabel LblEventosTesla;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
