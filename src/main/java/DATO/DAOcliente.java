/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DATO;
import ENTIDAD.Ecliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BDCONEXION.Conexion;


public class DAOcliente {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sql;

    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Ruc", "RazonSocial", "Direccion", "Telefono", "RepresentanteLegal", "IdUsuarioRegistro", "Estado"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT * FROM cliente WHERE CONCAT(RazonSocial, ' ', RepresentanteLegal) LIKE '%" + buscar + "%' AND Estado = 1"; 

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IdCliente");
                registros[1] = rs.getString("Ruc");
                registros[2] = rs.getString("RazonSocial");
                registros[3] = rs.getString("Direccion");
                registros[4] = rs.getString("Telefono");
                registros[5] = rs.getString("RepresentanteLegal");
                registros[6] = rs.getString("IdUsuarioRegistro");
                registros[7] = rs.getString("Estado");

                modelo.addRow(registros);
            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Ecliente v) {
      
        if (validarNombreRepetido(v.getRazonSocial())) {
            JOptionPane.showMessageDialog(null, "Ya existe un cliente con esta razón social.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        sql = "INSERT INTO cliente (Ruc, RazonSocial, Direccion, Telefono, RepresentanteLegal, IdUsuarioRegistro, Estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, v.getRuc());
            pst.setString(2, v.getRazonSocial());
            pst.setString(3, v.getDireccion());
            pst.setString(4, v.getTelefono());
            pst.setString(5, v.getRepresentanteLegal());
            pst.setInt(6, v.getIdUsuarioRegistro());
            pst.setInt(7, v.getEstado());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    private boolean validarNombreRepetido(String razonSocial) {
        sql = "SELECT COUNT(*) AS total FROM cliente WHERE RazonSocial = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, razonSocial);
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