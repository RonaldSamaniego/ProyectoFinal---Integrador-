/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTIDAD;


public class Eproducto {
private int idProducto;
    private int idModelo;
    private String descripcion;
    private double precio;
    private int stock;
    private int idUsuarioRegistro;
    private int estado;

    private String nombre;
    
    public Eproducto() {
    }

    public Eproducto(int idProducto, int idModelo, String descripcion, double precio, int stock, int idUsuarioRegistro, int estado,String nombre) {
        this.idProducto = idProducto;
        this.idModelo = idModelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.estado = estado;
        this.nombre=nombre;
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
    
 public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }


}