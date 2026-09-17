import java.util.Scanner;

/** Punto de entrada del sistema Pizza-Track. */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    registrarPizza(scanner, gestion);
                    break;
                case 2:
                    Pizza deshecha = gestion.deshacer();
                    System.out.println(deshecha == null
                            ? "No hay pedidos activos para deshacer."
                            : "Pedido deshecho: " + deshecha);
                    break;
                case 3:
                    Pizza rehecha = gestion.rehacer();
                    System.out.println(rehecha == null
                            ? "No hay pedidos para rehacer."
                            : "Pedido recuperado: " + rehecha);
                    break;
                case 4:
                    Pizza actual = gestion.obtenerPedidoActual();
                    System.out.println(actual == null
                            ? "No hay una pizza lista para producción."
                            : "Pizza lista para producción: " + actual);
                    break;
                case 0:
                    System.out.println("Gracias por usar Pizza-Track.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== PIZZA-TRACK ===");
        System.out.println("1. Registrar Pizza (Escribir)");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar Pedido Actual");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número de opción: ");
            scanner.nextLine();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    private static void registrarPizza(Scanner scanner, GestionPedidos gestion) {
        System.out.print("Nombre de la pizza: ");
        String nombre = scanner.nextLine();
        String[] ingredientes = new String[3];
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredientes[i] = scanner.nextLine();
        }

        try {
            Pizza pizza = new Pizza(nombre, ingredientes);
            gestion.registrarPedido(pizza);
            System.out.println("Pedido registrado: " + pizza);
        } catch (IllegalArgumentException e) {
            System.out.println("No se registró el pedido: " + e.getMessage());
        }
    }
}
