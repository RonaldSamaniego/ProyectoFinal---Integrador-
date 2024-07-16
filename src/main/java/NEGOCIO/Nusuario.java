/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIO;

import DATO.DAOusuario;
import ENTIDAD.Eusuario;
import javax.swing.table.DefaultTableModel;


import DATO.DAOusuario;
import ENTIDAD.Eusuario;
import javax.swing.table.DefaultTableModel;


public class Nusuario {
    private DAOusuario datos = new DAOusuario();

    public DefaultTableModel mostrar(String buscar) {
        return datos.consultar(buscar);
    }

    public boolean insertarUsuario(String usuario, String contraseña, String cargo, int estado) {
        Eusuario nuevoUsuario = new Eusuario();
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setCargo(cargo);
        nuevoUsuario.setEstado(estado);

        return datos.insertar(nuevoUsuario);
    }

    public boolean validarLogin(String usuario, String contraseña) {
        Eusuario user = new Eusuario();
        user.setUsuario(usuario);
        user.setContraseña(contraseña);

        return datos.login(user);
    }
}