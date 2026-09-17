/** Pila manual implementada con nodos enlazados; no usa java.util.Stack. */
public class PilaPizza {
    private Nodo tope;
    private int tamanio;

    public void push(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("No se puede apilar una pizza nula.");
        }
        Nodo nuevo = new Nodo(pizza);

// El nuevo nodo apunta al nodo que actualmente está en el tope.
// De esta forma se conserva la referencia al resto de la pila.
nuevo.siguiente = tope;

// El nuevo nodo pasa a ser el nuevo tope de la pila.
tope = nuevo;

tamanio++;
    }

   public Pizza pop() {
    if (isEmpty()) {
        return null;
    }

    // Se guarda la pizza que está en el nodo superior antes de retirarlo.
    Pizza pizzaRetirada = tope.dato;

    // El tope avanza al siguiente nodo de la lista ligada.
    // De esta forma, el nodo superior anterior queda fuera de la pila.
    tope = tope.siguiente;

    tamanio--;
    return pizzaRetirada;
}

    /**
 * Consulta la pizza ubicada en el tope sin retirarla de la pila.
 * Permite conocer el pedido actual manteniendo intacta la estructura.
 */
public Pizza peek() {
    return isEmpty() ? null : tope.dato;
}

   /**
 * Determina si la pila está vacía.
 * Si tope es null, significa que no existe ningún nodo en la pila.
 */
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
