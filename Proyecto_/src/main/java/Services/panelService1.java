package Services;

import Comentarios.DialogComentarios;
import Panels.panelInformativo;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Model.*;
import Interfaces.*;
import java.util.ArrayList;
import java.util.List;
import Database.*;
import DatabaseModels.*;
import Interfaces.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

public class panelService1 extends javax.swing.JPanel {

    private final DAOAutos daoA = new DAOAutoIMPLEMENT();

    public panelService1() {
        initComponents();
        configuracionEventosTabla();
        //cargaDatosPrueba();
        cargaAutos();
        TblAuto.setDefaultEditor(Object.class, null);
        TblAuto.getTableHeader().setResizingAllowed(false);
        TblAuto.getTableHeader().setReorderingAllowed(false);

        //Dimensionamiento estatico de componentes:
        //DescripcionGeneralAutos.setPreferredSize(new Dimension(466, 257));
        //DescripcionGeneralAutos.setMaximumSize(new Dimension(466, 257));
        //DescripcionGeneralAutos.setMinimumSize(new Dimension(466, 257));
        //lblImagenDinamica.
        lblImagenDinamica.setPreferredSize(new Dimension(466, 257));
        lblImagenDinamica.setMaximumSize(new Dimension(466, 257));
        lblImagenDinamica.setMinimumSize(new Dimension(466, 257));

        /*
        SwingUtilities.invokeLater(() -> {
            int ancho = lblImagenDinamica.getWidth();
            int alto = lblImagenDinamica.getHeight();
            System.out.println("Dimensiones del JLabel: LblImagenDinamicaAutos -> Ancho: " + ancho + " px | Alto: " + alto + " px");
        });
         */
        //====================================
        //Centrado de contenido:
        DefaultTableCellRenderer centradoContenido = new DefaultTableCellRenderer();
        centradoContenido.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < TblAuto.getColumnCount(); i++) {
            TblAuto.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }
        //====================================

