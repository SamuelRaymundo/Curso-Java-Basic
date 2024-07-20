package entities;

import java.time.LocalDate;
import java.util.Date;

public class UsedProduct extends Product{

    private LocalDate manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return name + "(used) $" + price + " (Manufacture date: " + manufactureDate + ")";
    }
}
