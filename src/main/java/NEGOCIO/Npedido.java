/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;

import DATO.DAOpedido;
import ENTIDAD.Epedido;
import javax.swing.table.DefaultTableModel;

import DATO.DAOpedido;

public class Npedido {
    
 private DAOpedido datos = new DAOpedido();
    private Epedido objPedido = new Epedido();
    
    public DefaultTableModel mostrar(String buscar) {
        return datos.consultarPedidosPorClienteNombre(buscar);
    }
    
     public DefaultTableModel consultarDetallePedido(int idPedido) {
        return datos.consultarDetallePedido(idPedido);
    }
    
      public int autogenerarNuevoIdPedido() {
        return datos.autogenerarIdPedido();
    }
      
    public boolean insertarregistro(int IdPedido,int idCliente, int idEmpresaDestajero, String fecha, String fechaDevolucion, double total, String comentario, int idUsuarioRegistro, String estado) {

        
    
         objPedido.setIdPedido(IdPedido);
        
        objPedido.setIdCliente(idCliente);
        objPedido.setIdEmpresaDestajero(idEmpresaDestajero);
        objPedido.setFecha(fecha);
        objPedido.setFechaDevolucion(fechaDevolucion);
        objPedido.setTotal(total);
        objPedido.setComentario(comentario);
        objPedido.setIdUsuarioRegistro(idUsuarioRegistro);
        objPedido.setEstado(estado);
        
        return datos.insertar(objPedido);
    }
    
    
        public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado) {
        return datos.actualizarEstadoPedido(idPedido, nuevoEstado);
    
}


}
