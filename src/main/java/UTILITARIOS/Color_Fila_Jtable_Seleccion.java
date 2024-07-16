/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILITARIOS;


import PRESENTACIONES.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Color_Fila_Jtable_Seleccion extends DefaultTableCellRenderer {

  public Color_Fila_Jtable_Seleccion() {
        setHorizontalAlignment(JLabel.CENTER);
        

        setOpaque(true); 


    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    
        setBackground(new Color(173, 216, 230)); 

        setForeground(Color.WHITE); 


        return this;
    }
}