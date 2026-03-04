package domain;

public class PedidoPrototype {

    private Pedido pedidoBase;

    public PedidoPrototype() {
        pedidoBase = new Pedido();
    }

    public Pedido obtenerPlantilla() {
        return pedidoBase.clone();
    }
}