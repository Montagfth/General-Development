package Services;

import Panels.panelInformativo;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import DatabaseModels.*;
import Interfaces.*;
import Model.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class panelService2 extends javax.swing.JPanel {

    private List<Autopartes> listaAutopartesActual = new java.util.ArrayList<>();

    public panelService2() {
        initComponents();
        configuracionEventosTabla();
        filtrarAutos();
        TblAutopartes.setDefaultEditor(Object.class, null);
        TblAutopartes.getTableHeader().setResizingAllowed(false);
        TblAutopartes.getTableHeader().setReorderingAllowed(false);
        Descripcion01.setText("");

        //Redimensionado estatico de componentes:
        //JTextArea:
        //DescripcionGeneralAutopartes.setPreferredSize(new Dimension(466, 257));
        //DescripcionGeneralAutopartes.setMaximumSize(new Dimension(466, 257));
        //DescripcionGeneralAutopartes.setMinimumSize(new Dimension(466, 257));
        //Label Imagenes
        lblImagenDinamica.setPreferredSize(new Dimension(466, 257));
        lblImagenDinamica.setMaximumSize(new Dimension(466, 257));
        lblImagenDinamica.setMinimumSize(new Dimension(466, 257));
        
        //====================================
        //Centrado de contenido:
        DefaultTableCellRenderer centradoContenido = new DefaultTableCellRenderer();
        centradoContenido.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < TblAutopartes.getColumnCount(); i++) {
            TblAutopartes.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }
        //====================================

        //Ajuste de seleccion unica:
        TblAutopartes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {

                StringBuilder informacionDefecto = new StringBuilder();
                informacionDefecto.append("═════════════════════════════════════════════════\n");
                informacionDefecto.append("\t           TESLA Inc. | AUTOPARTES\n");
                informacionDefecto.append("═════════════════════════════════════════════════\n\n");
                informacionDefecto.append("Seleccione una autoparte de la tabla para ver información\n");
                informacionDefecto.append("detallada sobre el producto.\n\n");
                informacionDefecto.append("Información que se mostrará:\n");
                informacionDefecto.append("• Nombre y categoría del producto\n");
                informacionDefecto.append("• Stock disponible y precio\n");
                informacionDefecto.append("• Descripción técnica completa\n");
                informacionDefecto.append("• Compatibilidad con vehículos\n");
                informacionDefecto.append("• Código de pieza y garantía\n");
                informacionDefecto.append("• Disponibilidad y tiempo de entrega\n\n");
                informacionDefecto.append("═════════════════════════════════════════════════\n");

                DescripcionGeneralAutopartes.setText(informacionDefecto.toString());
                DescripcionGeneralAutopartes.setCaretPosition(0);

                TblAutopartes.clearSelection();
                Descripcion01.setText("SELECCIONE UN AUTO PARA VER LOS DETALLES");
                //Descripcion02.setText(" ");
                //Descripcion03.setText(" ");
                //Descripcion04.setText(" ");
                //Descripcion05.setText(" ");
                //Descripcion06.setText(" ");
                //Descripcion07.setText(" ");
                //Descripcion08.setText(" ");
                //Descripcion09.setText(" ");
                //Descripcion10.setText(" ");
                //DescripcionGeneralAutopartes.setText("");
                Descripcion01.setText("");

            }
        });

        //Mensajes por defecto en la inicializacion del panel:
        StringBuilder informacionDefecto = new StringBuilder();
        informacionDefecto.append("═════════════════════════════════════════════════\n");
        informacionDefecto.append("\t           TESLA Inc. | AUTOPARTES\n");
        informacionDefecto.append("═════════════════════════════════════════════════\n\n");
        informacionDefecto.append("Seleccione una autoparte de la tabla para ver información\n");
        informacionDefecto.append("detallada sobre el producto.\n\n");
        informacionDefecto.append("Información que se mostrará:\n");
        informacionDefecto.append("• Nombre y categoría del producto\n");
        informacionDefecto.append("• Stock disponible y precio\n");
        informacionDefecto.append("• Descripción técnica completa\n");
        informacionDefecto.append("• Compatibilidad con vehículos\n");
        informacionDefecto.append("• Código de pieza y garantía\n");
        informacionDefecto.append("• Disponibilidad y tiempo de entrega\n\n");
        informacionDefecto.append("═════════════════════════════════════════════════\n");

        DescripcionGeneralAutopartes.setText(informacionDefecto.toString());
        DescripcionGeneralAutopartes.setCaretPosition(0);

    }

    public void cargaAutopartes() {
        try {
            DAOAutopartes daoAu = new DAOAutopartesIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblAutopartes.getModel();
            model.setRowCount(0);

            daoAu.Listar("").forEach((u) -> model.addRow(new Object[]{u.getID_Autoparte(), u.getNombre_Autoparte(), u.getCategoria_Autoparte(), u.getStock_Autoparte(), u.getPrecio_Autoparte()}));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarTabla(List<Autopartes> listaAutopartes) {
        this.listaAutopartesActual = listaAutopartes;

        DefaultTableModel model = (DefaultTableModel) TblAutopartes.getModel();
        model.setRowCount(0);

        for (Autopartes a : listaAutopartes) {
            Object[] fila = {
                a.getID_Autoparte(),
                a.getNombre_Autoparte(),
                a.getCategoria_Autoparte(),
                a.getStock_Autoparte(),
                a.getPrecio_Autoparte()
            };
            model.addRow(fila);
        }
    }

    public void configuracionEventosTabla() {
        TblAutopartes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TblAutopartes.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Autopartes seleccionada = listaAutopartesActual.get(filaSeleccionada);

                    // Actualizar etiqueta principal
                    //Descripcion01.setText("DETALLES DE: " + seleccionada.getNombre_Autoparte());
                    // Actualizar JTextArea con toda la información
                    StringBuilder informacion = new StringBuilder();
                    informacion.append("══════════════════════════════════════════════\n");
                    informacion.append("\t          INFORMACIÓN DE LA AUTOPARTE\n");
                    informacion.append("══════════════════════════════════════════════\n\n");

                    informacion.append("NOMBRE: ").append(seleccionada.getNombre_Autoparte()).append("\n");
                    informacion.append("CATEGORÍA: ").append(seleccionada.getCategoria_Autoparte()).append("\n");
                    informacion.append("STOCK DISPONIBLE: ").append(seleccionada.getStock_Autoparte()).append(" unidades\n");
                    informacion.append("PRECIO: S/. ").append(seleccionada.getPrecio_Autoparte()).append("\n\n");

                    informacion.append("──────────────────────────────────────────────\n");
                    informacion.append("\t                          DESCRIPCIÓN\n");
                    informacion.append("──────────────────────────────────────────────\n\n");

                    informacion.append("CÓDIGO DE PIEZA: ").append(seleccionada.getID_Autoparte()).append("\n\n");
                    informacion.append("DISPONIBILIDAD: Inmediata en establecimientos.\n");
                    informacion.append("GARANTIA DE LA PIEZA : 12 Meses por defecto de fabrica.\n");
                    informacion.append("TIEMPO DE ENTREGA(SOLICITUD): 24 a 48 horas.\n");
                    informacion.append("(COMPROBACION POR EL ADMINISTRADOR)\n");
                    informacion.append("COMPATIBILIDAD:\n");
                    informacion.append("- TESLA Model 3 (2017 - 2023)\n");
                    informacion.append("- TESLA Model Y (2020 - 2023)\n");
                    informacion.append("FABRICANTE: Tesla Motors (EE.UU.)\n");
                    informacion.append("NIVEL DE INSTALACION: Medio | Requiere reserva de mantenimiento.\n");
                    informacion.append("OBSERVACION: Reporte detallado despues de la revision.\n\n");

                    informacion.append("══════════════════════════════════════════════\n");
                    informacion.append("    \tPara solicitar esta pieza, presione el botón\n");
                    informacion.append("    \t\t'SOLICITAR PIEZA'\n");
                    informacion.append("══════════════════════════════════════════════");

                    DescripcionGeneralAutopartes.setText(informacion.toString());
                    DescripcionGeneralAutopartes.setCaretPosition(0);

                    // Mostrar la imagen
                    byte[] imagenBytes = seleccionada.getImagen_Autoparte();
                    if (imagenBytes != null && imagenBytes.length > 0) {
                        ImageIcon icon = new ImageIcon(imagenBytes);
                        Image img = icon.getImage().getScaledInstance(
                                lblImagenDinamica.getWidth(),
                                lblImagenDinamica.getHeight(),
                                Image.SCALE_SMOOTH
                        );
                        lblImagenDinamica.setIcon(new ImageIcon(img));
                    } else {
                        lblImagenDinamica.setIcon(null);
                    }

                } else {
                    // Si no hay selección, mostrar mensaje por defecto y limpiar imagen
                    //Descripcion01.setText("SELECCIONE UN ELEMENTO PARA VER SUS DETALLES");
                    DescripcionGeneralAutopartes.setText(
                            "═════════════════════════════════════════════════\n"
                            + "\t           TESLA Inc. | AUTOPARTES\n"
                            + "═══════════════════════════════════════════════\n\n"
                            + "Seleccione una autoparte de la tabla para ver información\n"
                            + "detallada sobre el producto.\n\n"
                            + "Información que se mostrará:\n"
                            + "• Nombre y categoría del producto\n"
                            + "• Stock disponible y precio\n"
                            + "• Descripción técnica completa\n"
                            + "• Compatibilidad con vehículos\n"
                            + "• Código de pieza y garantía\n"
                            + "• Disponibilidad y tiempo de entrega\n\n"
                            + "═════════════════════════════════════════════════");
                    lblImagenDinamica.setIcon(null);
                }
            }
        });
    }

    public void filtrarAutos() {
        try {
            String categoriaSeleccionada = CbxAnioAuto.getSelectedItem().toString();
            DAOAutopartes daoAu = new DAOAutopartesIMPLEMENT();

            // Filtrar por categoría - CORRECCIÓN: Usar la categoría exacta como filtro
            List<Autopartes> autopartesCompletas = daoAu.Listar("");
            List<Autopartes> listaFiltrada = new java.util.ArrayList<>();

            // Filtrar manualmente para asegurar coincidencia exacta
            for (Autopartes autoparte : autopartesCompletas) {
                if (autoparte.getCategoria_Autoparte().equalsIgnoreCase(categoriaSeleccionada)) {
                    listaFiltrada.add(autoparte);
                }
            }

            actualizarTabla(listaFiltrada);

        } catch (Exception e) {
            System.out.println("Error al filtrar: " + e.getMessage());
        }
    }

    public void mostrarPaneles(JPanel panel) {
        panel.setSize(1194, 694);
        panel.setLocation(0, 0);

        PnlContenedorGeneral.removeAll();
        PnlContenedorGeneral.add(panel, BorderLayout.CENTER);
        PnlContenedorGeneral.revalidate();
        PnlContenedorGeneral.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        LblSubtitulo = new javax.swing.JLabel();
        JSeparador01 = new javax.swing.JSeparator();
        LblAnioAuto = new javax.swing.JLabel();
        CbxAnioAuto = new javax.swing.JComboBox<>();
        JSeparador02 = new javax.swing.JSeparator();
        JSeparador03 = new javax.swing.JSeparator();
        BtnRetornar = new javax.swing.JButton();
        PnlDescripcionAuto = new javax.swing.JPanel();
        lblImagenDinamica = new javax.swing.JLabel();
        Descripcion01 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescripcionGeneralAutopartes = new javax.swing.JTextArea();
        BtnSolictarAutoparte = new javax.swing.JButton();
        JCheckBoxAutopartes = new javax.swing.JCheckBox();
        JSPRegistroAutoparte = new javax.swing.JScrollPane();
        TblAutopartes = new javax.swing.JTable();

        LblSubtitulo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblSubtitulo.setText("Seleccione alguna categoria en los campos para la busqueda de la pieza:");

        LblAnioAuto.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblAnioAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblAnioAuto.setText("FILTROS DE AUTOPARTES | TESLA | OTROS VEHICULOS");

        CbxAnioAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CbxAnioAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FRENOS", "LUCES", "LLANTAS", "ELECTRONICA" }));
        CbxAnioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxAnioAutoActionPerformed(evt);
            }
        });

        BtnRetornar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        lblImagenDinamica.setForeground(new java.awt.Color(51, 0, 255));
        lblImagenDinamica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagenDinamica.setText(" ");

        Descripcion01.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Descripcion01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Descripcion01.setText("SELECCIONE UN ELEMENTO PARA VER SUS DETALLES");

        DescripcionGeneralAutopartes.setColumns(20);
        DescripcionGeneralAutopartes.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        DescripcionGeneralAutopartes.setRows(5);
        DescripcionGeneralAutopartes.setEnabled(false);
        DescripcionGeneralAutopartes.setFocusable(false);
        jScrollPane1.setViewportView(DescripcionGeneralAutopartes);

        BtnSolictarAutoparte.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnSolictarAutoparte.setText("SOLICITAR PIEZA");
        BtnSolictarAutoparte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSolictarAutoparteActionPerformed(evt);
            }
        });

        JCheckBoxAutopartes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JCheckBoxAutopartes.setText("Marque la casilla para aceptar terminos y condiciones para la operacion.");

        javax.swing.GroupLayout PnlDescripcionAutoLayout = new javax.swing.GroupLayout(PnlDescripcionAuto);
        PnlDescripcionAuto.setLayout(PnlDescripcionAutoLayout);
        PnlDescripcionAutoLayout.setHorizontalGroup(
            PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnSolictarAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagenDinamica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion01, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(JCheckBoxAutopartes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlDescripcionAutoLayout.setVerticalGroup(
            PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagenDinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Descripcion01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCheckBoxAutopartes)
                .addGap(7, 7, 7)
                .addComponent(BtnSolictarAutoparte)
                .addGap(33, 33, 33))
        );

        TblAutopartes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblAutopartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR:", "NOMBRE:", "CATEGORIA:", "STOCK:", "PRECIO ($ USD):"
            }
        ));
        JSPRegistroAutoparte.setViewportView(TblAutopartes);

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JSeparador03, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnRetornar)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JSeparador01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                                    .addComponent(JSeparador02, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(LblSubtitulo))
                                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(JSPRegistroAutoparte)))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(LblAnioAuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(PnlDescripcionAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addComponent(LblSubtitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblAnioAuto)
                            .addComponent(CbxAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JSPRegistroAutoparte))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PnlDescripcionAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 621, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRetornar)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CbxAnioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxAnioAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxAnioAutoActionPerformed

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostrarPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed

    private void BtnSolictarAutoparteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSolictarAutoparteActionPerformed

        if (!JCheckBoxAutopartes.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe aceptar los terminos y condiciones para continuar", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = TblAutopartes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una autoparte para ver sus detalles", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(null, "¿Esta seguro de solicitar la pieza?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            try {
                int idAutoparte = (int) TblAutopartes.getValueAt(fila, 0);
                String dniCliente = Sesion.clienteLogueado.getDNI_Cliente();
                
                //Reserva de la pieza:
                ReservaServDos reserva = new ReservaServDos();
                reserva.setID_Autoparte(idAutoparte);
                reserva.setDNI_Cliente(dniCliente);

                DAOReservaServDos daoRsD = new DAOReservaServDosIMPLEMENT();
                daoRsD.registrar(reserva);

                //Decremento dinamico del Stock de Autopartes:
                DAOAutopartes daoAutopartes = new DAOAutopartesIMPLEMENT();
                boolean actualizado = daoAutopartes.disminuirStock(idAutoparte);

                if (actualizado) {
                    JOptionPane.showMessageDialog(null, "Se ha solicitado correctamente | Stock actualizado", "Tesla Motors Inc.", JOptionPane.INFORMATION_MESSAGE);
                    cargaAutopartes();
                } else {
                    JOptionPane.showMessageDialog(null, "Se reservo la pieza | No se pudo actualizar el stock", "Tesla Mortor Inc.", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al procesar la solicitud: " + e.getMessage(), "Tesla Inc.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnSolictarAutoparteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JButton BtnSolictarAutoparte;
    private javax.swing.JComboBox<String> CbxAnioAuto;
    private javax.swing.JLabel Descripcion01;
    private javax.swing.JTextArea DescripcionGeneralAutopartes;
    private javax.swing.JCheckBox JCheckBoxAutopartes;
    private javax.swing.JScrollPane JSPRegistroAutoparte;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JLabel LblAnioAuto;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlDescripcionAuto;
    private javax.swing.JTable TblAutopartes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenDinamica;
    // End of variables declaration//GEN-END:variables
}
