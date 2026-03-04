package application.decorators;

import application.IPedidoService;
import domain.Pedido;

public class LoggingDecorator extends PedidoServiceDecorator {

    public LoggingDecorator(IPedidoService wrappedService) {
        super(wrappedService);
    }

    @Override
    public void crearPedido(Pedido pedido) {
        System.out.println("[LOG] Iniciando creación de pedido...");
        super.crearPedido(pedido);
        System.out.println("[LOG] Pedido creado.");
    }

    @Override
    public void cancelarPedido(int id) {
        System.out.println("[LOG] Cancelando pedido: " + id);
        super.cancelarPedido(id);
        System.out.println("[LOG] Pedido cancelado.");
    }

    @Override
    public void confirmarPedido(int id) {
        System.out.println("[LOG] Confirmando pedido: " + id);
        super.confirmarPedido(id);
        System.out.println("[LOG] Pedido confirmado.");
    }
}
