/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;

import DATO.DAOmodelo;
import ENTIDAD.Emodelo;
import javax.swing.table.DefaultTableModel;


public class Nmodelo {
    
private DAOmodelo datos = new DAOmodelo();
    private Emodelo objModelo = new Emodelo();
    
    public DefaultTableModel mostrar(String buscar) {
        return datos.consultar(buscar);
    }
    
    public boolean insertarregistro(int idModelo, String nombre, int estado) {
        objModelo.setIdModelo(idModelo);
        objModelo.setNombre(nombre);
        objModelo.setEstado(estado);
        
        return datos.insertar(objModelo);
    }
}
