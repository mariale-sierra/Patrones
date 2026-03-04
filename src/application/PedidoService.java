package application;

import domain.Pedido;
import domain.PedidoPrototype;
import domain.Producto;
import infrastructure.IPedidoRepository;
import infrastructure.IUnitOfWork;

public class PedidoService implements IPedidoService {

    private IPedidoRepository pedidoRepository;
    private IUnitOfWork unitOfWork;
    private PedidoPrototype pedidoPrototype;

    public PedidoService(IPedidoRepository pedidoRepository, IUnitOfWork unitOfWork, PedidoPrototype pedidoPrototype) {
        this.pedidoRepository = pedidoRepository;
        this.unitOfWork = unitOfWork;
        this.pedidoPrototype = new PedidoPrototype();
    }

    @Override
    public void crearPedido(String nombreProducto, double precio) {

    Pedido nuevoPedido = pedidoPrototype.obtenerPlantilla();

    Producto producto = new Producto(nombreProducto, precio);
    nuevoPedido.agregarProducto(producto);

    pedidoRepository.save(nuevoPedido);
    unitOfWork.commit();
}

    @Override
    public void cancelarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id);

        if (pedido == null) {
            System.out.println("Pedido con id " + id + " no encontrado.");
            return;
        }

        pedido.cancelar();
        unitOfWork.commit();

        System.out.println("Pedido " + id + " cancelado.");
    }

    @Override
    public void confirmarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id);

        if (pedido == null) {
            System.out.println("Pedido con id " + id + " no encontrado.");
            return;
        }

        pedido.confirmar();
        unitOfWork.commit();

        System.out.println("Pedido " + id + " confirmado. Total: " + pedido.getTotal());
    }
}