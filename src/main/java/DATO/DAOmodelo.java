/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATO;


import ENTIDAD.Emodelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BDCONEXION.Conexion;

public class DAOmodelo {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sql;

 public DefaultTableModel consultar(String buscar) {
    DefaultTableModel modelo;
    String[] titulos = {"Codigo", "Nombre", "Estado"};
    String[] registros = new String[3];
    modelo = new DefaultTableModel(null, titulos);
    

    sql = "SELECT * FROM modelo WHERE Estado = 1 AND Nombre LIKE '%" + buscar + "%'";
    
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            registros[0] = rs.getString("IdModelo");
            registros[1] = rs.getString("Nombre");
            registros[2] = rs.getString("Estado");
            modelo.addRow(registros);
        }
        
        return modelo;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}
    
    public boolean insertar(Emodelo v) {
 
    if (existeNombreModelo(v.getNombre())) {
        JOptionPane.showMessageDialog(null, "El nombre del modelo ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

  
    String sql = "INSERT INTO modelo (Nombre, Estado) VALUES (?, ?)";

    try {
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, v.getNombre());
        pst.setInt(2, v.getEstado());

        int n = pst.executeUpdate();
        return n != 0;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
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
        

private boolean existeNombreModelo(String nombre) {
    String sql = "SELECT COUNT(*) AS count FROM modelo WHERE Nombre = ?";
    try {
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, nombre);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            return count > 0;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return false;
}


}