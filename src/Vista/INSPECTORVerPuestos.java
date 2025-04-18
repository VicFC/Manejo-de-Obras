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

import Negocio.Obra;
import Modelo.Puesto;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author amari
 */
public class INSPECTORVerPuestos extends javax.swing.JFrame {

    /**
     * Creates new form PlanillaEmpleados
     */
    private Obra obra;
    
    public INSPECTORVerPuestos(Obra obra) {
        this.obra = obra;
        
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Configurar el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Hacer que las celdas no sean editables
        }
    };
    model.addColumn("Puesto");
    model.addColumn("Código");
    model.addColumn("Descripción");

    TablaPuestos.setModel(model);
    TablaPuestos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

    // Personalizar la tabla para que soporte texto multilínea en la columna de Descripción
    TablaPuestos.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
    TablaPuestos.setRowHeight(60); // Ajustar la altura inicial de las filas

    // Ajustar el ancho de las columnas
    TablaPuestos.getColumnModel().getColumn(0).setPreferredWidth(70); // Columna "Puesto"
    TablaPuestos.getColumnModel().getColumn(1).setPreferredWidth(30);  // Columna "Código"
    TablaPuestos.getColumnModel().getColumn(2).setPreferredWidth(300); // Columna "Descripción"

    
    // Cargar los datos en la tabla
    cargarPuestosEnTabla();

    // Agregar el MouseListener para manejar el doble clic en una fila
    TablaPuestos.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) { // Detectar doble clic
                int selectedRow = TablaPuestos.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener la descripción de la fila seleccionada
                    String descripcion = TablaPuestos.getValueAt(selectedRow, 2).toString();

                    // Mostrar la descripción completa en un cuadro de diálogo
                    mostrarDescripcionCompleta(descripcion);
                }
            }
        }
    });
    }


    // Método para rellenar la tabla con los datos del ArrayList<Empleado>
private void cargarPuestosEnTabla() {
    // Obtener el modelo de la tabla
    DefaultTableModel modelo = (DefaultTableModel) TablaPuestos.getModel();

    // Limpiar cualquier dato previo en la tabla
    modelo.setRowCount(0);

    // Obtener la lista de empleados
    ArrayList<Puesto> puestos = obra.getListaPuestos();

    // Recorrer el ArrayList y agregar los datos a la tabla
    for (Puesto puesto : puestos) {
        // Crear un arreglo con los datos del puesto
        Object[] fila = new Object[] {
            puesto.getNombre(),
            puesto.getCodigo(),
            puesto.getDescripcion() 
        };

        // Agregar la fila al modelo de la tabla
        modelo.addRow(fila);
    }
     // Ajustar automáticamente la altura de las filas
    ajustarAlturaFilas(TablaPuestos);
}


private void mostrarDescripcionCompleta(String descripcion) {
    JTextArea textArea = new JTextArea(descripcion);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 300)); // Tamaño de la ventana de detalle

    JOptionPane.showMessageDialog(this, scrollPane, "Descripción Completa", JOptionPane.INFORMATION_MESSAGE);
}


// Método para ajustar la altura de las filas automáticamente
private void ajustarAlturaFilas(JTable tabla) {
    for (int row = 0; row < tabla.getRowCount(); row++) {
        int alturaMaxima = tabla.getRowHeight();

        for (int column = 0; column < tabla.getColumnCount(); column++) {
            TableCellRenderer renderer = tabla.getCellRenderer(row, column);
            Component comp = tabla.prepareRenderer(renderer, row, column);
            alturaMaxima = Math.max(comp.getPreferredSize().height, alturaMaxima);
        }
        tabla.setRowHeight(row, alturaMaxima);
    }
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
        ButtonDetalles = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPuestos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText(" Ver Puestos");

        ButtonDetalles.setBackground(new java.awt.Color(255, 102, 255));
        ButtonDetalles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonDetalles.setText("Ver Detalles");
        ButtonDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDetallesActionPerformed(evt);
            }
        });

        TablaPuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Puesto", "Código", "Descripción"
            }
        ));
        jScrollPane2.setViewportView(TablaPuestos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(ButtonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(ButtonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void ButtonDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDetallesActionPerformed
        // TODO add your handling code here:
        // Verificar que se haya seleccionado una fila de la tabla
        int filaSeleccionada = TablaPuestos.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            // Si no se ha seleccionado ninguna fila, mostrar un mensaje de advertencia
            javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar un puesto para ver sus detalles.");
        } else {
            // Obtener los datos del empleado seleccionado en la fila
             String identificacion = TablaPuestos.getValueAt(filaSeleccionada, 1).toString();
            
             INSPECTORConsultarPuesto verConsultarPuestos = new INSPECTORConsultarPuesto(obra, identificacion);    
             verConsultarPuestos.setVisible(true);  
        }
    }//GEN-LAST:event_ButtonDetallesActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDetalles;
    private javax.swing.JTable TablaPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
