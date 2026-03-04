package application.decorators;

import application.IPedidoService;
import domain.Pedido;

public class SecurityDecorator extends PedidoServiceDecorator {

    public SecurityDecorator(IPedidoService wrappedService) {
        super(wrappedService);
    }

    private void checkPermission() {
        boolean autorizado = true; // Simulación

        if (!autorizado) {
            throw new SecurityException("Usuario no autorizado.");
        }
    }

    @Override
    public void crearPedido(Pedido pedido) {
        checkPermission();
        super.crearPedido(pedido);
    }

    @Override
    public void cancelarPedido(int id) {
        checkPermission();
        super.cancelarPedido(id);
    }

    @Override
    public void confirmarPedido(int id) {
        checkPermission();
        super.confirmarPedido(id);
    }
}
