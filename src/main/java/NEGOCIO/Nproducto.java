/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;

import DATO.DAOproducto;
import ENTIDAD.Eproducto;
import ENTIDAD.Emodelo;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class Nproducto {
    
 private DAOproducto datos = new DAOproducto();
    private Eproducto objProducto = new Eproducto();
    
    public DefaultTableModel mostrar(String buscar) {
        return datos.consultar(buscar);
    }
    
    public boolean insertarregistro(int idModelo, String descripcion, double precio, int stock, int idUsuarioRegistro, int estado) {
        objProducto.setIdModelo(idModelo);
        objProducto.setDescripcion(descripcion);
        objProducto.setPrecio(precio);
        objProducto.setStock(stock);
        objProducto.setIdUsuarioRegistro(idUsuarioRegistro);
        objProducto.setEstado(estado);
        
        return datos.insertar(objProducto);
    }
    
  public DefaultComboBoxModel<String> obtenerModelosActivos() {
        DefaultTableModel modeloTabla = listarModelosActivos();
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloCombo.addElement(modeloTabla.getValueAt(i, 1).toString());
        }

        return modeloCombo;
    }
     
     
     
      public DefaultTableModel listarModelosActivos() {
        return datos.listarModelosActivos();
    }
      
      
  
      
      
      public boolean validarCampos(String descripcion, double precio, int stock) {
        return !descripcion.isEmpty() && precio > 0 && stock >= 0;
    }


}
