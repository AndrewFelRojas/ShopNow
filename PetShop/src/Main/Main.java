package Main;
import Model.Client;
import Model.Product;
import Model.Order;
public class Main {
    public static void main(String[] args) {
        Client client = new Client("Juan Perez", "juanperez@gmail.com");
        Product product1 = new Product("Laptop", 1000.0, 123459);
        Product product2 = new Product("Mouse", 50.0, 123456);
        Product product3 = new Product("Monitor", 1500.0, 123457);
        Product product4 = new Product("Mouse", 50.0, 123458);
        Product product5 = new Product("Monitor", 200.0, 123459);

        client.mostrarInfo();
        product1.mostrarInfoProduct();
        Order Order = new Order(1,client);
        Order.addProduct(product1);
        Order.addProduct(product2);
        Order.addProduct(product3);
        Order.addProduct(product4);
        Order.addProduct(product5);
        
        System.out.println("Total cost: " + Order.totalCost());
    }
}