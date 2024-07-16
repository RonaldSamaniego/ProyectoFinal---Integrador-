/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATO;

import ENTIDAD.Eusuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BDCONEXION.Conexion;
import java.sql.SQLException;


public class DAOusuario {
    
private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sql;

  
    public DefaultTableModel consultar(String buscar) {
    DefaultTableModel modelo;
    String[] titulos = {"Codigo", "Usuario", "Contraseña", "Cargo", "Estado"};
    String[] registros = new String[5];
    modelo = new DefaultTableModel(null, titulos);

    sql = "SELECT * FROM usuario WHERE Usuario LIKE '%" + buscar + "%' AND Estado = 1";

    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            registros[0] = rs.getString("IdUsuario");
            registros[1] = rs.getString("Usuario");
            registros[2] = rs.getString("Contraseña");
            registros[3] = rs.getString("Cargo");
            registros[4] = rs.getString("Estado");

            modelo.addRow(registros);
        }

        return modelo;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}

    
    
 
    public boolean login(Eusuario user) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "SELECT idusuario, usuario, contraseña, cargo FROM usuario WHERE usuario = ?";

    try {
        ps = cn.prepareStatement(sql);
        ps.setString(1, user.getUsuario());
        rs = ps.executeQuery();

        if (rs.next()) {
            if (user.getContraseña().equals(rs.getString("contraseña"))) {
                user.setIdUsuario(rs.getInt("idusuario")); 
                user.setCargo(rs.getString("cargo"));
                return true;
            } else {
                return false;
            }
        }
        return false;
    } catch (SQLException ex) {
        System.err.println(ex.toString());
        return false;
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}

    
    
    public boolean insertar(Eusuario v) {
    if (validarUsuarioRepetido(v.getUsuario())) {
        JOptionPane.showMessageDialog(null, "Ya existe un usuario con este nombre.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    sql = "INSERT INTO usuario (Usuario, Contraseña, Cargo, Estado) VALUES (?, ?, ?, ?)";

    try {
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, v.getUsuario());
        pst.setString(2, v.getContraseña());
        pst.setString(3, v.getCargo());
        pst.setInt(4, v.getEstado());

        int n = pst.executeUpdate();
        return n != 0;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return false;
    }
}

private boolean validarUsuarioRepetido(String usuario) {
    sql = "SELECT COUNT(*) AS total FROM usuario WHERE Usuario = ?";

    try {
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, usuario);
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