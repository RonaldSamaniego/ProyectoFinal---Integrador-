/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATO;


import ENTIDAD.Epedidodetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BDCONEXION.Conexion;
public class DAOpedidodetalle {
    

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sql;

    public DefaultTableModel consultar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"IdPedido", "IdProducto", "Descripcion", "Cantidad", "Precio", "Importe"};

        String[] registros = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT * FROM pedidodetalle WHERE Descripcion LIKE '%" + buscar + "%'";

        try {

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                registros[0] = rs.getString("IdPedido");
                registros[1] = rs.getString("IdProducto");
                registros[2] = rs.getString("Descripcion");
                registros[3] = rs.getString("Cantidad");
                registros[4] = rs.getString("Precio");
                registros[5] = rs.getString("Importe");

                modelo.addRow(registros);
            }

            return modelo;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;

        }

    }

    public boolean insertar(Epedidodetalle v) {

        sql = "INSERT INTO pedidodetalle (IdPedido, IdProducto, Descripcion, Cantidad, Precio, Importe) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, v.getIdPedido());
            pst.setInt(2, v.getIdProducto());
            pst.setString(3, v.getDescripcion());
            pst.setInt(4, v.getCantidad());
            pst.setDouble(5, v.getPrecio());
            pst.setDouble(6, v.getImporte());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
