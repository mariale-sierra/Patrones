package presentation;

import application.IPedidoService;
import domain.Pedido;

public class CrearPedidoCommand implements Command {
    private IPedidoService pedidoService;
    private Pedido pedido;

    public CrearPedidoCommand(IPedidoService pedidoService, Pedido pedido) {
        this.pedidoService = pedidoService;
        this.pedido = pedido;
    }

    @Override
    public void execute() {
        pedidoService.crearPedido(pedido);
    }
}