import java.util.Arrays;

/** Representa un pedido de pizza con exactamente tres ingredientes. */
public class Pizza {
    private final String nombre;
    private final String[] ingredientes;

    public Pizza(String nombre, String[] ingredientes) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la pizza es obligatorio.");
        }
        if (ingredientes == null || ingredientes.length != 3) {
            throw new IllegalArgumentException("La pizza debe tener exactamente 3 ingredientes.");
        }

        this.nombre = nombre.trim();
        this.ingredientes = Arrays.copyOf(ingredientes, 3);
        for (int i = 0; i < this.ingredientes.length; i++) {
            if (this.ingredientes[i] == null || this.ingredientes[i].trim().isEmpty()) {
                throw new IllegalArgumentException("El ingrediente " + (i + 1) + " es obligatorio.");
            }
            this.ingredientes[i] = this.ingredientes[i].trim();
        }
    }

    public String getNombre() {
        return nombre;
    }

    /** Retorna una copia para no exponer el arreglo interno. */
    public String[] getIngredientes() {
        return Arrays.copyOf(ingredientes, ingredientes.length);
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: " + String.join(", ", ingredientes);
    }
}
