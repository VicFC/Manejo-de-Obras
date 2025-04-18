/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TextAreaRenderer extends JScrollPane implements TableCellRenderer {
    private final JTextArea textArea;

    public TextAreaRenderer() {
        textArea = new JTextArea();
        textArea.setLineWrap(true); // Activar ajuste de texto
        textArea.setWrapStyleWord(true); // Ajuste por palabra
        textArea.setOpaque(true); // Fondo visible
        textArea.setEditable(false); // No editable
        setViewportView(textArea); // Agregar el JTextArea al JScrollPane
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // Scroll vertical
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // No scroll horizontal
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textArea.setText(value != null ? value.toString() : "");

        if (isSelected) {
            textArea.setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            textArea.setBackground(table.getBackground());
            textArea.setForeground(table.getForeground());
        }

        textArea.setFont(table.getFont());
        return this;
    }
}
