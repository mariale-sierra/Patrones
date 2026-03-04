package application;

public interface IPedidoService {
    void crearPedido(String nombreProducto, double precio);
    void cancelarPedido(int id);
    void confirmarPedido(int id);
}