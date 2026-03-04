package application.decorators;

import application.IPedidoService;

public class ValidationDecorator extends PedidoServiceDecorator {

    public ValidationDecorator(IPedidoService wrappedService) {
        super(wrappedService);
    }

    @Override
    public void crearPedido(String nombre, double precio) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }

        super.crearPedido(nombre, precio);
    }
}