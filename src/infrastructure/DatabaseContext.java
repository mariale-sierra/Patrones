package infrastructure;

import domain.Pedido;
import java.util.ArrayList;
import java.util.List;

public class DatabaseContext {

    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}