package entities;

public class Products {
    private String product;
    private double price;
    private int quantity;

    public Products( String product, double price, int quantity) {
        this.price = price;
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double fullPrice() {
        return price * quantity;
    }
}
