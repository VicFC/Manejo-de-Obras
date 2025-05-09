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
public class ADMINCrearEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form nuevoFuncionario
     */
    private Obra obra;
    
    public ADMINCrearEmpleado(Obra obra) {
        this.obra = obra;
        
        
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        
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
    
    /***
     * Función que limpia los campos
     */
    private void limpiarCampos() {
    TextID.setText("");
    TextNombre.setText("");
    TextCorreo.setText("");
    TextTelefono.setText("");
    TextDireccion.setText("");  // Dirección
    TextFecha.setText("");
    TextSalario.setText("");
    ComboPuesto.setSelectedIndex(0);  // Resetea el combo box al primer valor
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextID = new javax.swing.JTextField();
        TextNombre = new javax.swing.JTextField();
        TextCorreo = new javax.swing.JTextField();
        TextTelefono = new javax.swing.JTextField();
        TextDireccion = new javax.swing.JTextField();
        TextFecha = new javax.swing.JTextField();
        ButtonCrearEmpleado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ComboPuesto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextSalario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        jLabel1.setText("Identificación:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Correo:");

        jLabel4.setText("Teléfono:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Fecha Ingreso:");

        TextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTelefonoActionPerformed(evt);
            }
        });

        TextFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFechaActionPerformed(evt);
            }
        });

        ButtonCrearEmpleado.setText("Agregar");
        ButtonCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCrearEmpleadoActionPerformed(evt);
            }
        });

        jLabel8.setText("Puesto:");

        ComboPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabajador de Alturas", "Soldador", "Albañil", "Cristalero", "Jefe de Obra" }));
        ComboPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPuestoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Crear empleado");

        jLabel9.setText("Salario Hora:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(ComboPuesto, 0, 155, Short.MAX_VALUE)
                            .addComponent(TextDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TextTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TextCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TextSalario))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(ButtonCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(ButtonCrearEmpleado)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTelefonoActionPerformed

    private void TextFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFechaActionPerformed

    private void ButtonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCrearEmpleadoActionPerformed
        // TODO add your handling code here:
        // Recuperar los datos ingresados en los campos de texto y el combo box
    String id = TextID.getText();
    String nombre = TextNombre.getText();
    String correo = TextCorreo.getText();
    String telefono = TextTelefono.getText();
    String direccion = TextDireccion.getText(); // Asumiendo que jTextArea1 es para la dirección
    String fechaIngreso = TextFecha.getText();
    String Salario = TextSalario.getText();
    String puesto = ComboPuesto.getSelectedItem().toString(); // Recupera el sexo del combo box 
    
    // Validar si todos los campos están completos y los datos son correctos (ejemplo: validación del formato de fecha)
    if (id.isEmpty() || nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || fechaIngreso.isEmpty() || Salario.isEmpty() || puesto == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos.");
        return;
    }
    
    // Validar que el teléfono tenga exactamente 8 dígitos
    if (telefono.length() != 8) {
        javax.swing.JOptionPane.showMessageDialog(this, "El número de teléfono debe tener exactamente 8 dígitos.");
        return;
    }   
    
    // Validar otros aspectos como el formato del correo, etc.
    if (!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Formato de correo inválido, debe ser aaaa@bbbb.ccc");
    return;
}
    
    // Parsear la fecha de nacimiento usando SimpleDateFormat con validación estricta
    Calendar fechaNacimiento = null;

    // Definir el formato de la fecha
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    formatoFecha.setLenient(false); // Para que no acepte fechas inválidas como 31/02/2021

    try {
        // Intentar parsear la fecha
        Date fecha = formatoFecha.parse(fechaIngreso);

        // Convertir la fecha parseada a un Calendar
        fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.setTime(fecha);

        // Aquí puedes seguir con tu lógica, por ejemplo, asignar el cliente
        System.out.println("Fecha válida: " + formatoFecha.format(fechaNacimiento.getTime()));

    } catch (ParseException e) {
        // Si ocurre una excepción, el formato o la fecha no es válida
        javax.swing.JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto o fecha inválida. Use dd/MM/yyyy.");
        return; // Termina el método si la fecha no es válida
    } 
    
    Puesto elPuesto = obra.obtenerPuesto(puesto);
    
    // Crear el nuevo cliente
    Empleado nuevoEmpleado = new Empleado(id, nombre, correo, telefono, direccion, fechaNacimiento, Double.parseDouble(Salario), elPuesto);
    
    // Intentar agregar el cliente usando el servicio
    if (!obra.agregarCliente(nuevoEmpleado)) {
        javax.swing.JOptionPane.showMessageDialog(this, "El empleado con este ID ya existe.");
        return;
    }

    // Mostrar un mensaje de éxito al usuario
    javax.swing.JOptionPane.showMessageDialog(this, "Empleado registrado exitosamente.");

    // Limpiar los campos después de registrar al cliente
    limpiarCampos();    
    
    
    }//GEN-LAST:event_ButtonCrearEmpleadoActionPerformed

    private void ComboPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPuestoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCrearEmpleado;
    private javax.swing.JComboBox<String> ComboPuesto;
    private javax.swing.JTextField TextCorreo;
    private javax.swing.JTextField TextDireccion;
    private javax.swing.JTextField TextFecha;
    private javax.swing.JTextField TextID;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextSalario;
    private javax.swing.JTextField TextTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
