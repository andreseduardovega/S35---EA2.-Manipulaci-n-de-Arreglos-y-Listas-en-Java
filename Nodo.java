/**
 * Nodo utilizado para construir la lista ligada de la pila.
 * Cada nodo almacena una pizza y una referencia al siguiente nodo.
 */
class Nodo {

    Pizza dato;

    // Referencia al siguiente nodo de la lista ligada.
    Nodo siguiente;

    Nodo(Pizza dato) {
        this.dato = dato;
    }
}