/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILITARIOS;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorPedidoEstados extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        int estadoColumnIndex = 8; 
        
        if (column == estadoColumnIndex) {
            String estado = table.getValueAt(row, estadoColumnIndex).toString();
            switch (estado) {
                case "PENDIENTE":
                    componente.setForeground(Color.WHITE);
                    componente.setBackground(Color.ORANGE);
                    break;
                case "EN PROCESO":
                    componente.setForeground(Color.WHITE);
                    componente.setBackground(Color.GRAY);
                    break;
                case "ENTREGADO":
                    componente.setForeground(Color.WHITE);
                    componente.setBackground(Color.BLUE);
                    break;
                default:
                    componente.setForeground(Color.BLACK);
                    componente.setBackground(Color.WHITE);
                    break;
            }
        } else {
            
            componente.setForeground(Color.BLACK);
            componente.setBackground(Color.WHITE);
        }

        if (isSelected) {
            componente.setForeground(table.getSelectionForeground());
            componente.setBackground(table.getSelectionBackground());
        }

        return componente;
    }
}