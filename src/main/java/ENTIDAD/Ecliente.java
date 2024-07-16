/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDAD;



public class Ecliente {
    
 private int idCliente;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String representanteLegal;
    private int idUsuarioRegistro;
    private int estado;

    public Ecliente() {
    }

    public Ecliente(int idCliente, String ruc, String razonSocial, String direccion, String telefono, String representanteLegal, int idUsuarioRegistro, int estado) {
        this.idCliente = idCliente;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.representanteLegal = representanteLegal;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public int getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(int idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

  
}