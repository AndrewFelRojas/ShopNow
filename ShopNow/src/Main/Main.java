package Main;

import Model.Client;
import Model.Product;
import Model.Order;
import Model.ProductLoader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Crear cliente
        Client client = new Client("Juan Perez", "juanperez@gmail.com");
        // Cargar catálogo desde archivo plano
        List<Product> catalog = ProductLoader.LoadProducts("C:\\Users\\andres\\eclipse-workspace\\ShopNow\\src\\Catalogo.txt");
        if (catalog.isEmpty()) {
            System.out.println("❌ No se pudo cargar el catálogo. Verifique el archivo.");
            return;
        }
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
