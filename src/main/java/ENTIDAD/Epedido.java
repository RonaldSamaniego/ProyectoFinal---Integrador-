/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTIDAD;


public class Epedido {
    
private int idPedido;
    private int idCliente;
    private int idEmpresaDestajero;
    private String fecha;
    private String fechaDevolucion;
    private double total;
    private String comentario;
    private int idUsuarioRegistro;
    private String estado;

    public Epedido() {
    }

    public Epedido(int idPedido, int idCliente, int idEmpresaDestajero, String fecha, String fechaDevolucion, double total, String comentario, int idUsuarioRegistro, String estado) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idEmpresaDestajero = idEmpresaDestajero;
        this.fecha = fecha;
        this.fechaDevolucion = fechaDevolucion;
        this.total = total;
        this.comentario = comentario;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpresaDestajero() {
        return idEmpresaDestajero;
    }

    public void setIdEmpresaDestajero(int idEmpresaDestajero) {
        this.idEmpresaDestajero = idEmpresaDestajero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(int idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }}