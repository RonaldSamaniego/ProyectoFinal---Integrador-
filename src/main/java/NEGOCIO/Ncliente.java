/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;


import DATO.DAOcliente;
import ENTIDAD.Ecliente;
import javax.swing.table.DefaultTableModel;

        
public class Ncliente {
    
    private DAOcliente datos = new DAOcliente();
    private Ecliente objCliente = new Ecliente();
    
    public DefaultTableModel mostrar(String buscar) {
        return datos.consultar(buscar);
    }
    
    public boolean insertarregistro(String ruc, String razonSocial, String direccion, String telefono, String representanteLegal, int idUsuarioRegistro, int estado) {
       
        objCliente.setRuc(ruc); 
        objCliente.setRazonSocial(razonSocial);
        objCliente.setDireccion(direccion);
        objCliente.setTelefono(telefono);
        objCliente.setRepresentanteLegal(representanteLegal); 
        
         objCliente.setIdUsuarioRegistro(idUsuarioRegistro);
        objCliente.setEstado(estado); 
        
        
        
        return datos.insertar(objCliente);
    }
    
    public boolean validarCampos(String ruc, String razonSocial, String direccion, String telefono, String representanteLegal) {
    return !ruc.isEmpty() && !razonSocial.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !representanteLegal.isEmpty();
}
    
}