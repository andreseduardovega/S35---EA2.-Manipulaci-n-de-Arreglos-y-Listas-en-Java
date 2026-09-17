/** Pila manual implementada con nodos enlazados; no usa java.util.Stack. */
public class PilaPizza {
    private Nodo tope;
    private int tamanio;

    public void push(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("No se puede apilar una pizza nula.");
        }
        Nodo nuevo = new Nodo(pizza);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        Pizza pizzaRetirada = tope.dato;
        tope = tope.siguiente;
        tamanio--;
        return pizzaRetirada;
    }

    public Pizza peek() {
        return isEmpty() ? null : tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int size() {
        return tamanio;
    }

    /** Vacía la pila retirando sus nodos uno a uno. */
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }
}
