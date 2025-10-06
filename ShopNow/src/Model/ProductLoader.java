package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {

    public static List<Product> LoadProducts(String pathfile) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathfile))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] Values = line.split(",");
                int IdProduct =Integer.parseInt(Values[0]);
                String nameProduct = Values[1];
                double cost = Double.parseDouble(Values[2]);
                products.add(new Product(IdProduct,nameProduct,cost));
                
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }
        return products;
    }
}