package Model;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Order {
    private int IdOrder;
    private ArrayList<Product> products = new ArrayList<>();
    private LocalDateTime buyDate;

    public Order(int IdOrder, Client client) {
        this.IdOrder = IdOrder;
        this.products = new ArrayList<>();
        this.buyDate = LocalDateTime.now();
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public double totalCost() {
        double totalCost = 0;
        for (int i = 0; i < products.size(); i++) {
            totalCost = totalCost + products.get(i).getCost();
        }
        return totalCost;
    }
    public void showOrder() {
        System.out.println("Pedido N°: " + IdOrder);

        for (Product p : products) {
            System.out.println(" - " + p.getNameProduct() + " ($" + p.getCost() + ")");
        }

        System.out.println("Total: $" + totalCost());

        // Formato de fecha en español
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy. HH:mm:ss", new Locale("es", "ES"));

        // Mostrar fecha de compra
        System.out.println("Fecha: " + buyDate.format(formatter));

        // Mostrar fecha de pago estimada (24 horas después)
        System.out.println("Fecha de pago estimada: " + buyDate.plusHours(24).format(formatter));
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
