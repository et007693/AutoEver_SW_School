package ArrayListApply;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;
    private BigDecimal total;

    public Order() {
        this.products = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public void addItem(Product p) {
        products.add(p);
        total = total.add(p.getPrice());
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getItem(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public boolean removeItem(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                products.remove(p);
                total = total.subtract(p.getPrice());
                return true;
            }
        }
        return false;
    }

    public BigDecimal calculateFinalPrice(BigDecimal taxRate) {
        BigDecimal taxAmount = total.multiply(taxRate);
        BigDecimal finalPrice = total.add(taxAmount);
        return finalPrice.setScale(2, RoundingMode.HALF_UP);
    }
}
