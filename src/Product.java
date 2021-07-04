public class Product {

    private String category;
    private String name;
    private double price;
    private double offer;
    private double payPrice;

    public Product(String category, String name, double price, double offer) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.offer = offer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(double payPrice) {
        this.payPrice = payPrice;
    }

    @Override
    public String toString() {
        return "{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", offer=" + offer +
                ", payPrice=" + payPrice +
                "}\n";
    }
}
