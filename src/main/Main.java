IPedidoRepository repository = new PedidoRepository();
IUnitOfWork unitOfWork = new UnitOfWork();

IPedidoService service = new PedidoService(repository, unitOfWork);

// Decorators (tu parte)
service = new ValidationDecorator(service);
service = new LoggingDecorator(service);
service = new SecurityDecorator(service);
