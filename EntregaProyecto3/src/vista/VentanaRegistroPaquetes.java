package vista;

import entidades.RegistroPaquetes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import modelo.RegistrodePaquetes;

public class VentanaRegistroPaquetes extends JDialog {

    private Container contenedor;
    private JPanel panelDatos, panelBotones;
    private JLabel lTipoPaquete, lPeso, lLargo, lAncho, lAlto, lVolumen, lRepartidor, lCodPostal,lValor,lObservaciones;
    private JTextField tPeso, tLargo, tAncho, tAlto, tVolumen,tvalor,tObservaciones;
    private JButton bGuardar;
    private JComboBox cbTipoPaquete, cbCodPostal, cbRepartidor;
    private final RegistrodePaquetes modelo;

    public VentanaRegistroPaquetes(JFrame owner, boolean modal) {
        super(owner, modal);
        this.modelo = new RegistrodePaquetes();
        this.initComponentes();
        this.setTitle("Registro de Paquetes - Delybe Upar - Ventana de registro");
        //this.pack();
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());

        this.initPanelDatos();
        this.initPanelBotones();

    }

    public void initPanelDatos() {

        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(10, 2, 5, 5));

        this.lTipoPaquete = new JLabel("Tipo de Paquete: ");
        this.lPeso = new JLabel("Peso(kg): ");
        this.lLargo = new JLabel("Largo(cm): ");
        this.lAncho = new JLabel("Ancho(cm): ");
        this.lAlto = new JLabel("Alto(cm):   ");
        this.lVolumen = new JLabel("Volumen(cm3): ");
        this.lRepartidor = new JLabel("Tipo de repartidor: ");
        this.lCodPostal = new JLabel("Codigo Postal: ");
        this.lValor = new JLabel("Valor Declarado: ");
        this.lObservaciones = new JLabel("Observaciones Adicionales: ");
                
        this.cbTipoPaquete = new JComboBox();
        this.cbTipoPaquete.addItem("Caja");
        this.cbTipoPaquete.addItem("Sobre");
        this.cbTipoPaquete.addItem("Otro");

        this.tPeso = new JTextField(null);
        this.tLargo = new JTextField(null);
        this.tAncho = new JTextField(null);
        this.tAlto = new JTextField(null);
        this.tVolumen = new JTextField(null);

        this.cbRepartidor = new JComboBox();
        this.cbRepartidor.addItem("Categoria A");
        this.cbRepartidor.addItem("Categoria B");
        this.cbRepartidor.addItem("Categoria C");

        this.cbCodPostal = new JComboBox();
        this.cbCodPostal.addItem("200001");
        this.cbCodPostal.addItem("200002");
        this.cbCodPostal.addItem("200003");
        this.cbCodPostal.addItem("200004");
        this.cbCodPostal.addItem("200005");
        this.cbCodPostal.addItem("200007");
        this.cbCodPostal.addItem("200008");
        this.cbCodPostal.addItem("200009");
        this.cbCodPostal.addItem("200017");
        this.cbCodPostal.addItem("200018");
        
        this.tvalor = new JTextField(null);
        this.tObservaciones = new JTextField(null);

        this.panelDatos.add(this.lTipoPaquete);
        this.panelDatos.add(this.cbTipoPaquete);

        this.panelDatos.add(this.lPeso);
        this.panelDatos.add(this.tPeso);

        this.panelDatos.add(this.lLargo);
        this.panelDatos.add(this.tLargo);

        this.panelDatos.add(this.lAncho);
        this.panelDatos.add(this.tAncho);

        this.panelDatos.add(this.lAlto);
        this.panelDatos.add(this.tAlto);

        this.panelDatos.add(this.lVolumen);
        this.panelDatos.add(this.tVolumen);

        this.panelDatos.add(this.lRepartidor);
        this.panelDatos.add(this.cbRepartidor);

        this.panelDatos.add(this.lCodPostal);
        this.panelDatos.add(this.cbCodPostal);
        
        this.panelDatos.add(this.lValor);
        this.panelDatos.add(this.tvalor);
        
        this.panelDatos.add(this.lObservaciones);
        this.panelDatos.add(this.tObservaciones);
        

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);

    }

    public void initPanelBotones() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4, 1, 5, 5));

        this.bGuardar = new JButton("Guardar");

        panel.add(this.bGuardar);
        this.bGuardar.addActionListener(new clickBotonGuardar());

        this.panelBotones = new JPanel();
        this.panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelBotones.setLayout(new FlowLayout());

        this.panelBotones.add(panel);

        this.contenedor.add(this.panelBotones, BorderLayout.EAST);

    }

    public RegistroPaquetes leerDatos() {

        RegistroPaquetes t = new RegistroPaquetes();

        t.setTipoPaquete(this.cbTipoPaquete.getSelectedItem().toString());
        t.setPesop(Integer.valueOf(this.tPeso.getText()));
        t.setLargo(Integer.valueOf(this.tLargo.getText()));
        t.setAncho(Integer.valueOf(this.tAncho.getText()));
        t.setAlto(Integer.valueOf(this.tAlto.getText()));
        t.setVolumen(this.tVolumen.getText());
        t.setTRepartidor(this.cbRepartidor.getSelectedItem().toString());
        t.setCodPostal(Integer.valueOf(this.cbCodPostal.getSelectedItem().toString()));
        t.setValor(this.tvalor.getText());
        t.setObservaciones(this.tObservaciones.getText());

        return t;
    }

    public void guardar() {

        RegistroPaquetes t = this.leerDatos();

        try {
            this.modelo.registrar(t);
            VentanaEmergente.msgConfirmacion("Registro Exitoso", "El registro fue exitoso", JOptionPane.INFORMATION_MESSAGE, this);

        } catch (IOException ex) {
            VentanaEmergente.msgConfirmacion("Excepcion", ex.getMessage(), JOptionPane.ERROR_MESSAGE, this);

        } catch (NullPointerException ne) {
            VentanaEmergente.msgConfirmacion("Validacion", ne.getMessage(), JOptionPane.ERROR_MESSAGE, this);
        }

    }

    class clickBotonGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            guardar();
        }

    }

    public void eliminar() {

    }

}
