package main;

import application.IPedidoService;
import application.PedidoService;
import application.decorators.LoggingDecorator;
import application.decorators.SecurityDecorator;
import application.decorators.ValidationDecorator;
import domain.PedidoPrototype;
import infrastructure.DatabaseContext;
import infrastructure.IPedidoRepository;
import infrastructure.IUnitOfWork;
import infrastructure.PedidoRepository;
import infrastructure.UnitOfWork;

public class Main {

    public static void main(String[] args) {

        DatabaseContext databaseContext = new DatabaseContext();
        IPedidoRepository repository = new PedidoRepository(databaseContext);
        IUnitOfWork unitOfWork = new UnitOfWork(databaseContext);
        PedidoPrototype prototype = new PedidoPrototype();

        IPedidoService pedidoService =
                new PedidoService(repository, unitOfWork, prototype);

        // Decorators
        pedidoService = new ValidationDecorator(pedidoService);
        pedidoService = new LoggingDecorator(pedidoService);
        pedidoService = new SecurityDecorator(pedidoService);

        // Simulación
        System.out.println("-------- CREAR PEDIDO -------- ");
        pedidoService.crearPedido("Laptop", 1000);

        System.out.println("-------- CONFIRMAR PEDIDO -------- ");
        pedidoService.confirmarPedido(1);

        System.out.println("-------- CANCELAR PEDIDO -------- ");
        pedidoService.cancelarPedido(1);
    }
}