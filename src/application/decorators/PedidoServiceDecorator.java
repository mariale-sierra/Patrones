package application.decorators;

import application.IPedidoService;
import domain.Pedido;

public abstract class PedidoServiceDecorator implements IPedidoService {

    protected IPedidoService wrappedService;

    public PedidoServiceDecorator(IPedidoService wrappedService) {
        this.wrappedService = wrappedService;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        wrappedService.crearPedido(pedido);
    }

    @Override
    public void cancelarPedido(int id) {
        wrappedService.cancelarPedido(id);
    }

    @Override
    public void confirmarPedido(int id) {
        wrappedService.confirmarPedido(id);
    }
}
