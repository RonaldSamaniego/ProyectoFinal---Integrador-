/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;

import DATO.DAOempresadestajero;
import ENTIDAD.Eempresadestajero;

import javax.swing.table.DefaultTableModel;


public class NempresaDestajero {
    private DAOempresadestajero datos = new DAOempresadestajero();
    private Eempresadestajero objEmpresaDestajero = new Eempresadestajero();

    public DefaultTableModel mostrar(String buscar) {
        return datos.consultar(buscar);
    }

    public boolean insertarregistro(String ruc, String razonSocial, String direccion, String telefono, String representanteLegal, int idUsuarioRegistro, int estado) {
   
        objEmpresaDestajero.setRuc(ruc);
        objEmpresaDestajero.setRazonSocial(razonSocial);
        objEmpresaDestajero.setDireccion(direccion);
        objEmpresaDestajero.setTelefono(telefono);
        objEmpresaDestajero.setRepresentanteLegal(representanteLegal);
        objEmpresaDestajero.setIdUsuarioRegistro(idUsuarioRegistro);
        objEmpresaDestajero.setEstado(estado);

    
       

        return datos.insertar(objEmpresaDestajero);
    }

    public boolean validarCampos(String ruc, String razonSocial, String direccion, String telefono, String representanteLegal) {
        return !ruc.isEmpty() && !razonSocial.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !representanteLegal.isEmpty();
    }
}