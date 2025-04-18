/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Empleado;
import Negocio.Obra;
import Modelo.Puesto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author amari
 */
public class ADMINModificarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form nuevoFuncionario
     */
    private Obra obra;
    private String identificacion;
    private Empleado empleadoModificando;
    
    public ADMINModificarEmpleado(Obra obra, String identificacion) {
        this.obra = obra;       
        this.identificacion = identificacion;
        
        empleadoModificando = obra.buscarEmpleado(identificacion);
        
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        // Agregar texto a los campos
        LabelId.setText(empleadoModificando.getId());  
        TextNombre.setText(empleadoModificando.getNombre());
        TextCorreo.setText(empleadoModificando.getCorreo());
        TextTelefono.setText(empleadoModificando.getTelefono());
        TextDireccion.setText(empleadoModificando.getDireccion());
        TextSalario.setText(String.valueOf(empleadoModificando.getSalarioHora()));
        ComboPuesto.setSelectedItem(empleadoModificando.getPuesto().getNombre());
        
        TextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarSoloNumeros(evt);
            }
        });
        
        // Dentro del constructor o método donde configuras los componentes
        TextSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarSoloDecimales(evt);
            }
        });
       
        

    }
    
    private void validarSoloNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        // Si el carácter no es un número, bloquearlo
        if (!Character.isDigit(c)) {
            evt.consume();
        }

        // Si el texto ya tiene 8 caracteres, no permitir más entradas
        if (TextTelefono.getText().length() >= 8) {
            evt.consume();
        }
    }
    
    private void validarSoloDecimales(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();
    String texto = TextSalario.getText();

    // Si el carácter no es un número ni un punto decimal, bloquearlo
    if (!Character.isDigit(c) && c != '.') {
        evt.consume();
        return;
    }

    // Bloquear si ya existe un punto decimal y se intenta ingresar otro
    if (c == '.' && texto.contains(".")) {
        evt.consume();
        return;
    }

    // Bloquear si ya hay 2 dígitos después del punto decimal
    if (texto.contains(".")) {
        int indexPunto = texto.indexOf(".");
        if (texto.substring(indexPunto + 1).length() >= 2 && texto.length() - indexPunto > 2) {
            evt.consume();
            return;
        }
    }
    
    
        
}
    
    
    private void ModificarEmpleado(Empleado unEmpleado){
    // Recuperar los datos ingresados en los campos de texto y el combo box
    String nombreText = TextNombre.getText();
    String correoText = TextCorreo.getText();
    String telefonoText = TextTelefono.getText();
    String direccionText = TextDireccion.getText(); // Asumiendo que jTextArea1 es para la dirección
    String SalarioText = TextSalario.getText();
    String puestoText = ComboPuesto.getSelectedItem().toString(); // Recupera el sexo del combo box 
    
    // Validar que el teléfono tenga exactamente 8 dígitos
    if (telefonoText.length() != 8) {
        javax.swing.JOptionPane.showMessageDialog(this, "El número de teléfono debe tener exactamente 8 dígitos.");
        return;
    }   
    
    // Validar otros aspectos como el formato del correo, etc.
    if (!correoText.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Formato de correo inválido, debe ser aaaa@bbbb.ccc");
    return;
}       
    Puesto elPuesto = obra.obtenerPuesto(puestoText);
       
    unEmpleado.setNombre(nombreText);
    unEmpleado.setCorreo(correoText);
    unEmpleado.setTelefono(telefonoText);
    unEmpleado.setDireccion(direccionText);
    unEmpleado.setSalarioHora(Double.parseDouble(SalarioText));
    unEmpleado.setPuesto(elPuesto);
        
    // Mostrar un mensaje de éxito al usuario
    javax.swing.JOptionPane.showMessageDialog(this, "Empleado modificado exitosamente");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        TextCorreo = new javax.swing.JTextField();
        TextTelefono = new javax.swing.JTextField();
        TextDireccion = new javax.swing.JTextField();
        ButtonConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LabelId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextSalario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ComboPuesto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Correo:");

        jLabel4.setText("Teléfono:");

        jLabel5.setText("Dirección:");

        TextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTelefonoActionPerformed(evt);
            }
        });

        ButtonConfirmar.setText("Confirmar cambios");
        ButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Modificar empleado");

        jLabel6.setText("Identificación:");

        LabelId.setText("_");

        jLabel8.setText("Salario Hora:");

        jLabel9.setText("Puesto:");

        ComboPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabajador de Alturas", "Soldador", "Albañil", "Cristalero", "Jefe de Obra" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 124, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextSalario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ComboPuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LabelId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ComboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(ButtonConfirmar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTelefonoActionPerformed

    private void ButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmarActionPerformed
    // TODO add your handling code here:
    ModificarEmpleado(empleadoModificando);
    
    }//GEN-LAST:event_ButtonConfirmarActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonConfirmar;
    private javax.swing.JComboBox<String> ComboPuesto;
    private javax.swing.JLabel LabelId;
    private javax.swing.JTextField TextCorreo;
    private javax.swing.JTextField TextDireccion;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextSalario;
    private javax.swing.JTextField TextTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
