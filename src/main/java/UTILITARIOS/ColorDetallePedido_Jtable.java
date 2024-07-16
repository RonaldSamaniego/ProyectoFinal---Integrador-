/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILITARIOS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ColorDetallePedido_Jtable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        
        label.setBackground(new Color(60, 120, 180)); 
        label.setForeground(Color.WHITE); 
        label.setHorizontalAlignment(JLabel.CENTER); 
        label.setFont(label.getFont().deriveFont(14f).deriveFont(Font.BOLD)); 

        return label;
    }
}