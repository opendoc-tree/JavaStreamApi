import java.util.List;

public class GroupAmount {
    private String category;
    private double groupPrice;
    private List<Product> products;

    public GroupAmount(String category, double groupPrice, List<Product> products) {
        this.category = category;
        this.groupPrice = groupPrice;
        this.products = products;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(double groupPrice) {
        this.groupPrice = groupPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{" +
                "category='" + category + '\'' +
                ", groupPrice=" + groupPrice +
                ", products=" + products +
                '}';
    }
}
