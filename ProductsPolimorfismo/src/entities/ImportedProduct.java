package entities;

public class ImportedProduct extends Product{
    private double customFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, double price, double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public double totalPrice() {
        return price + customFee;
    }

    @Override
    public String priceTag() {
        return name + " $" + totalPrice() + " (Custom fee $" + customFee + ")";
    }
}
