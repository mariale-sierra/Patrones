package infrastructure;

import domain.Pedido;

public class PedidoRepository implements IPedidoRepository {

    private DatabaseContext db;

    public PedidoRepository(DatabaseContext db) {
        this.db = db;
    }

    @Override
    public void save(Pedido pedido) {
        db.getPedidos().add(pedido);
    }

    @Override
    public Pedido findById(int id) {

        for (Pedido p : db.getPedidos()) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }
}