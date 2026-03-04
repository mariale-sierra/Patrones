package application;

import domain.Pedido;

public interface IPedidoService {
    void crearPedido(Pedido pedido);
    void cancelarPedido(int id);
    void confirmarPedido(int id);
}