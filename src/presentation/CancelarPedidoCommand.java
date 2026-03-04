package presentation;

import application.IPedidoService;

public class CancelarPedidoCommand implements Command {
    private IPedidoService pedidoService;
    private int pedidoId;

    public CancelarPedidoCommand(IPedidoService pedidoService, int pedidoId) {
        this.pedidoService = pedidoService;
        this.pedidoId = pedidoId;
    }

    @Override
    public void execute() {
        pedidoService.cancelarPedido(pedidoId);
    }
}