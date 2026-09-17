/** Coordina las pilas de pedidos activos (undo) y pedidos deshechos (redo). */
public class GestionPedidos {
    private final PilaPizza pilaPrincipal = new PilaPizza();
    private final PilaPizza pilaSecundaria = new PilaPizza();

    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
        // Un pedido nuevo crea una nueva historia; ya no corresponde rehacer los anteriores.
        pilaSecundaria.clear();
    }

    public Pizza deshacer() {
        if (pilaPrincipal.isEmpty()) {
            return null;
        }
        Pizza pizza = pilaPrincipal.pop();
        pilaSecundaria.push(pizza);
        return pizza;
    }

    public Pizza rehacer() {
        if (pilaSecundaria.isEmpty()) {
            return null;
        }
        Pizza pizza = pilaSecundaria.pop();
        pilaPrincipal.push(pizza);
        return pizza;
    }

    public Pizza obtenerPedidoActual() {
        return pilaPrincipal.peek();
    }
}
