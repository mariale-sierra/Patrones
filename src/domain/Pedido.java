package domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private List<Producto> productos;
    private String estado;
    private double total;

    public Pedido() {
        this.productos = new ArrayList<>();
        this.estado = "CREADO";
        this.total = 0.0;
    }

    public Pedido(Pedido pedido) {
        this.id = pedido.id;
        this.productos = new ArrayList<>();
        for (Producto p : pedido.productos) {
            this.productos.add(new Producto(p));
        }
        this.estado = pedido.estado;
        this.total = pedido.total;
    }

    public Pedido clone() {
        return new Pedido(this);
    }

    //MÉTODOS PARA NEGOCIO

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0.0;
        for (Producto p: productos) {
            total += p.getPrecio();
        }
    }

    public void confirmar() {
        this.estado = "CONFIRMADO";
    }

    public void cancelar() {
        this.estado = "CANCELADO";
    }

    public String getEstado() {
        return estado;
    }

    public List<Producto> getProductos() {
    return productos;
    }

    public double getTotal() {
        return total;
    }

    
}