package Main;

import Model.Client;
import Model.Product;
import Model.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear cliente
        Client client = new Client("Juan Perez", "juanperez@gmail.com");

        // Crear catálogo de productos
        ArrayList<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Laptop", 1000.0, 1));
        catalog.add(new Product("Mouse", 50.0, 2));
        catalog.add(new Product("Teclado", 80.0, 3));
        catalog.add(new Product("Monitor", 200.0, 4));
        catalog.add(new Product("Impresora", 300.0, 5));
        catalog.add(new Product("Tablet", 400.0, 6));
        catalog.add(new Product("Auriculares", 60.0, 7));
        catalog.add(new Product("Webcam", 90.0, 8));
        catalog.add(new Product("Micrófono", 120.0, 9));
        catalog.add(new Product("Silla Gamer", 250.0, 10));

        // Mostrar catálogo
        System.out.println("🛍️ Catálogo de productos:");
        for (Product p : catalog) {
            System.out.println("ID: " + p.getIdProduct() + " - " + p.getNameProduct() + " ($" + p.getCost() + ")");
        }

        // Crear orden
        Order order = new Order(1001, client);

        // Selección dinámica de productos
        while (true) {
            System.out.print("\nIngrese el ID del producto que desea comprar (o escriba 'n' para finalizar): ");

            if (sc.hasNextInt()) {
                int inputId = sc.nextInt();
                Product selected = null;

                for (Product p : catalog) {
                    if (p.getIdProduct() == inputId) {
                        selected = p;
                        break;
                    }
                }

                if (selected != null) {
                    order.addProduct(selected);
                    System.out.println("✅ Producto agregado: " + selected.getNameProduct());
                } else {
                    System.out.println("❌ Opción inválida. Intente de nuevo..");
                }
            } else {
                String input = sc.next();
                if (input.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("❌ Entrada inválida. Debe ingresar un número o 'n' para salir.");
                }
            }
        }

        // Mostrar resumen del pedido
        System.out.println("\n🧾 Resumen del pedido:");
        order.showOrder();
    }
}
