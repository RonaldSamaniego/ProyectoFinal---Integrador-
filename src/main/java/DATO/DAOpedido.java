/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATO;

import ENTIDAD.Epedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BDCONEXION.Conexion;
import java.sql.SQLException;


public class DAOpedido {
    
 private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sql;



    private PreparedStatement ps;
    private ResultSet rs;
     
     
    public boolean insertar(Epedido v) {

        sql = "INSERT INTO pedido (IdPedido, IdCliente, IdEmpresaDestajero, Fecha, FechaDevolucion, Total, Comentario, IdUsuarioRegistro, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, v.getIdPedido());
            pst.setInt(2, v.getIdCliente());
            pst.setInt(3, v.getIdEmpresaDestajero());
            pst.setString(4, v.getFecha());
            pst.setString(5, v.getFechaDevolucion());
            pst.setDouble(6, v.getTotal());
            pst.setString(7, v.getComentario());
            pst.setInt(8, v.getIdUsuarioRegistro());
            pst.setString(9, v.getEstado());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    
    
public DefaultTableModel consultarDetallePedido(int idPedido) {
    DefaultTableModel modelo;
    String[] titulos = {"Codigo","Descripcion", "Cantidad", "Precio", "Importe"};
    modelo = new DefaultTableModel(null, titulos);

    String sql = "SELECT dp.idproducto,dp.Descripcion, dp.cantidad, dp.precio, dp.importe " +
                 "FROM pedidodetalle dp " +
                 "WHERE dp.idpedido = ?";

    try {
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idPedido);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            
             int cod = rs.getInt("idproducto");
            String descripcion = rs.getString("Descripcion");
            int cantidad = rs.getInt("cantidad");
            double precio = rs.getDouble("precio");
            double importe = rs.getDouble("importe");

            Object[] fila = {cod,descripcion, cantidad, precio, importe};
            modelo.addRow(fila);
        }

        return modelo;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar detalle del pedido: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}

   
 public DefaultTableModel consultarPedidosPorClienteNombre(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"NªPedido",  "Cliente","Destajero", "Represetante","F-Pedido", "F-Devolucion", "Total", "Comentario", "Estado"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT p.IdPedido, c.RazonSocial AS ClienteRazonSocial, e.RazonSocial AS EmpresaRazonSocial,e.RepresentanteLegal, p.Fecha AS PedidoFecha, p.FechaDevolucion AS PedidoFechaDevolucion, p.Total AS PedidoTotal, p.Comentario AS PedidoComentario, p.Estado AS PedidoEstado " +
              "FROM pedido p " +
              "JOIN cliente c ON p.IdCliente = c.IdCliente " +
              "JOIN empresadestajero e ON p.IdEmpresaDestajero = e.IdEmpresaDestajero " +
              "WHERE c.RazonSocial LIKE ?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + buscar + "%");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                registros[0] = rs.getString("IdPedido");
         
                registros[1] = rs.getString("ClienteRazonSocial");
                 registros[2] = rs.getString("EmpresaRazonSocial");
                  registros[3] = rs.getString("RepresentanteLegal");
                
                registros[4] = rs.getString("PedidoFecha");
                registros[5] = rs.getString("PedidoFechaDevolucion");
                registros[6] = rs.getString("PedidoTotal");
                registros[7] = rs.getString("PedidoComentario");
                registros[8] = rs.getString("PedidoEstado");
                modelo.addRow(registros);
            }
            
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
 
 
 public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado) {
    String sql = "UPDATE pedido SET Estado = ? WHERE IdPedido = ?";
    try {
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nuevoEstado);
        ps.setInt(2, idPedido);

        int n = ps.executeUpdate();
        return n != 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el estado del pedido: " + e.getMessage());
        return false;
    }
}
 
   public int autogenerarIdPedido() {
        int idGenerado = 0;
        try {
            String sql = "SELECT MAX(IdPedido) FROM pedido";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idGenerado = rs.getInt(1) + 1;
            } else {
                idGenerado = 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return idGenerado;
    }
}
