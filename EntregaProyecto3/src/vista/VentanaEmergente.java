package vista;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class VentanaEmergente {

    public static void msgConfirmacion(String titulo, String contenido, int icono, JDialog padre) {

        JOptionPane.showMessageDialog(padre, contenido, titulo, icono);

    }

}
