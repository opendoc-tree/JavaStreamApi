import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Mobile","Samsung",12999,1500),
                new Product("Mobile","Realme",15999,2000),
                new Product("Mobile","Redmi",10599,1500),
                new Product("Tv","Samsung tv",222900,97901),
                new Product("Tv","Sony",66900,23901),
                new Product("Tv","Lg",69999,7000),
                new Product("Laptop","Hp",45892,2500),
                new Product("Laptop","Lenovo",35000,2500),
                new Product("Laptop","Dell",45599,1500)
        );

        System.out.println("======================= Find product by name =======================");

        Product product = products.stream()
                .filter(e->e.getName().equalsIgnoreCase("samsung"))
                .findAny().orElse(null);
        System.out.println(product);

        System.out.println();

        System.out.println("======================= Search product by keyword =======================");
        products.stream()
                .filter(e->e.getName().startsWith("R")).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("======================= Sorting by price (low to high) =======================");
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("================== Sorting by price (high to low) - reverse order ===================");
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice,Comparator.reverseOrder()))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("================== Find Max price product ===================");
        Product max = products.stream()
                .max(Comparator.comparing(Product::getPrice))
        .orElse(null);
        System.out.println(max);

        System.out.println();

        System.out.println("================== Find Min price product ===================");
        Product min = products.stream()
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
        System.out.println(min);

        System.out.println();

        System.out.println("================== Calculate payable price ===================");
        products.stream().peek(e->e.setPayPrice(e.getPrice()-e.getOffer()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("================== Count total product ===================");
        long totalProduct = products.stream().count();
        System.out.println(totalProduct);

        System.out.println();

        System.out.println("================== Sum of all product payable price ===================");
        double totalPrice = products.stream().mapToDouble(e->e.getPrice()-e.getOffer()).sum();
        System.out.println(totalPrice);

        System.out.println();

        System.out.println("================== Group by category ===================");
        Map<String, List<Product>> groupByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(groupByCategory);

        System.out.println();

        System.out.println("============= Group by category with group total price ================");
        List<GroupAmount> groupAmountList = new ArrayList<>();
        products.stream().collect(Collectors.groupingBy(Product::getCategory))
                .forEach((k,v)->{
                    double groupPrice = v.stream().mapToDouble(e->e.getPrice()-e.getOffer()).sum();
                    groupAmountList.add(new GroupAmount(k,groupPrice,v));
                });
        System.out.println(groupAmountList);
    }
}
