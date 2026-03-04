    //infrastructure
DatabaseContext databaseContext = new DatabaseContext();
IPedidoRepository repository = new PedidoRepository();
IUnitOfWork unitOfWork = new UnitOfWork();

IPedidoService service = new PedidoService(repository, unitOfWork);

// Decorators (tu parte)
pedidoService = new ValidationDecorator(pedidoService);
pedidoService = new LoggingDecorator(pedidoService);
pedidoService = new SecurityDecorator(pedidoService);

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




        PedidoPrototype prototype = new PedidoPrototype();

        IPedidoService pedidoService = new PedidoService(
                repository,
                unitOfWork,
                prototype
        );

        


        // simulacion
        System.out.println("-------- CREAR PEDIDO -------- ");
        pedidoService.crearPedido(1);

        System.out.println("-------- CONFIRMAR PEDIDO -------- ");
        pedidoService.confirmarPedido(1);

        System.out.println("-------- CANCELAR PEDIDO -------- ");
        pedidoService.cancelarPedido(1);
    }
}