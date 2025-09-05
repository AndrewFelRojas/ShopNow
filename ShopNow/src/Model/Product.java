package Model;

public class Product {
    private String nameProduct;
    private double cost;
    private int idProduct;
    
    public Product(String nameProduct, double cost, int IdProduct) {
        this.nameProduct = nameProduct;
        this.cost = cost;
        this.idProduct = IdProduct;
    }

	public void mostrarInfoProduct() {
        System.out.println("Product name: " + nameProduct + ", Product cost: " + cost + " and Product ID: " + idProduct);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

}