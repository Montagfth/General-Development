package Administrative;

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

    public panelAdministrator() {
        initComponents();
        cargarEmpleados();
        cargarClientes();
        cargarOperacionesAuto();
        cargarSolicitudesAutoparte();
        cargarReservaServicioTres();

        //====================================
        //Centrado de contenido:
        //====================================
        DefaultTableCellRenderer centradoContenido = new DefaultTableCellRenderer();
        centradoContenido.setHorizontalAlignment(SwingConstants.CENTER);

        //Tabla Clientes:
        for (int i = 0; i < TblClientes.getColumnCount(); i++) {
            TblClientes.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }

        //Tabla Empleados:
        for (int i = 0; i < TblEmpleados.getColumnCount(); i++) {
            TblEmpleados.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }

        //Tabla Servicio 1 | Autos
        for (int i = 0; i < TblServicioUno.getColumnCount(); i++) {
            TblServicioUno.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }

        //Tabla Servicio 2 | Autopartes
        for (int i = 0; i < TblServicioDos.getColumnCount(); i++) {
            TblServicioDos.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }

        //Tabla Servicio 3 | Mantenimiento
        for (int i = 0; i < TblServicioTres.getColumnCount(); i++) {
            TblServicioTres.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }
        //====================================

        //Ajuste de unica seleccion:
        TblServicioUno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblServicioDos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblServicioTres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

    //Metodo de reutilizacion de centrado de contenido de filas:
    public void centradoContenidoTabla(JTable tabla) {
        DefaultTableCellRenderer centradoContenido = new DefaultTableCellRenderer();
        centradoContenido.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centradoContenido);
        }
        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void cargarReservaServicioTres() {

        try {
            DAOReservaServTres daoRsT = new DAOReservaServTresIMPLEMENT();
            List<ReservaServTres> listarReservaServTres = daoRsT.listarReservaServTres();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"IDENTIFICADOR DE SERVICIO:", "TIPO DE VEHICULO:", "TIPO DE SERVICIO:", "IDENTIFICADOR DE CLIENTE:", "FECHA PREVISTA:", "PRECIO DE SERVICIO:", "IDENTIFICACION DE EMPLEADO:"});

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

    public void cargarSolicitudesAutoparte() {

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

    public void cargarOperacionesAuto() {

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

    public void cargarClientes() {

        try {

            DAOCliente daoCl = new DAOClienteIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblClientes.getModel();
            model.setRowCount(0);
            daoCl.listarCliente("").forEach((u) -> model.addRow(new Object[]{
                u.getID_Cliente(),
                u.getNombre_Cliente(),
                u.getSegundoNombre_Cliente(),
                u.getApellido_Cliente(),
                u.getDNI_Cliente(),
                u.getCorreo_Cliente(),
                u.getTelefono_Cliente(),
                u.getSegundoTelefono_Cliente()})
            );

            TblClientes.setDefaultEditor(Object.class, null);
            TblClientes.getTableHeader().setResizingAllowed(false);
            TblClientes.getTableHeader().setReorderingAllowed(false);

        } catch (Exception e) {
            System.out.println("Error en la carga de clientes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        LblTitulo = new javax.swing.JLabel();
        LblSubtitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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

        jTabbedPane1.addTab("AUTOS", JSPRegistroAutos);

        TblServicioDos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblServicioDos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR DE SERVICIO:", "IDENTIFICADOR DE AUTOPARTE:", "IDENTIFICADOR DE CLIENTE:", "CONDICION DE RESERVA:", "FECHA DE OPERACION:"
            }
        ));
        JSPRegistroAutopartes.setViewportView(TblServicioDos);

        jTabbedPane1.addTab("AUTOPARTES", JSPRegistroAutopartes);

        TblServicioTres.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblServicioTres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JSPRegistroMantenimiento.setViewportView(TblServicioTres);

        jTabbedPane1.addTab("MANTENIMIENTO", JSPRegistroMantenimiento);

        TblEmpleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR:", "NOMBRE DE CLIENTE:", "DNI IDENTIFICADOR:", "TELEFONO DE CONTACTO:", "CONTRATACION:", "CARGO DE EMPLEADO:"
            }
        ));
        JSPRegistroEmpleados.setViewportView(TblEmpleados);

        jTabbedPane1.addTab("EMPLEADOS", JSPRegistroEmpleados);

        TblClientes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR:", "PRIMER NOMBRE:", "SEGUNDO NOMBRE:", "APELLIDO:", "CREDENCIAL | DNI:", "CORREO ELECTRONICO:", "TELEFONO PRINCIPAL:", "TELEF. SECUNDARIO:"
            }
        ));
        JSPRegistroCliente.setViewportView(TblClientes);

        jTabbedPane1.addTab("CLIENTES", JSPRegistroCliente);

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

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(LblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnModificarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModificarAuto)
                    .addComponent(BtnEliminarAuto))
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
    int selectedIndex = jTabbedPane1.getSelectedIndex();
    javax.swing.JTable tablaActiva = getTablaActiva();

    if (tablaActiva == null) {
        JOptionPane.showMessageDialog(this, "No hay tabla seleccionada", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int fila = tablaActiva.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmar = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el registro?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);
    if (confirmar != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        int idRegistro = (int) tablaActiva.getValueAt(fila, 0);

        switch (selectedIndex) {
            case 0: // AUTOS
                DAOReservaServUno daoRsU = new DAOReservaServUnoIMPLEMENT();
                daoRsU.eliminar(idRegistro);
                cargarOperacionesAuto();
                break;
            case 1: // AUTOPARTES
                DAOReservaServDos daoRsD = new DAOReservaServDosIMPLEMENT();
                daoRsD.eliminar(idRegistro);
                cargarSolicitudesAutoparte();
                break;
            case 2: // MANTENIMIENTO
                //Liberacion del empleado
                String dniEmpleado = TblEmpleados.getValueAt(fila, 2).toString().trim();
                DAOEmpleado daoEmpl = new DAOEmpleadosIMPLEMENT();
                daoEmpl.liberarEmpleadoPorDNI(dniEmpleado);
                
                //Eliminacion del registro | reserva de mantenimiento
                DAOReservaServTres daoRsT = new DAOReservaServTresIMPLEMENT();
                daoRsT.eliminar(idRegistro);
                cargarReservaServicioTres();
                break;
            case 3: // EMPLEADOS
                DAOEmpleado daoEmp = new DAOEmpleadosIMPLEMENT();
                daoEmp.eliminarEmpleado(idRegistro);
                cargarEmpleados();
                break;
            case 4: // CLIENTES
                DAOCliente daoCli = new DAOClienteIMPLEMENT();
                daoCli.eliminar(idRegistro);
                cargarClientes();
                break;
            default:
                JOptionPane.showMessageDialog(this, "No se reconoce la pestaña activa", "Tesla Inc.", JOptionPane.ERROR_MESSAGE);
                return;
        }

        JOptionPane.showMessageDialog(this, "Se ha eliminado correctamente", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Tesla Inc.", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_BtnEliminarAutoActionPerformed

private void BtnModificarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarAutoActionPerformed
    int selectedIndex = jTabbedPane1.getSelectedIndex();
    javax.swing.JTable tablaActiva = getTablaActiva();

    if (tablaActiva == null) {
        JOptionPane.showMessageDialog(this, "No hay tabla seleccionada", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int fila = tablaActiva.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        switch (selectedIndex) {
            case 0: { // AUTOS
                int idReservaAuto = (int) tablaActiva.getValueAt(fila, 0);
                String estadoActualAuto = tablaActiva.getValueAt(fila, 3).toString();
                String fechaActualAuto = tablaActiva.getValueAt(fila, 4).toString();

                DialogEditarReservaAuto dialogAuto = new DialogEditarReservaAuto(null, idReservaAuto, estadoActualAuto, fechaActualAuto);
                dialogAuto.setVisible(true);
                cargarOperacionesAuto();
                break;
            }
            case 1: { // AUTOPARTES
                int idReservaAutoparte = (int) tablaActiva.getValueAt(fila, 0);
                String estadoActualAutoparte = tablaActiva.getValueAt(fila, 3).toString();
                String fechaActualAutoparte = tablaActiva.getValueAt(fila, 4).toString();

                DialogEditarReservaAutoparte dialogAutoparte = new DialogEditarReservaAutoparte(null, idReservaAutoparte, estadoActualAutoparte, fechaActualAutoparte);
                dialogAutoparte.setVisible(true);
                cargarSolicitudesAutoparte();
                break;
            }
            case 2: { // MANTENIMIENTO
                int idReservaMantenimiento = (int) tablaActiva.getValueAt(fila, 0);
                String fechaActualMantenimiento = tablaActiva.getValueAt(fila, 4).toString();

                DialogEditarReservaServMantenimiento dialogMantenimiento = new DialogEditarReservaServMantenimiento(null, idReservaMantenimiento, fechaActualMantenimiento);
                dialogMantenimiento.setVisible(true);
                cargarReservaServicioTres();
                break;
            }
            case 3: { // EMPLEADOS
                int idEmpleado = (int) tablaActiva.getValueAt(fila, 0);
                String nombreEmpleado = tablaActiva.getValueAt(fila, 1).toString();
                String dniEmpleado = tablaActiva.getValueAt(fila, 2).toString();
                String telefonoEmpleado = tablaActiva.getValueAt(fila, 3).toString();

                DialogEditarEmpleado dialogEmpleado = new DialogEditarEmpleado(null, idEmpleado, nombreEmpleado, dniEmpleado, telefonoEmpleado);
                dialogEmpleado.setVisible(true);
                cargarEmpleados();
                break;
            }
            case 4: { // CLIENTES
                Cliente cliente = new Cliente();
                cliente.setID_Cliente((int) tablaActiva.getValueAt(fila, 0));
                cliente.setNombre_Cliente(tablaActiva.getValueAt(fila, 1).toString());
                cliente.setSegundoNombre_Cliente(tablaActiva.getValueAt(fila, 2).toString());
                cliente.setApellido_Cliente(tablaActiva.getValueAt(fila, 3).toString());
                cliente.setDNI_Cliente(tablaActiva.getValueAt(fila, 4).toString());
                cliente.setCorreo_Cliente(tablaActiva.getValueAt(fila, 5).toString());
                cliente.setTelefono_Cliente(tablaActiva.getValueAt(fila, 6).toString());
                cliente.setSegundoTelefono_Cliente(tablaActiva.getValueAt(fila, 7).toString());

                DialogEditarCliente dialogCliente = new DialogEditarCliente(null, cliente);
                dialogCliente.setVisible(true);
                cargarClientes();
                break;
            }
            default:
                JOptionPane.showMessageDialog(this, "No se reconoce la pestaña activa", "Tesla Inc.", JOptionPane.ERROR_MESSAGE);
                break;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al modificar: " + e.getMessage(), "Tesla Inc.", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_BtnModificarAutoActionPerformed

    private javax.swing.JTable getTablaActiva() {
        switch (jTabbedPane1.getSelectedIndex()) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminarAuto;
    private javax.swing.JButton BtnModificarAuto;
    private javax.swing.JScrollPane JSPRegistroAutopartes;
    private javax.swing.JScrollPane JSPRegistroAutos;
    private javax.swing.JScrollPane JSPRegistroCliente;
    private javax.swing.JScrollPane JSPRegistroEmpleados;
    private javax.swing.JScrollPane JSPRegistroMantenimiento;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JTable TblClientes;
    private javax.swing.JTable TblEmpleados;
    private javax.swing.JTable TblServicioDos;
    private javax.swing.JTable TblServicioTres;
    private javax.swing.JTable TblServicioUno;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
