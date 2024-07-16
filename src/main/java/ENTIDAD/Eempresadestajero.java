/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTIDAD;


public class Eempresadestajero {
    
 private int idEmpresaDestajero;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String representanteLegal;
    private int idUsuarioRegistro;
    private int estado;

    public Eempresadestajero() {
    }

    public Eempresadestajero(int idEmpresaDestajero, String ruc, String razonSocial, String direccion, String telefono, String representanteLegal, int idUsuarioRegistro, int estado) {
        this.idEmpresaDestajero = idEmpresaDestajero;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.representanteLegal = representanteLegal;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.estado = estado;
    }

    public int getIdEmpresaDestajero() {
        return idEmpresaDestajero;
    }

    public void setIdEmpresaDestajero(int idEmpresaDestajero) {
        this.idEmpresaDestajero = idEmpresaDestajero;
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

    @Override
    public String toString() {
        return "EmpresaDestajero{" +
                "idEmpresaDestajero=" + idEmpresaDestajero +
                ", ruc='" + ruc + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", representanteLegal='" + representanteLegal + '\'' +
                ", idUsuarioRegistro=" + idUsuarioRegistro +
                ", estado=" + estado +
                '}';
    }
}
