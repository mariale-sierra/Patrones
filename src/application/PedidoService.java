package application;

import domain.Pedido;
import domain.PedidoPrototype;
import infrastructure.IPedidoRepository;
import infrastructure.IUnitOfWork;

public class PedidoService implements IPedidoService {

    private IPedidoRepository pedidoRepository;
    private IUnitOfWork unitOfWork;
    private PedidoPrototype pedidoPrototype;

    public PedidoService(IPedidoRepository pedidoRepository, IUnitOfWork unitOfWork) {
        this.pedidoRepository = pedidoRepository;
        this.unitOfWork = unitOfWork;
        this.pedidoPrototype = new PedidoPrototype();
    }

    @Override
    public void crearPedido(Pedido pedido) {
        // Clonar plantilla base usando Prototype
        Pedido nuevoPedido = pedidoPrototype.obtenerPlantilla();

        // Agregar productos del pedido recibido
        for (domain.Producto p : pedido.getProductos()) {
            nuevoPedido.agregarProducto(p);
        }

        // Guardar y confirmar transacción
        pedidoRepository.save(nuevoPedido);
        unitOfWork.commit();

        System.out.println("Pedido creado. Total: " + nuevoPedido.getTotal());
    }

    @Override
    public void cancelarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id);

        if (pedido == null) {
            System.out.println("Pedido con id " + id + " no encontrado.");
            return;
        }

        pedido.cancelar();
        pedidoRepository.save(pedido);
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
        pedidoRepository.save(pedido);
        unitOfWork.commit();

        System.out.println("Pedido " + id + " confirmado. Total: " + pedido.getTotal());
    }
}