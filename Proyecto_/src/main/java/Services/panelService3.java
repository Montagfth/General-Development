package Services;

import Administrative.panelAdministrator;
import Services.*;
import DatabaseModels.ReservaServTres;
import DatabaseModels.Sesion;
import Interfaces.DAOEmpleado;
import Interfaces.DAOReservaServTres;
import Model.DAOEmpleadosIMPLEMENT;
import Model.DAOReservaServTresIMPLEMENT;
import Panels.panelInformativo;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.swing.JPanel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import com.formdev.flatlaf.util.FlatClientProperties;

/**
 *
 * @author Fabrizio
 */
public class panelService3 extends javax.swing.JPanel {

    /**
     * Creates new form panelService3
     */
    public panelService3() {
        initComponents();
        JTFContenedorPrecio.setText("0.00");
        JTFContenedorPrecio.setEditable(false);
        configurarListenerPestana();
        configurarTextArea();
        estilosPanelServicio03TESLA();
        estilosPanelServicio03OTROS();
    }

    public void estilosGeneralesPanelServicio03() {
        //Color de boton:
        BtnRegistrarCita.setBackground(new Color(51, 51, 51));
        //Color de texto dentro de 
    }

    public void estilosPanelServicio03TESLA() {
        JTFServicioTesla02.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioTesla03.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioTesla04.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioTesla05.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioTesla06.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
    }

    public void estilosPanelServicio03OTROS() {
        JTFServicioOtro02.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioOtro03.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioOtro04.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Aqui.");
        JTFServicioOtro05.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Aqui.");
        JTFServicioOtro06.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioOtro07.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
        JTFServicioOtro08.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Completar aqui.");
    }

    public void mostrarPaneles(JPanel panel) {
        panel.setSize(1194, 694);
        panel.setLocation(0, 0);

        PnlContenedorGeneral.removeAll();
        PnlContenedorGeneral.add(panel, BorderLayout.CENTER);
        PnlContenedorGeneral.revalidate();
        PnlContenedorGeneral.repaint();
    }

    /**
     * Configura el JTextArea para mostrar el resumen
     */
    private void configurarTextArea() {
        jTextArea1.setEditable(false);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("Aquí se mostrará el resumen de la cita una vez registrada...");
    }

    /**
     * Configura el listener para el cambio de pestaña
     */
    private void configurarListenerPestana() {
        jTabbedPane1.addChangeListener(e -> actualizarPrecio());
    }

    /**
     * Obtiene el tipo de vehículo basado en la pestaña activa
     */
    private String obtenerTipoVehiculo() {
        int pestanaActiva = jTabbedPane1.getSelectedIndex();
        return pestanaActiva == 0 ? "TESLA" : "OTRO VEHICULO";
    }

    /**
     * Fechas programadas - método para implementar fechas dinámicas
     */
    public void fechasProgramadas() {
        /*
        //NOTA: Antes de implementar el metodo, buscar la forma en la cual la fecha adquiera diferentes
        //      valores, no solo uno parametrizado.
        // Obten el modelo de tu tabla
        DefaultTableModel model = (DefaultTableModel) TblFechasContenido.getModel();

        // Limpia la tabla por si tenia datos anteriores
        model.setRowCount(0);

        // --- EJEMPLO DE CÓMO AGREGAR UNA FILA CON UNA FECHA ESPECÍFICA ---
        // 1. Crea la fecha que necesites (Año, Mes, Día)
        LocalDate fechaMantenimiento = LocalDate.of(2025, 5, 20);

        // 2. Crea un formateador para mostrar la fecha como "día/mes/año"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 3. Convierte la fecha a un String con el formato deseado
        String fechaFormateada = fechaMantenimiento.format(formatter);

        // 4. Agrega la fila a la tabla con la fecha ya formateada
        //NOTA: Por analizar ya que debe estar en relacion con otras tablas.
        model.addRow(new Object[]{
            "M001", // ID
            "AUT-123", // IDAuto
            "EMP-01", // IDEmpleado
            fechaFormateada, // Fecha (String)
            "Cambio de aceite sintético", // Descripción
            250.00 // Costo
        });

        /*
        // --- OTRO EJEMPLO CON LA FECHA ACTUAL ---
        LocalDate fechaActual = LocalDate.now();
        String fechaActualFormateada = fechaActual.format(formatter);
        model.addRow(new Object[]{
            "M002", "AUT-456", "EMP-02", fechaActualFormateada, "Revisión de neumáticos", 80.00
        });
         */
    }

