package Administrative;

import Controller.AdministratorController;
import Interfaces.DAOEmpleado;
import Model.DAOEmpleadosIMPLEMENT;
import javax.swing.table.DefaultTableModel;
import Interfaces.*;
import DatabaseModels.*;
import Model.DAOClienteIMPLEMENT;
import Model.DAOReservaServDosIMPLEMENT;
import Model.DAOReservaServTresIMPLEMENT;
import Model.DAOReservaServUnoIMPLEMENT;
import Modificaciones.DialogEditarCliente;
import Modificaciones.DialogEditarEmpleado;
import Modificaciones.DialogEditarReservaAuto;
import Modificaciones.DialogEditarReservaAutoparte;
import Modificaciones.DialogEditarReservaServMantenimiento;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class panelAdministrator extends javax.swing.JPanel {
    
    // =====================================================
    // INICIALIZACION DE VARIABLES DE COMUNICACION:
    // =====================================================
    private AdministratorController AdminCtrllr;

    // =====================================================
    // INCIALIZACION DE CONSTRUCTORES:
    // =====================================================
    public panelAdministrator() {
        //Inicializacion de componenetes primitivos:
        initComponents();
        //Inicializacion de funcionalidades encapsuladas:
        AdminCtrllr = new AdministratorController(this);
        //Inicializacion de tabla - refresco de registros:
        cargarServicio01Ops();
        cargarServicio02Ops();
        cargarServicio03Ops();
        cargarEmpleados();
        cargarClientes();
        //Inicializacion de metodos esteticos:
        // === Centrado de contenido ===
        centradoContenidoTabla(TblClientes);
        centradoContenidoTabla(TblEmpleados);
        centradoContenidoTabla(TblServicioUno);
        centradoContenidoTabla(TblServicioDos);
        centradoContenidoTabla(TblServicioTres);
        // === Limpieza de seleccion ===
        limpiezaSeleccionRegistro();
        // === Seleccion Unica de registro ===
        seleccionUnicaRegistro();

        // NOTA: Apilar nuevos metodos aqui.
    }

    // =====================================================
    // METODOS DE CONFIGURACION VISUAL
    // =====================================================
    //Metodo de reutilizacion de centrado de contenido de filas:
    public void centradoContenidoTabla(JTable tabla) {
        DefaultTableCellRenderer centradoContenido = new DefaultTableCellRenderer();
        centradoContenido.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }
        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    //Limpieza de seleccion de registro:
    public void limpiezaSeleccionRegistro() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                TblServicioUno.clearSelection();
                TblEmpleados.clearSelection();
                TblServicioUno.clearSelection();
                TblServicioDos.clearSelection();
                TblServicioTres.clearSelection();
                TblClientes.clearSelection();
            }
        });
    }

    //Limpieza de multiseleccion de registro a unica seleccion:
    public void seleccionUnicaRegistro() {
        //Ajuste de unica seleccion:
        TblServicioUno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblServicioDos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblServicioTres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //Inicializacion de indice de tabla de menu:
    public int getSelectedTabIndex() {
        return JTabbedPaneMenu.getSelectedIndex();
    }

    //Manipulacion de tabla global para funcionalidades: Modificaciones | Eliminaciones
    public javax.swing.JTable getTablaActiva() {
        switch (JTabbedPaneMenu.getSelectedIndex()) {
            case 0:
                return TblServicioUno;
            case 1:
                return TblServicioDos;
            case 2:
                return TblServicioTres;
            case 3:
                return TblEmpleados;
            case 4:
                return TblClientes;
            default:
                return null;
        }
    }

    // ====================================
    // CARGA DE TABLAS | REFRESCO
    // ====================================
    // REGISTROS ESPECFICOS | SERVICIO 01 | VENTA / RESERVA DE AUTOS
    public void cargarServicio01Ops() {
        try {
            DAOReservaServUno daoRsun = new DAOReservaServUnoIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblServicioUno.getModel();
            model.setRowCount(0);
            daoRsun.listarReservaServUno().forEach((u) -> model.addRow(new Object[]{
                u.getID_ReservaServUno(),
                u.getID_Auto(),
                u.getDNI_Cliente(),
                u.getEstado_ReservaServUno(),
                u.getFecha_ReservaServUno()
            })
            );
            TblServicioUno.setDefaultEditor(Object.class, null);
            TblServicioUno.getTableHeader().setResizingAllowed(false);
            TblServicioUno.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
            System.out.println("Error en la carga de operaciones del servicio 1");
        }
    }

    // REGISTROS ESPECFICOS | SERVICIO 02 | VENTA / RESERVA DE AUTOPARTES
    public void cargarServicio02Ops() {
        try {
            DAOReservaServDos daoRsD = new DAOReservaServDosIMPLEMENT();
            List<ReservaServDos> listarReservServDos = daoRsD.listarReservasServDos();

            DefaultTableModel model = (DefaultTableModel) TblServicioDos.getModel();
            model.setRowCount(0);
            for (ReservaServDos r : listarReservServDos) {
                model.addRow(new Object[]{
                    r.getID_ReservaServDos(),
                    r.getID_Autoparte(),
                    r.getDNI_Cliente(),
                    r.getEstado_ReservaServDos(),
                    r.getFecha_ReservaServDos()
                });
            }
            TblServicioDos.setDefaultEditor(Object.class, null);
            TblServicioDos.getTableHeader().setResizingAllowed(false);
            TblServicioDos.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // REGISTROS ESPECFICOS | SERVICIO 03 | RESERVA DE MANTENIMIENTO (VEHICULOS: TESLA | OTRA MARCA)
    public void cargarServicio03Ops() {
        try {
            DAOReservaServTres daoRsT = new DAOReservaServTresIMPLEMENT();
            List<ReservaServTres> listarReservaServTres = daoRsT.listarReservaServTres();

            DefaultTableModel model = (DefaultTableModel) TblServicioTres.getModel();
            model.setRowCount(0);
            for (ReservaServTres r : listarReservaServTres) {
                model.addRow(new Object[]{
                    r.getIdReserva(),
                    r.getTipoVehiculo(),
                    r.getServicioSolicitado(),
                    r.getDniCliente(),
                    r.getFechaCita(),
                    r.getPrecio(),
                    r.getDniEmpleado() == null ? "No asignado" : r.getDniEmpleado()
                });
            }
            TblServicioTres.setModel(model);
            centradoContenidoTabla(TblServicioTres);

            TblServicioTres.setDefaultEditor(Object.class, null);
            TblServicioTres.getTableHeader().setResizingAllowed(false);
            TblServicioTres.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // REGISTROS GENERALES | EMPLEADOS
    public void cargarEmpleados() {
        try {
            DAOEmpleado daoA = new DAOEmpleadosIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblEmpleados.getModel();
            model.setRowCount(0);
            daoA.listarEmpleado("").forEach((u) -> model.addRow(new Object[]{
                u.getID_Empleado(),
                u.getNombre_Empleado(),
                u.getDNI_Empleado(),
                u.getTelefono_Empleado(),
                u.getFechaContratacion_Empleado(),
                u.getCargo_Empleado()})
            );
            TblEmpleados.setDefaultEditor(Object.class, null);
            TblEmpleados.getTableHeader().setResizingAllowed(false);
            TblEmpleados.getTableHeader().setReorderingAllowed(false);

        } catch (Exception e) {
            System.out.println("Error en la carga de empleados: " + e.getMessage());
        }
    }

    // REGISTROS GENERALES | CLIENTES
    public void cargarClientes() {
        try {
            DAOCliente daoCl = new DAOClienteIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblClientes.getModel();
            model.setRowCount(0);

            for (Cliente u : daoCl.listarCliente("")) {
                if (Sesion.esCliente()) {
                    Cliente clienteActual = Sesion.clienteLogueado;

                    if (clienteActual == null || !u.getDNI_Cliente().equals(clienteActual.getDNI_Cliente())) {
                        continue;
                    }
                }
                // Mostrar el cliente (ya sea por filtro o admin)
                model.addRow(new Object[]{
                    u.getID_Cliente(),
                    u.getNombre_Cliente(),
                    u.getSegundoNombre_Cliente(),
                    u.getApellido_Cliente(),
                    u.getDNI_Cliente(),
                    u.getCorreo_Cliente(),
                    u.getTelefono_Cliente(),
                    u.getSegundoTelefono_Cliente()
                });
            }
            TblClientes.setDefaultEditor(Object.class, null);
            TblClientes.getTableHeader().setResizingAllowed(false);
            TblClientes.getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
            System.out.println("Error en la carga de clientes: " + e.getMessage());
        }
    }

    // ====================================
    // FUNCIONALIDADES
    // ====================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        LblTitulo = new javax.swing.JLabel();
        LblSubtitulo = new javax.swing.JLabel();
        JTabbedPaneMenu = new javax.swing.JTabbedPane();
        JSPRegistroAutos = new javax.swing.JScrollPane();
        TblServicioUno = new javax.swing.JTable();
        JSPRegistroAutopartes = new javax.swing.JScrollPane();
        TblServicioDos = new javax.swing.JTable();
        JSPRegistroMantenimiento = new javax.swing.JScrollPane();
        TblServicioTres = new javax.swing.JTable();
        JSPRegistroEmpleados = new javax.swing.JScrollPane();
        TblEmpleados = new javax.swing.JTable();
        JSPRegistroCliente = new javax.swing.JScrollPane();
        TblClientes = new javax.swing.JTable();
        BtnModificarAuto = new javax.swing.JButton();
        BtnEliminarAuto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        LblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        LblTitulo.setText("GESTION GENERAL DE SERVICIOS | RESERVAS");

        LblSubtitulo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblSubtitulo.setText("Panel de informacion de los registros que se hicieron de las operaciones en el sistema.");

        TblServicioUno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblServicioUno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR DE SERVICIO:", "IDENTIFICADOR DE AUTO: ", "IDENTIFICADOR DE CLIENTE:", "CONDICION DE RESERVA:", "FECHA DE OPERACION:"
            }
        ));
        JSPRegistroAutos.setViewportView(TblServicioUno);

        JTabbedPaneMenu.addTab("AUTOS", JSPRegistroAutos);

        TblServicioDos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblServicioDos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR DE SERVICIO:", "IDENTIFICADOR DE AUTOPARTE:", "IDENTIFICADOR DE CLIENTE:", "CONDICION DE RESERVA:", "FECHA DE OPERACION:"
            }
        ));
        JSPRegistroAutopartes.setViewportView(TblServicioDos);

        JTabbedPaneMenu.addTab("AUTOPARTES", JSPRegistroAutopartes);

        TblServicioTres.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblServicioTres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR DE SERVICIO:", "TIPO DE VEHICULO:", "TIPO DE SERVICIO:", "IDENTIFICADOR DE CLIENTE:", "FECHA PREVISTA:", "PRECIO DE SERVICIO:", "IDENTIFICACION DE EMPLEADO:"
            }
        ));
        JSPRegistroMantenimiento.setViewportView(TblServicioTres);

        JTabbedPaneMenu.addTab("MANTENIMIENTO", JSPRegistroMantenimiento);

        TblEmpleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR:", "NOMBRE DE CLIENTE:", "DNI IDENTIFICADOR:", "TELEFONO DE CONTACTO:", "CONTRATACION:", "CARGO DE EMPLEADO:"
            }
        ));
        JSPRegistroEmpleados.setViewportView(TblEmpleados);

        JTabbedPaneMenu.addTab("EMPLEADOS", JSPRegistroEmpleados);

        TblClientes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR:", "PRIMER NOMBRE:", "SEGUNDO NOMBRE:", "APELLIDO:", "CREDENCIAL | DNI:", "CORREO ELECTRONICO:", "TELEFONO PRINCIPAL:", "TELEF. SECUNDARIO:"
            }
        ));
        JSPRegistroCliente.setViewportView(TblClientes);

        JTabbedPaneMenu.addTab("CLIENTES", JSPRegistroCliente);

        BtnModificarAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnModificarAuto.setText("MODIFICAR");
        BtnModificarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarAutoActionPerformed(evt);
            }
        });

        BtnEliminarAuto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        BtnEliminarAuto.setText("ELIMINAR");
        BtnEliminarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarAutoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("|");

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
            .addComponent(JTabbedPaneMenu)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(LblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnModificarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminarAuto)))
                .addContainerGap())
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(JTabbedPaneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModificarAuto)
                    .addComponent(BtnEliminarAuto)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void BtnEliminarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarAutoActionPerformed
    //Invocacion de funcionalidad encapsulada:
    AdminCtrllr.eliminarRegistro();
}//GEN-LAST:event_BtnEliminarAutoActionPerformed

private void BtnModificarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarAutoActionPerformed
    //Invocacion de funcionalidad encapsulada:
    AdminCtrllr.modificarRegistro();
}//GEN-LAST:event_BtnModificarAutoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminarAuto;
    private javax.swing.JButton BtnModificarAuto;
    private javax.swing.JScrollPane JSPRegistroAutopartes;
    private javax.swing.JScrollPane JSPRegistroAutos;
    private javax.swing.JScrollPane JSPRegistroCliente;
    private javax.swing.JScrollPane JSPRegistroEmpleados;
    private javax.swing.JScrollPane JSPRegistroMantenimiento;
    private javax.swing.JTabbedPane JTabbedPaneMenu;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JTable TblClientes;
    private javax.swing.JTable TblEmpleados;
    private javax.swing.JTable TblServicioDos;
    private javax.swing.JTable TblServicioTres;
    private javax.swing.JTable TblServicioUno;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
