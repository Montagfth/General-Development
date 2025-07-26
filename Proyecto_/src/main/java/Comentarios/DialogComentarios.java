/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comentarios;

import Database.DatabaseNOSQL;
import DatabaseModels.Sesion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.bson.Document;

/**
 *
 * @author Fabrizio
 */
public class DialogComentarios extends JDialog {

    private JTextArea txtComentario;
    private JComboBox<String> comboCalificacion;
    private JButton btnEnviar;
    private int idVehiculo;
    
    public DialogComentarios(JFrame parent, int idVehiculo) {
        
        super(parent, "Dejar Comentario", true);
        this.idVehiculo = idVehiculo;
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(parent);

        txtComentario = new JTextArea(5, 30);
        comboCalificacion = new JComboBox<>(new String[]{"⭐", "⭐⭐", "⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐⭐⭐"});
        btnEnviar = new JButton("Enviar");

        JPanel panelCentral = new JPanel(new GridLayout(3, 1));
        panelCentral.add(new JLabel("Calificación:"));
        panelCentral.add(comboCalificacion);
        panelCentral.add(new JLabel("Comentario:"));
        panelCentral.add(new JScrollPane(txtComentario));

        add(panelCentral, BorderLayout.CENTER);
        add(btnEnviar, BorderLayout.SOUTH);

        btnEnviar.addActionListener(e -> {
            String calificacionStr = (String) comboCalificacion.getSelectedItem();
            int calificacion = calificacionStr.length();
            String comentario = txtComentario.getText();

            guardarComentarioEnMongo(Sesion.clienteLogueado.getDNI_Cliente(), calificacion, comentario);
            JOptionPane.showMessageDialog(this, "Comentario enviado");
            dispose();
        });
    }

    private void guardarComentarioEnMongo(String dni, int calificacion, String contenido) {
        MongoDatabase db = DatabaseNOSQL.conectar();
        MongoCollection<Document> col = db.getCollection("pruebacomentario");

        Document doc = new Document("DNICliente", dni)
                .append("IDVehiculo", idVehiculo)
                .append("Calificacion", calificacion)
                .append("Contenido", contenido)
                .append("Fecha", new Date());

        col.insertOne(doc);
        System.out.println("Comentario guardado en MongoDB");
    }
}