        //Ajuste de seleccion unica:
        TblAuto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {

                StringBuilder informacionDefecto = new StringBuilder();
                informacionDefecto.append("═══════════════════════════════════════════════\n");
                informacionDefecto.append("\t               Tesla Inc. | VEHICULOS\n");
                informacionDefecto.append("═══════════════════════════════════════════════\n\n");
                informacionDefecto.append("Seleccione un vehículo de la tabla para ver información\n");
                informacionDefecto.append("detallada sobre el modelo seleccionado.\n");
                informacionDefecto.append("Información que se mostrará:\n");
                informacionDefecto.append("• Nombre del modelo y versión\n");
                informacionDefecto.append("• Año de fabricación y autonomía\n");
                informacionDefecto.append("• Tipo de motor y capacidad de batería\n");
                informacionDefecto.append("• Precio base y configuraciones disponibles\n");
                informacionDefecto.append("• Garantía y condiciones de servicio\n");
                informacionDefecto.append("• Disponibilidad en tienda y tiempos de entrega\n\n");
                informacionDefecto.append("═══════════════════════════════════════════════\n");

                DescripcionGeneralAutos.setText(informacionDefecto.toString());
                DescripcionGeneralAutos.setCaretPosition(0);

                TblAuto.clearSelection();
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

                //DescripcionGeneralAutos.setText("");
                Descripcion01.setText("");
                lblImagenDinamica.setIcon(null);
            }
        });

        StringBuilder informacionDefecto = new StringBuilder();
        informacionDefecto.append("═══════════════════════════════════════════════\n");
        informacionDefecto.append("\t               Tesla Inc. | VEHICULOS\n");
        informacionDefecto.append("═══════════════════════════════════════════════\n\n");
        informacionDefecto.append("Seleccione un vehículo de la tabla para ver información\n");
        informacionDefecto.append("detallada sobre el modelo seleccionado.\n");
        informacionDefecto.append("Información que se mostrará:\n");
        informacionDefecto.append("• Nombre del modelo y versión\n");
        informacionDefecto.append("• Año de fabricación y autonomía\n");
        informacionDefecto.append("• Tipo de motor y capacidad de batería\n");
        informacionDefecto.append("• Precio base y configuraciones disponibles\n");
        informacionDefecto.append("• Garantía y condiciones de servicio\n");
        informacionDefecto.append("• Disponibilidad en tienda y tiempos de entrega\n\n");
        informacionDefecto.append("═══════════════════════════════════════════════\n");

        DescripcionGeneralAutos.setText(informacionDefecto.toString());
        DescripcionGeneralAutos.setCaretPosition(0);

        lblImagenDinamica.setIcon(null);
        //Descripcion01.setText("SELECCIONE UN AUTO PARA VER LOS DETALLES");
    }

    public void actualizarTabla(List<Auto> lista) {

        DefaultTableModel model = (DefaultTableModel) TblAuto.getModel();

        model.setRowCount(0);

        for (Auto a : lista) {
            model.addRow(new Object[]{
                a.getID_Auto(),
                a.getMarca_Auto(),
                a.getModelo_Auto(),
                a.getAnio_Auto(),
                a.getPrecio_Auto()
            });
        }
    }

    public void filtrarAutos() {

        String anio = CbxAnioAuto.getSelectedItem().toString();
        String modelo = CbxModeloAuto.getSelectedItem().toString();
        String precio = CbxPrecioAuto.getSelectedItem().toString();

        anio = anio.equals("TODOS") ? "" : anio;
        modelo = modelo.equals("TODOS") ? "" : modelo;
        precio = precio.equals("TODOS") ? "" : precio;

        try {
            List<Auto> lista = daoA.listarFiltrado(anio, modelo, precio);
            actualizarTabla(lista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargaAutos() {
        try {
            DAOAutos daoA = new DAOAutoIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblAuto.getModel();
            model.setRowCount(0);
            daoA.Listar("").forEach((u) -> model.addRow(new Object[]{u.getID_Auto(), u.getMarca_Auto(), u.getModelo_Auto(), u.getAnio_Auto(), u.getPrecio_Auto()}));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filtrosVehiculo() {
        CbxAnioAuto.addActionListener(e -> filtrosVehiculo());
        CbxModeloAuto.addActionListener(e -> filtrosVehiculo());
        CbxPrecioAuto.addActionListener(e -> filtrosVehiculo());
    }

    public void configuracionEventosTabla() {
        TblAuto.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TblAuto.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int idAuto = (int) TblAuto.getValueAt(filaSeleccionada, 0);

                    try {
                        // Obtener el auto completo con imagen desde la DB
                        Auto autoSeleccionado = daoA.obtenerPorID(idAuto);

                        if (autoSeleccionado != null) {
                            // Actualizar texto descriptivo

                            /*
                                       String descripcion = String.format("Marca: %s | Modelo: %s | Año: %s | Precio: $%,d",
                                    autoSeleccionado.getMarca_Auto(),
                                    autoSeleccionado.getModelo_Auto(),
                                    autoSeleccionado.getAnio_Auto(),
                                    autoSeleccionado.getPrecio_Auto());

                            Descripcion01.setText(descripcion);
                             */
                            StringBuilder informacionGeneral = new StringBuilder();

                            informacionGeneral.append("══════════════════════════════════════════════\n");
                            informacionGeneral.append("\t               INFORMACION DEL AUTO\n");
                            informacionGeneral.append("══════════════════════════════════════════════\n");

                            informacionGeneral.append("\nMARCA : " + autoSeleccionado.getMarca_Auto());
                            informacionGeneral.append("\nMODELO : " + autoSeleccionado.getModelo_Auto());
                            informacionGeneral.append("\nAÑO : " + autoSeleccionado.getAnio_Auto());

                            informacionGeneral.append("\n\n══════════════════════════════════════════════\n");
                            informacionGeneral.append("\t                   DESCRIPCION EXTRA:\n");
                            informacionGeneral.append("══════════════════════════════════════════════\n\n");

                            informacionGeneral.append("TIPO DE VEHICULO: Elctrico | 100%.\n");
                            informacionGeneral.append("MOTORIZACION: Dual Motor | Traccion integral (AWD).\n");
                            informacionGeneral.append("POTENCIA COMBINADA: 384 HP.\n");
                            informacionGeneral.append("BATERIA: 82 Kwh | Litio-Ion | Alto rendimiento.\n");
                            informacionGeneral.append("VELOCIDAD MAXIMA: 233 | 300 Km/h.\n");
                            informacionGeneral.append("ACELERACION: 0 - 100 Km/h en 4.0 - 4.4 segundos.\n");
                            informacionGeneral.append("TIEMPO DE CARGA: 30 minutos (10 - 80%) | Supercargador.\n");
                            informacionGeneral.append("CONECTIVIDAD: Tesla Premium | Navegacion, Streaming, LTE.\n");
                            informacionGeneral.append("SISTEMA AUTONOMO: Autopilot basico con FSD (Full Self-Driving).\n");
                            informacionGeneral.append("PANTALLA CENTRAL: Tactil 15'' | Resolucion  1920x1030px.\n");
                            informacionGeneral.append("INTERIOR: Cuero vegano premium | Asientos calefactables.\n");
                            informacionGeneral.append("CAPACIDAD DE MALETERO: 649 Litros | FRUNK incluido.\n");
                            informacionGeneral.append("MANTENIMIENTO: Requiere revision anual de software y neumaticos.\n");
                            informacionGeneral.append("COMPATIBILIDAD: Compatible con carga rápida y regenerativa.\n");
                            informacionGeneral.append("CONDICION: Nuevo.\n");
                            informacionGeneral.append("GARANTIA: 8 años.\n");
                            informacionGeneral.append("ESTADO: Disponible\n");
                            informacionGeneral.append("AUTONOMIA: 491 | 600 km por carga completa (Ciclo WLTP).\n");
                            informacionGeneral.append("OBSERVACION: Compatible con actualizaciones remotas | OTA.\n");

                            informacionGeneral.append("\n══════════════════════════════════════════════\n");

                            DescripcionGeneralAutos.setText(informacionGeneral.toString());
                            DescripcionGeneralAutos.setCaretPosition(0);

                            // Mostrar imagen
                            byte[] imagenBytes = autoSeleccionado.getImagen_Auto();
                            if (imagenBytes != null && imagenBytes.length > 0) {
                                ImageIcon icon = new ImageIcon(imagenBytes);
                                Image img = icon.getImage().getScaledInstance(
                                        lblImagenDinamica.getWidth(),
                                        lblImagenDinamica.getHeight(),
                                        Image.SCALE_SMOOTH
                                );
                                lblImagenDinamica.setIcon(new ImageIcon(img));
                                lblImagenDinamica.setText("");
                            } else {
                                lblImagenDinamica.setIcon(null);
                                lblImagenDinamica.setText("");
                                //lblImagenDinamica.setText("Imagen no disponible");
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        lblImagenDinamica.setIcon(null);
                        lblImagenDinamica.setText("Error cargando imagen");
                    }
                }
            }
        });
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
        LblFiltroAuto = new javax.swing.JLabel();
        LblAnioAuto = new javax.swing.JLabel();
        CbxAnioAuto = new javax.swing.JComboBox<>();
        LblModeloAuto = new javax.swing.JLabel();
        CbxModeloAuto = new javax.swing.JComboBox<>();
        LblPrecioAuto = new javax.swing.JLabel();
        CbxPrecioAuto = new javax.swing.JComboBox<>();
        JSeparador02 = new javax.swing.JSeparator();
        JSPRegistroAuto = new javax.swing.JScrollPane();
        TblAuto = new javax.swing.JTable();
        JSeparador03 = new javax.swing.JSeparator();
        BtnRetornar = new javax.swing.JButton();
        PnlDescripcionAuto = new javax.swing.JPanel();
        lblImagenDinamica = new javax.swing.JLabel();
        Descripcion01 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescripcionGeneralAutos = new javax.swing.JTextArea();
        BtnReservarAuto = new javax.swing.JButton();
        BtnComentarAuto = new javax.swing.JButton();
        ChkBxConfirmacionReservaAuto = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        LblSubtitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblSubtitulo.setText("Busque el vehiculo de su preferencia:");

        LblFiltroAuto.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblFiltroAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFiltroAuto.setText("FILTROS DE BUSQUEDA | TESLA | OTROS VEHICULOS");

        LblAnioAuto.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblAnioAuto.setText("AÑO:");

        CbxAnioAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CbxAnioAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "2025", "2024", "2023" }));
        CbxAnioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxAnioAutoActionPerformed(evt);
            }
        });

        LblModeloAuto.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblModeloAuto.setText("MODELO:");

        CbxModeloAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CbxModeloAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "MODEL X", "MODEL Y", "MODEL S", "MODEL 3", "CYBERTRUCK" }));
        CbxModeloAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxModeloAutoActionPerformed(evt);
            }
        });

        LblPrecioAuto.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblPrecioAuto.setText("PRECIO:");

        CbxPrecioAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CbxPrecioAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "MENOS DE 15,000", "15,000 - 25,000", "MAS DE 25,000" }));
        CbxPrecioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxPrecioAutoActionPerformed(evt);
            }
        });

        TblAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR:", "MARCA:", "MODELO:", "AÑO:", "PRECIO ($ USD):"
            }
        ));
        TblAuto.setToolTipText("");
        JSPRegistroAuto.setViewportView(TblAuto);

        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        lblImagenDinamica.setBackground(new java.awt.Color(255, 51, 51));
        lblImagenDinamica.setForeground(new java.awt.Color(51, 0, 255));
        lblImagenDinamica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagenDinamica.setText(" ");

        Descripcion01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Descripcion01.setText(" ");

        DescripcionGeneralAutos.setColumns(20);
        DescripcionGeneralAutos.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        DescripcionGeneralAutos.setRows(5);
        DescripcionGeneralAutos.setEnabled(false);
        DescripcionGeneralAutos.setFocusable(false);
        jScrollPane1.setViewportView(DescripcionGeneralAutos);

        BtnReservarAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnReservarAuto.setText("SOLICITAR VEHICULO");
        BtnReservarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReservarAutoActionPerformed(evt);
            }
        });

        BtnComentarAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnComentarAuto.setText("COMENTAR");
        BtnComentarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnComentarAutoActionPerformed(evt);
            }
        });

        ChkBxConfirmacionReservaAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ChkBxConfirmacionReservaAuto.setText("Marque la casilla para aceptar terminos y condiciones para la operacion.");
        ChkBxConfirmacionReservaAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkBxConfirmacionReservaAutoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Para comentar algun modelo de auto, hacer click aqui:");

        javax.swing.GroupLayout PnlDescripcionAutoLayout = new javax.swing.GroupLayout(PnlDescripcionAuto);
        PnlDescripcionAuto.setLayout(PnlDescripcionAutoLayout);
        PnlDescripcionAutoLayout.setHorizontalGroup(
            PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChkBxConfirmacionReservaAuto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnComentarAuto)
                                .addGap(18, 18, 18))))
                    .addComponent(lblImagenDinamica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion01, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnReservarAuto)
                .addGap(154, 154, 154))
        );
        PnlDescripcionAutoLayout.setVerticalGroup(
            PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagenDinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Descripcion01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChkBxConfirmacionReservaAuto)
                .addGap(18, 18, 18)
                .addComponent(BtnReservarAuto)
                .addGap(12, 12, 12)
                .addGroup(PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnComentarAuto)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRetornar)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(LblAnioAuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LblModeloAuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxModeloAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LblPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LblFiltroAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(LblSubtitulo)
                                                .addComponent(JSPRegistroAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(30, 30, 30)))
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
                        .addComponent(LblFiltroAuto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblAnioAuto)
                            .addComponent(CbxAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblModeloAuto)
                            .addComponent(CbxModeloAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblPrecioAuto)
                            .addComponent(CbxPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JSPRegistroAuto, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
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

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostrarPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed

    private void CbxPrecioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxPrecioAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxPrecioAutoActionPerformed

    private void ChkBxConfirmacionReservaAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkBxConfirmacionReservaAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkBxConfirmacionReservaAutoActionPerformed

    private void BtnReservarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReservarAutoActionPerformed
        //Parametrizacion:
        if (!ChkBxConfirmacionReservaAuto.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe aceptar los terminos y condiciones para continuar", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = TblAuto.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vehiculo en la tabla para continuar.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idAuto = (int) TblAuto.getValueAt(fila, 0);

        try {
            ReservaServUno rsuno = new ReservaServUno();
            rsuno.setID_Auto(idAuto);
            DAOReservaServUno daoRsuno = new DAOReservaServUnoIMPLEMENT();
            daoRsuno.registrar(rsuno);

            JOptionPane.showMessageDialog(null, "Reserva regisrada correctamente", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Se ha registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }//GEN-LAST:event_BtnReservarAutoActionPerformed

    private void CbxAnioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxAnioAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxAnioAutoActionPerformed

    private void CbxModeloAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxModeloAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxModeloAutoActionPerformed

    private void BtnComentarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnComentarAutoActionPerformed

        int filaSeleccionada = TblAuto.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vehiculo para comentar", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idVehiculo = Integer.parseInt(TblAuto.getValueAt(filaSeleccionada, 0).toString());

        DialogComentarios dialog = new DialogComentarios(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                idVehiculo
        );
        dialog.setVisible(true);

    }//GEN-LAST:event_BtnComentarAutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnComentarAuto;
    private javax.swing.JButton BtnReservarAuto;
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JComboBox<String> CbxAnioAuto;
    private javax.swing.JComboBox<String> CbxModeloAuto;
    private javax.swing.JComboBox<String> CbxPrecioAuto;
    private javax.swing.JCheckBox ChkBxConfirmacionReservaAuto;
    private javax.swing.JLabel Descripcion01;
    private javax.swing.JTextArea DescripcionGeneralAutos;
    private javax.swing.JScrollPane JSPRegistroAuto;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JLabel LblAnioAuto;
    private javax.swing.JLabel LblFiltroAuto;
    private javax.swing.JLabel LblModeloAuto;
    private javax.swing.JLabel LblPrecioAuto;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlDescripcionAuto;
    private javax.swing.JTable TblAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenDinamica;
    // End of variables declaration//GEN-END:variables
}