    /**
     * Actualiza el precio basado en la pestaña activa y el servicio
     * seleccionado
     */
    private void actualizarPrecio() {
        String tipo = obtenerTipoVehiculo();
        String srv = "";

        if (tipo.equals("TESLA")) {
            srv = CbxServicioTesla01.getSelectedItem() != null
                    ? CbxServicioTesla01.getSelectedItem().toString()
                    : "";
        } else {
            srv = CbxServicioOtro01.getSelectedItem() != null
                    ? CbxServicioOtro01.getSelectedItem().toString()
                    : "";
        }

        double precio = 0.0;

        if (tipo.equals("TESLA")) {
            switch (srv) {
                case "SISTEMA DE REFRIGERACION":
                    precio = 510.0;
                    break;
                case "REVISION DE FRENOS":
                    precio = 420.50;
                    break;
                case "SISTEMA ELECTRICO":
                    precio = 690.00;
                    break;
                case "REVISION DE BATERIA":
                    precio = 900.00;
                    break;
                case "ITV":
                    precio = 1200.00;
                    break;
                default:
                    precio = 0.00;
                    break;
            }
        } else {
            switch (srv) {
                case "MANTENIMIENTO GENERAL":
                    precio = 210.00;
                    break;
                case "REVISION DE BATERIA":
                    precio = 120.50;
                    break;
                case "CHEQUEO DE FRENOS":
                    precio = 590.00;
                    break;
                case "INSPECCION ELECTRICA":
                    precio = 1900.00;
                    break;
                case "DIAGNOSTICO COMPLETO":
                    precio = 1400.00;
                    break;
                default:
                    precio = 0.00;
                    break;
            }
        }

        JTFContenedorPrecio.setText(String.format("%.2f", precio));
    }

    /**
     * Muestra el resumen de la cita en el JTextArea
     */
    //Ajuste estetico en JTextArea:
    private void mostrarResumen(ReservaServTres reserva) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("══════════════════════════════════════════════\n");
        resumen.append("\t              RESUMEN/COMPROBACION | RESERVA\n");
        resumen.append("══════════════════════════════════════════════\n\n");

