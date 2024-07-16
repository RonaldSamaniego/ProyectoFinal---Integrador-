/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;

import DATO.DAOpedidodetalle;
import ENTIDAD.Epedidodetalle;
import javax.swing.table.DefaultTableModel;
public class NpedidoDetalle {
    
 private DAOpedidodetalle datos = new DAOpedidodetalle();
    private Epedidodetalle objPedidoDetalle = new Epedidodetalle();
    
    public DefaultTableModel mostrar(String buscar) {
        return datos.consultar(buscar);
    }
    
    public boolean insertarDetalle(int idPedido, int idProducto, String descripcion, int cantidad, double precio, double importe) {
        objPedidoDetalle.setIdPedido(idPedido);
        objPedidoDetalle.setIdProducto(idProducto);
        objPedidoDetalle.setDescripcion(descripcion);
        objPedidoDetalle.setCantidad(cantidad);
        objPedidoDetalle.setPrecio(precio);
        objPedidoDetalle.setImporte(importe);
        
        return datos.insertar(objPedidoDetalle);
    }
}
