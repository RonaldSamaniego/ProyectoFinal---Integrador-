/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATO;

import ENTIDAD.Eproducto;
import ENTIDAD.Emodelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BDCONEXION.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import javax.swing.JComboBox;

public class DAOproducto {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sql;

    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo",  "Modelo", "Descripcion", "Precio", "Stock", "IdUsuarioRegistro", "Estado"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT p.IdProducto, m.Nombre AS Modelo, p.Descripcion, p.Precio, p.Stock, p.IdUsuarioRegistro, p.Estado "
            + "FROM producto p "
            + "INNER JOIN modelo m ON p.IdModelo = m.IdModelo "
            + "WHERE p.Descripcion LIKE '%" + buscar + "%' AND p.Estado = 1"; // Solo productos activos

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IdProducto");
         
                registros[1] = rs.getString("Modelo");
                registros[2] = rs.getString("Descripcion");
                registros[3] = rs.getString("Precio");
                registros[4] = rs.getString("Stock");
                registros[5] = rs.getString("IdUsuarioRegistro");
                registros[6] = rs.getString("Estado");

                modelo.addRow(registros);
            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Eproducto v) {
   
        if (validarNombreRepetido(v.getDescripcion())) {
            JOptionPane.showMessageDialog(null, "Ya existe un producto con esta descripción.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        sql = "INSERT INTO producto (IdModelo, Descripcion, Precio, Stock, IdUsuarioRegistro, Estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, v.getIdModelo());
            pst.setString(2, v.getDescripcion());
            pst.setDouble(3, v.getPrecio());
            pst.setInt(4, v.getStock());
            pst.setInt(5, v.getIdUsuarioRegistro());
            pst.setInt(6, v.getEstado());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }


       
    
        public DefaultTableModel listarModelosActivos() {
        DefaultTableModel modelo;
        String[] titulos = {"IdModelo", "Nombre"};
        String[] registros = new String[2];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT IdModelo, Nombre FROM modelo WHERE Estado = 1"; 

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IdModelo");
                registros[1] = rs.getString("Nombre");

                modelo.addRow(registros);
            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        
    }
}


    private boolean validarNombreRepetido(String descripcion) {
        sql = "SELECT COUNT(*) AS total FROM producto WHERE Descripcion = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, descripcion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return false;
    }
}