        resumen.append("Cliente: ").append(Sesion.clienteLogueado.getDNI_Cliente()).append("\n");
        resumen.append("Tipo de Vehículo: ").append(reserva.getTipoVehiculo()).append("\n");
        resumen.append("Servicio Solicitado: ").append(reserva.getServicioSolicitado()).append("\n");
        resumen.append("Precio: S/. ").append(reserva.getPrecio()).append("\n");
        resumen.append("Fecha de Cita: ").append(reserva.getFechaCita().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n\n");

        if (reserva.getTipoVehiculo().equals("TESLA")) {
            resumen.append("══════════════════════════════════════════════\n");
            resumen.append("\t              DETALLES DEL VEHICULO | TESLA\n");
            resumen.append("══════════════════════════════════════════════\n\n");
            resumen.append("Número de Motor: ").append(reserva.getNumeroMotor() != null ? reserva.getNumeroMotor() : "N/A").append("\n");
            resumen.append("Número de Serie: ").append(reserva.getNumeroSerie() != null ? reserva.getNumeroSerie() : "N/A").append("\n");
            if (reserva.getKilometraje() != null) {
                resumen.append("Kilometraje: ").append(reserva.getKilometraje()).append(" km\n");
            }
            if (reserva.getObservacion() != null && !reserva.getObservacion().isEmpty()) {
                resumen.append("Observaciones: ").append(reserva.getObservacion()).append("\n");
            }
        } else {
            resumen.append("══════════════════════════════════════════════\n");
            resumen.append("\t          DETALLES DEL VEHÍCULO | OTRO\n");
            resumen.append("══════════════════════════════════════════════\n");
            resumen.append("Marca: ").append(reserva.getMarcaVehiculo() != null ? reserva.getMarcaVehiculo() : "N/A").append("\n");
            resumen.append("Modelo: ").append(reserva.getModeloVehiculo() != null ? reserva.getModeloVehiculo() : "N/A").append("\n");
            if (reserva.getAnioVehiculo() != null) {
                resumen.append("Año: ").append(reserva.getAnioVehiculo()).append("\n");
            }
            resumen.append("Tipo de Motor: ").append(reserva.getTipoMotor() != null ? reserva.getTipoMotor() : "N/A").append("\n");
            if (reserva.getKilometraje() != null) {
                resumen.append("Kilometraje: ").append(reserva.getKilometraje()).append(" km\n");
            }
            if (reserva.getObservacion() != null && !reserva.getObservacion().isEmpty()) {
                resumen.append("Observaciones: ").append(reserva.getObservacion()).append("\n\n");
            }
        }

        resumen.append("\n══════════════════════════════════════════════\n");
        resumen.append("\t              DETALLES ADICIONALES\n");
        resumen.append("══════════════════════════════════════════════\n\n");
        resumen.append("Empleado asignado: ").append(reserva.getDniEmpleado()).append("\n");
        resumen.append("Fecha de registro: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        jTextArea1.setText(resumen.toString());
    }

    /**
     * Limpia el formulario después de registrar
     */
    private void limpiarFormulario() {
        // Limpiar campos de Tesla
        if (CbxServicioTesla01.getItemCount() > 0) {
            CbxServicioTesla01.setSelectedIndex(0);
        }
        JTFServicioTesla02.setText("");
        JTFServicioTesla03.setText("");
        JTFServicioTesla04.setText("");
        JTFServicioTesla05.setText("");
        JTFServicioTesla06.setText("");

        // Limpiar campos de Otros vehículos
        if (CbxServicioOtro01.getItemCount() > 0) {
            CbxServicioOtro01.setSelectedIndex(0);
        }
        JTFServicioOtro02.setText("");
        JTFServicioOtro03.setText("");
        JTFServicioOtro04.setText("");
        JTFServicioOtro05.setText("");
        JTFServicioOtro06.setText("");
        JTFServicioOtro07.setText("");
        JTFServicioOtro08.setText("");

        // Limpiar precio
        JTFContenedorPrecio.setText("0.00");
    }

    /**
     * Valida los campos antes de registrar
     */
    //Evaluar condicional de autenticacion de todos los campos vacios generales:
    private boolean validarCampos() {
        String tipo = obtenerTipoVehiculo();
        StringBuilder errores = new StringBuilder();

        if (tipo.equals("TESLA")) {
            if (JTFServicioTesla02.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El número de motor es requerido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (JTFServicioTesla03.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El número de serie es requerido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (JTFServicioTesla06.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "La fecha de cita es requerida", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            if (JTFServicioOtro02.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "La marca del vehículo es requerida", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (JTFServicioOtro03.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El modelo del vehículo es requerido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (JTFServicioOtro07.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "La fecha de cita es requerida", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(null, "Por favor, debe completar los siguientes campos:\n\n" + errores.toString(), "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        LblSubtitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        LblServicioTesla01 = new javax.swing.JLabel();
        CbxServicioTesla01 = new javax.swing.JComboBox<>();
        LblServicioTesla02 = new javax.swing.JLabel();
        JTFServicioTesla02 = new javax.swing.JTextField();
        LblServicioTesla03 = new javax.swing.JLabel();
        JTFServicioTesla03 = new javax.swing.JTextField();
        LblServicioTesla04 = new javax.swing.JLabel();
        JTFServicioTesla04 = new javax.swing.JTextField();
        LblServicioTesla05 = new javax.swing.JLabel();
        JTFServicioTesla05 = new javax.swing.JTextField();
        LblServicioTesla06 = new javax.swing.JLabel();
        JTFServicioTesla06 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LblServicioOtro01 = new javax.swing.JLabel();
        CbxServicioOtro01 = new javax.swing.JComboBox<>();
        LblServicioOtro02 = new javax.swing.JLabel();
        JTFServicioOtro02 = new javax.swing.JTextField();
        LblServicioOtro03 = new javax.swing.JLabel();
        JTFServicioOtro03 = new javax.swing.JTextField();
        LblServicioOtro04 = new javax.swing.JLabel();
        JTFServicioOtro04 = new javax.swing.JTextField();
        JTFServicioOtro05 = new javax.swing.JTextField();
        LblServicioOtro05 = new javax.swing.JLabel();
        LblServicioOtro06 = new javax.swing.JLabel();
        JTFServicioOtro06 = new javax.swing.JTextField();
        JTFServicioOtro07 = new javax.swing.JTextField();
        LblServicioOtro07 = new javax.swing.JLabel();
        JTFServicioOtro08 = new javax.swing.JTextField();
        LblServicioOtro08 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LblPrecioServicio = new javax.swing.JLabel();
        JTFContenedorPrecio = new javax.swing.JTextField();
        LblInformativo = new javax.swing.JLabel();
        BtnRegistrarCita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        LblInformativo1 = new javax.swing.JLabel();
        LblNotaInformativa1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        LblSubtitulo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblSubtitulo.setText("Servicio de mantemiento dedicado para vehiculos:");

        LblServicioTesla01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioTesla01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioTesla01.setText("SELECCIONE UN TIPO DE SERVICIO:");

        CbxServicioTesla01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CbxServicioTesla01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "SISTEMA DE REFRIGERACION", "SISTEMA ELECTRICO", "REVISION DE FRENOS", "REVISION DE BATERIA", "ITV" }));
        CbxServicioTesla01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxServicioTesla01ActionPerformed(evt);
            }
        });

        LblServicioTesla02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioTesla02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioTesla02.setText("INGRESE EL NUMERO DE MOTOR:");

        JTFServicioTesla02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioTesla02.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioTesla03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioTesla03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioTesla03.setText("INGRESE EL NUMERO DE SERIE:");

        JTFServicioTesla03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioTesla03.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioTesla04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioTesla04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioTesla04.setText("INGRESE EL KILOMETRAJE ACTUAL:");

        JTFServicioTesla04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioTesla04.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioTesla05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioTesla05.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblServicioTesla05.setText("INGRESE ALGUNA OBSERVACION EXTRA:");

        JTFServicioTesla05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioTesla05.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioTesla06.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioTesla06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioTesla06.setText("INGRESE UNA FECHA DE SUGERENCIA:");

        JTFServicioTesla06.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioTesla06.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("(YYYY-MM-DD) (AÑO-MES-DIA)");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("(OPCIONAL)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblServicioTesla01, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblServicioTesla02, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblServicioTesla03, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblServicioTesla04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblServicioTesla05, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblServicioTesla06, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbxServicioTesla01, 0, 1, Short.MAX_VALUE)
                    .addComponent(JTFServicioTesla04)
                    .addComponent(JTFServicioTesla05)
                    .addComponent(JTFServicioTesla06)
                    .addComponent(JTFServicioTesla03, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTFServicioTesla02, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioTesla01)
                    .addComponent(CbxServicioTesla01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioTesla02)
                    .addComponent(JTFServicioTesla02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioTesla03)
                    .addComponent(JTFServicioTesla03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioTesla04)
                    .addComponent(JTFServicioTesla04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioTesla05)
                    .addComponent(JTFServicioTesla05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblServicioTesla06)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(JTFServicioTesla06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VEHICULOS TESLA", jPanel1);

        LblServicioOtro01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro01.setText("SELECCIONE EL TIPO DE SERVICIO:");

        CbxServicioOtro01.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CbxServicioOtro01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "MANTENIMIENTO GENERAL", "REVISION DE BATERIA", "CHEQUEO DE FRENOS", "INSPECCION ELECTRICA", "DIAGNOSTICO COMPLETO" }));
        CbxServicioOtro01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxServicioOtro01ActionPerformed(evt);
            }
        });

