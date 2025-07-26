package Product;

import javax.swing.*;
import java.awt.*;

import View.*;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Fabrizio
 */
//NOTA: Testeador secuencial de las ventanas que fueron implementadas en el proyecto
public class Tester extends JFrame {

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("app.themes");
        FlatMacDarkLaf.setup();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        EventQueue.invokeLater(() -> new loginPrototipo().setVisible(true));
        
        //Inicializador de JFrame -> loginPrototipo.java:
        //EventQueue.invokeLater(() -> new Tester().setVisible(true));
    }

    public Tester() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        setLayout(new MigLayout("al center center"));
        add(new loginPrototipo());

        /*
        addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Tesla Motors Inc.", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
        */
    }
}
