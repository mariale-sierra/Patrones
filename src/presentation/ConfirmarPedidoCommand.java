package presentation;

import application.IPedidoService;

public class ConfirmarPedidoCommand implements Command {
    private IPedidoService pedidoService;
    private int pedidoId;

    public ConfirmarPedidoCommand(IPedidoService pedidoService, int pedidoId) {
        this.pedidoService = pedidoService;
        this.pedidoId = pedidoId;
    }

    @Override
    public void execute() {
        pedidoService.confirmarPedido(pedidoId);
    }
}