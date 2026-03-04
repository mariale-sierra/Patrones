package infrastructure;

import domain.Pedido;

public interface IPedidoRepository {

    void save(Pedido pedido);

    Pedido findById(int id);
}