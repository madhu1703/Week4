package name;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
class Sale {
    private String productId;
    private int quantity;
    private double price;
    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
class ProductSales {
    private String productId;
    private double totalRevenue;
    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
    public String getProductId() { return productId; }
    public double getTotalRevenue() { return totalRevenue; }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Total Revenue: $" + totalRevenue;
    }
}
public class ProductSalesAnalyzer {
    public static void analyzeSales(List<Sale> sales) {
        List<Sale> filtered = sales.stream()
                .filter(sale -> sale.getQuantity() > 10)
                .collect(toList());
        Map<String, Double> revenueByProduct = filtered.stream()
                .collect(groupingBy(
                    Sale::getProductId,
                    summingDouble(sale -> sale.getQuantity() * sale.getPrice())
                ));
        List<ProductSales> productSalesList = revenueByProduct.entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed()) 
                .limit(5) 
                .collect(toList());
        System.out.println("Top 5 Products by Total Revenue:");
        productSalesList.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P1", 5, 100),
            new Sale("P2", 20, 50),
            new Sale("P3", 15, 80),
            new Sale("P4", 25, 40),
            new Sale("P5", 30, 30),
            new Sale("P6", 12, 90),
            new Sale("P7", 8, 120),
            new Sale("P8", 14, 70)
        );
        analyzeSales(sales);
    }
}
