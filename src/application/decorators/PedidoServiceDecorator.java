package application.decorators;

import application.IPedidoService;

public abstract class PedidoServiceDecorator implements IPedidoService {

    protected IPedidoService wrappedService;

    public PedidoServiceDecorator(IPedidoService wrappedService) {
        this.wrappedService = wrappedService;
    }

    @Override
    public void crearPedido(String nombre, double precio) {
        wrappedService.crearPedido(nombre, precio);
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