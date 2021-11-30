
package vista;

import entidades.RegistroPaquetes;
import entidades.RegistroR;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.RegistrodePaquetes;

public class VentanaConsultaPaquetes extends JDialog{
    private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private String titulos[] = {"Tipo Paquete", "Peso", "Largo", "Ancho", "Alto", "Volumen","Tipo Repartidor", "Codigo Postal", "Valor Declarado", "Observaciones Adicionales"};
    private RegistrodePaquetes modelo;
    
     public VentanaConsultaPaquetes(JFrame frame, boolean bln) {
        super(frame, bln);
        this.modelo = new RegistrodePaquetes();
        this.setTitle("Consulta Consulta Paquetes");
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(1200, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.actualizarTabla();
        this.setVisible(true);
    }
     public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.contenedor.add(this.panelBase);
    }
    public void iniciarPanelFiltro() {
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.lFiltro = new JLabel("Filtro busqueda: ");
        this.tFiltro = new JTextField(10);
        this.tFiltro.addKeyListener(new eventoTecladoFiltro());

        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);

        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);

    }
    public void actualizarTabla() {
        String filtro = this.tFiltro.getText();
        try {
            List<RegistroPaquetes> lista = this.modelo.leer();
            this.modeloTabla.setNumRows(0);
            for (RegistroPaquetes rd : lista) {
                String fila[] = {rd.getTipoPaquete(), String.valueOf(rd.getPesop()), String.valueOf(rd.getLargo()), String.valueOf(rd.getAncho()),String.valueOf(rd.getAlto()), rd.getVolumen(),rd.getTRepartidor(), String.valueOf(rd.getCodPostal()), rd.getValor(), rd.getObservaciones()};
                if (filtro != null) {
                    if (rd.getTipoPaquete().toUpperCase().contains(filtro.toUpperCase())) {
                        this.modeloTabla.addRow(fila);
                    }
                } else {
                    this.modeloTabla.addRow(fila);
                }
            }

        } catch (IOException ex) {
            VentanaEmergente.msgConfirmacion("Excepcion", ex.getMessage(), JOptionPane.ERROR_MESSAGE, this);
        }

    }

    public void iniciarPanelResultado() {

        this.panelResultado = new JScrollPane();

        this.tabla = new JTable();
        this.modeloTabla = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modeloTabla);
        this.panelResultado.setViewportView(this.tabla);

        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);

    }

    class eventoTecladoFiltro extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            actualizarTabla();
        }
    }

    
    
 
}
