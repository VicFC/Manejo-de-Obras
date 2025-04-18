/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*

NOTA IMPORTANTE:

Aqui hay que hacer código adicional tanto para cambiar la etiqueta como para
centrarla en cada caso


*/

package Vista;

import Modelo.EntradaBitacora;
import Modelo.Medida;
import Negocio.Obra;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amari
 */
public class AMBOSConsultarBitacora extends javax.swing.JFrame {

    /**
     * Creates new form PlanillaEmpleados
     */
    private Obra obra;
    
    public AMBOSConsultarBitacora(Obra obra) {
        this.obra = obra;
      
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"Inspector", "Fecha", "Empleado", "Puesto", "Cumplidas", "Faltas", "Observaciones"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no serán editables
            }
        };
        
        TablaBitacora.setModel(modelo);

        for (EntradaBitacora entrada : obra.getBitacora()) {
            String inspector = entrada.getInspector();
            String fecha = entrada.getFechaHHMM();
            String empleado = entrada.getEmpleado().getNombre();
            String puesto = entrada.getEmpleado().getPuesto().getNombre();
            String cumplidas = entrada.getCumplidas();
            String faltas = entrada.getFaltas();
            String observaciones = entrada.getObservaciones();

            modelo.addRow(new Object[]{inspector, fecha, empleado, puesto, cumplidas, faltas, observaciones});
        }

        // Evento para mostrar detalles al hacer doble clic
        TablaBitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Doble clic
                    int row = TablaBitacora.rowAtPoint(evt.getPoint());

                    if (row != -1) { // Asegurar que hay una fila seleccionada
                        // Obtener los datos de la fila seleccionada
                        String elPuesto = modelo.getValueAt(row, 3).toString();
                        String cumplidas = modelo.getValueAt(row, 4).toString();
                        String faltas = modelo.getValueAt(row, 5).toString();
                        String observaciones = modelo.getValueAt(row, 6).toString();

                        // Crear los componentes para mostrar los detalles
                        JTextArea areaPuesto = crearAreaTexto(elPuesto, "Puesto");
                        JTextArea areaCumplidas = crearAreaTexto(cumplidas, "Medidas Cumplidas");
                        JTextArea areaFaltas = crearAreaTexto(faltas, "Medidas Faltantes");
                        JTextArea areaObservaciones = crearAreaTexto(observaciones, "Observaciones");

                        // Agregar los componentes a un JScrollPane
                        JScrollPane scrollPuesto = new JScrollPane(areaPuesto);
                        JScrollPane scrollCumplidas = new JScrollPane(areaCumplidas);
                        JScrollPane scrollFaltas = new JScrollPane(areaFaltas);
                        JScrollPane scrollObservaciones = new JScrollPane(areaObservaciones);
                        
                        scrollPuesto.setPreferredSize(new Dimension(100, 100));
                        scrollCumplidas.setPreferredSize(new Dimension(400, 100));
                        scrollFaltas.setPreferredSize(new Dimension(400, 100));
                        scrollObservaciones.setPreferredSize(new Dimension(400, 100));

                        // Mostrar los detalles en una ventana emergente
                        Object[] message = {
                            "Puesto: ", scrollPuesto,
                            "Medidas Cumplidas:", scrollCumplidas,
                            "Medidas Faltantes:", scrollFaltas,
                            "Observaciones:", scrollObservaciones
                        };

                        JOptionPane.showMessageDialog(null, message, "Detalle de la Bitácora", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }
    
    // Método auxiliar para crear un JTextArea configurado
    private JTextArea crearAreaTexto(String contenido, String titulo) {
        JTextArea textArea = new JTextArea(contenido);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBorder(javax.swing.BorderFactory.createTitledBorder(titulo));
        return textArea;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBitacora = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Consulta de la Bitácora");

        TablaBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Inspector", "Fecha", "Empleado", "Puesto", "Cumplidas", "Faltas", "Observaciones"
            }
        ));
        jScrollPane1.setViewportView(TablaBitacora);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(209, 209, 209))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaBitacora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
