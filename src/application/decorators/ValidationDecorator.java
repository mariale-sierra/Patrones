package application.decorators;

import application.IPedidoService;
import domain.Pedido;

public class ValidationDecorator extends PedidoServiceDecorator {

    public ValidationDecorator(IPedidoService wrappedService) {
        super(wrappedService);
    }

    @Override
    public void crearPedido(Pedido pedido) {

        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser null.");
        }

        if (pedido.getProductos() == null || pedido.getProductos().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un producto.");
        }

        super.crearPedido(pedido);
    }
}
