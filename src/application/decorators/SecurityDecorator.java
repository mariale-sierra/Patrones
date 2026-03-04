package application.decorators;

import application.IPedidoService;

public class SecurityDecorator extends PedidoServiceDecorator {

    public SecurityDecorator(IPedidoService wrappedService) {
        super(wrappedService);
    }

    private void checkPermission() {
        boolean autorizado = true;
        if (!autorizado) {
            throw new SecurityException("Usuario no autorizado.");
        }
    }

    @Override
    public void crearPedido(String nombre, double precio) {
        checkPermission();
        super.crearPedido(nombre, precio);
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