package presentation;

import application.IPedidoService;
import domain.Pedido;

public class PedidoController {
    private IPedidoService pedidoService;

    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void crearPedido(Pedido pedido) {
        Command comando = new CrearPedidoCommand(pedidoService, pedido);
        comando.execute();
    }

    public void cancelarPedido(int id) {
        Command comando = new CancelarPedidoCommand(pedidoService, id);
        comando.execute();
    }

    public void confirmarPedido(int id) {
        Command comando = new ConfirmarPedidoCommand(pedidoService, id);
        comando.execute();
    }
}