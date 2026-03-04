package domain;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre= nombre;
        this.precio = precio;
    }

    public Producto(Producto producto){
        this.nombre = producto.nombre;
        this.precio = producto.precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

}