        LblServicioOtro02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro02.setText("INGRESE LA MARCA DEL VEHICULO");

        JTFServicioOtro02.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro02.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioOtro03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro03.setText("INGRESE EL MODELO DEL VEHICULO:");

        JTFServicioOtro03.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro03.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioOtro04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro04.setText("INGRESE EL AÑO:");

        JTFServicioOtro04.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro04.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFServicioOtro04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFServicioOtro04ActionPerformed(evt);
            }
        });

        JTFServicioOtro05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro05.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFServicioOtro05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFServicioOtro05ActionPerformed(evt);
            }
        });

        LblServicioOtro05.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro05.setText("INGRESE EL TIPO DE MOTOR:");

        LblServicioOtro06.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro06.setText("INGRESE EL KILOMETRAJE ACTUAL:");

        JTFServicioOtro06.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro06.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTFServicioOtro07.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro07.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioOtro07.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro07.setText("INGRESE UNA FECHA DE SUGERENCIA:");

        JTFServicioOtro08.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JTFServicioOtro08.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        LblServicioOtro08.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        LblServicioOtro08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblServicioOtro08.setText("INGRESE AGUNA OBSERVACION EXTRA:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(YYYY-MM-DD) (AÑO-MES-DIA)");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("(OPCIONAL)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblServicioOtro08))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFServicioOtro08, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblServicioOtro07, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFServicioOtro07)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(LblServicioOtro03)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFServicioOtro03))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(LblServicioOtro04)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFServicioOtro04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(LblServicioOtro05)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFServicioOtro05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LblServicioOtro02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblServicioOtro01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CbxServicioOtro01, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JTFServicioOtro02)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(LblServicioOtro06, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFServicioOtro06, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioOtro01)
                    .addComponent(CbxServicioOtro01, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioOtro02)
                    .addComponent(JTFServicioOtro02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioOtro03)
                    .addComponent(JTFServicioOtro03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioOtro04)
                    .addComponent(JTFServicioOtro04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblServicioOtro05)
                    .addComponent(JTFServicioOtro05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblServicioOtro06)
                    .addComponent(JTFServicioOtro06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblServicioOtro07)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(JTFServicioOtro07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFServicioOtro08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblServicioOtro08)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("OTROS VEHICULOS", jPanel2);

        LblPrecioServicio.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblPrecioServicio.setText("PRECIO DEL SERVICIO SELECCIONADO: $");

        JTFContenedorPrecio.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        JTFContenedorPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFContenedorPrecio.setEnabled(false);

        LblInformativo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblInformativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblInformativo.setText("Una vez completados los campos, haga clic para registrar la operacion.");

        BtnRegistrarCita.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        BtnRegistrarCita.setText("REGISTRAR");
        BtnRegistrarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarCitaActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        LblInformativo1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblInformativo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblInformativo1.setText("RESUMEN DE LA OPERACION | RESERVA");

        LblNotaInformativa1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        LblNotaInformativa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNotaInformativa1.setText("NOTA: La fecha sugerida puede ser modificada por el administrador.");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("DOLARES");

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContenedorGeneralLayout.createSequentialGroup()
                                    .addGap(77, 77, 77)
                                    .addComponent(LblPrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFContenedorPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1)
                                    .addGap(76, 76, 76))
                                .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(LblInformativo)
                                    .addGap(9, 9, 9)
                                    .addComponent(BtnRegistrarCita)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblNotaInformativa1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LblInformativo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(jSeparator2)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addComponent(LblSubtitulo)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTFContenedorPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblPrecioServicio))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblInformativo)
                            .addComponent(BtnRegistrarCita))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblInformativo1)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblNotaInformativa1)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CbxServicioTesla01ActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarPrecio();
    }

    private void CbxServicioOtro01ActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarPrecio();
    }

    private void BtnRegistrarCitaActionPerformed(java.awt.event.ActionEvent evt) {
        // Validar campos antes de proceder
        /*
        if (!validarCampos()) {
            return;
        }
         */
        //Validacion de campos generales:
        String tipoVehiculo = obtenerTipoVehiculo();
        if (tipoVehiculo.equals("TESLA")) {
            if (JTFServicioTesla02.getText().isEmpty() && JTFServicioTesla03.getText().isEmpty() && JTFServicioTesla04.getText().isEmpty()
                    && JTFServicioTesla05.getText().isEmpty() && JTFServicioTesla06.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "TESLA Motors Inc.", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (JTFServicioOtro02.getText().isEmpty() && JTFServicioOtro03.getText().isEmpty() && JTFServicioOtro04.getText().isEmpty()
                && JTFServicioOtro05.getText().isEmpty() && JTFServicioOtro06.getText().isEmpty() && JTFServicioOtro07.getText().isEmpty()
                && JTFServicioOtro08.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "TESLA Motors Inc.", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Validacion unitaria:
        if (!validarCampos()) {
            return;
        }

        try {
            ReservaServTres r = new ReservaServTres();
            r.setDniCliente(Sesion.clienteLogueado.getDNI_Cliente());

            // Obtener tipo de vehículo basado en la pestaña activa
            //String tipoVehiculo = obtenerTipoVehiculo();
            r.setTipoVehiculo(tipoVehiculo);

            r.setServicioSolicitado(tipoVehiculo.equals("TESLA")
                    ? CbxServicioTesla01.getSelectedItem().toString()
                    : CbxServicioOtro01.getSelectedItem().toString());

            String precioTxt = JTFContenedorPrecio.getText().trim();
            if (precioTxt.isEmpty() || precioTxt.equals("0.00")) {
                JOptionPane.showMessageDialog(this, "Error: Debe seleccionar un servicio válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                r.setPrecio(new BigDecimal(precioTxt));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Formato de precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar y parsear fecha
            try {
                r.setFechaCita(LocalDate.parse(tipoVehiculo.equals("TESLA")
                        ? JTFServicioTesla06.getText()
                        : JTFServicioOtro07.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: Formato de fecha inválido. Use el formato YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tipoVehiculo.equals("TESLA")) {
                r.setNumeroMotor(JTFServicioTesla02.getText().trim());
                r.setNumeroSerie(JTFServicioTesla03.getText().trim());
                r.setKilometraje(!JTFServicioTesla04.getText().trim().isEmpty()
                        ? Integer.parseInt(JTFServicioTesla04.getText().trim()) : null);
                r.setObservacion(JTFServicioTesla05.getText().trim());
            } else {
                r.setMarcaVehiculo(JTFServicioOtro02.getText().trim());
                r.setModeloVehiculo(JTFServicioOtro03.getText().trim());
                r.setAnioVehiculo(!JTFServicioOtro04.getText().trim().isEmpty()
                        ? Integer.parseInt(JTFServicioOtro04.getText().trim()) : null);
                r.setTipoMotor(JTFServicioOtro05.getText().trim());
                r.setKilometraje(!JTFServicioOtro06.getText().trim().isEmpty()
                        ? Integer.parseInt(JTFServicioOtro06.getText().trim()) : null);
                r.setObservacion(JTFServicioOtro08.getText().trim());
            }

            //r.setDniEmpleado("[DNI EMPLEADO]");
            //Asignacion dinamica del empleado - mantenimiento:
            DAOEmpleado daoEmp = new DAOEmpleadosIMPLEMENT();
            String dniEmpleadoAleatorio;
            
            try {
                dniEmpleadoAleatorio = daoEmp.obtenerDNIEmpleadoAleatorio();
                
                if (dniEmpleadoAleatorio == null) {
                    JOptionPane.showMessageDialog(null, "No se pudo asignar un empleado.", "Tesla Motors Inc.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                r.setDniEmpleado(dniEmpleadoAleatorio);
                daoEmp.bloquearEmpleadoPorDNI(dniEmpleadoAleatorio);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al obtener el empleado", "Tesla Motors Inc.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Registrar en la base de datos
            new DAOReservaServTresIMPLEMENT().registrar(r);

            // Mostrar resumen en el JTextArea
            mostrarResumen(r);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Cita registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar formulario para nueva cita
            limpiarFormulario();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Los campos numéricos deben contener solo números", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la cita: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void JTFServicioOtro04ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void JTFServicioOtro05ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrarCita;
    private javax.swing.JComboBox<String> CbxServicioOtro01;
    private javax.swing.JComboBox<String> CbxServicioTesla01;
    private javax.swing.JTextField JTFContenedorPrecio;
    private javax.swing.JTextField JTFServicioOtro02;
    private javax.swing.JTextField JTFServicioOtro03;
    private javax.swing.JTextField JTFServicioOtro04;
    private javax.swing.JTextField JTFServicioOtro05;
    private javax.swing.JTextField JTFServicioOtro06;
    private javax.swing.JTextField JTFServicioOtro07;
    private javax.swing.JTextField JTFServicioOtro08;
    private javax.swing.JTextField JTFServicioTesla02;
    private javax.swing.JTextField JTFServicioTesla03;
    private javax.swing.JTextField JTFServicioTesla04;
    private javax.swing.JTextField JTFServicioTesla05;
    private javax.swing.JTextField JTFServicioTesla06;
    private javax.swing.JLabel LblInformativo;
    private javax.swing.JLabel LblInformativo1;
    private javax.swing.JLabel LblNotaInformativa1;
    private javax.swing.JLabel LblPrecioServicio;
    private javax.swing.JLabel LblServicioOtro01;
    private javax.swing.JLabel LblServicioOtro02;
    private javax.swing.JLabel LblServicioOtro03;
    private javax.swing.JLabel LblServicioOtro04;
    private javax.swing.JLabel LblServicioOtro05;
    private javax.swing.JLabel LblServicioOtro06;
    private javax.swing.JLabel LblServicioOtro07;
    private javax.swing.JLabel LblServicioOtro08;
    private javax.swing.JLabel LblServicioTesla01;
    private javax.swing.JLabel LblServicioTesla02;
    private javax.swing.JLabel LblServicioTesla03;
    private javax.swing.JLabel LblServicioTesla04;
    private javax.swing.JLabel LblServicioTesla05;
    private javax.swing.JLabel LblServicioTesla06;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
