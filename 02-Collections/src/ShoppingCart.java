import java.lang.*;
import java.util.*;
public class ShoppingCart {
    private final Map<String, Double> priceMap = new HashMap<>();
    private final LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    public void addProduct(String product, double price) {
        priceMap.putIfAbsent(product, price);
    }
    public void addToCart(String product, int quantity) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found in catalog: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }
    public void displayCartOrder() {
        System.out.println("\nCart (Order of Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue() + " = ₹" + (priceMap.get(entry.getKey()) * entry.getValue()));
        }
    }
    public void displayCartSortedByPrice() {
        System.out.println("\nCart Sorted by Price:");
        TreeMap<Double, List<String>> sortedMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = priceMap.get(product);
            sortedMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }
        for (Map.Entry<Double, List<String>> entry : sortedMap.entrySet()) {
            for (String product : entry.getValue()) {
                int qty = cart.get(product);
                System.out.println(product + " x " + qty + " = ₹" + (entry.getKey() * qty));
            }
        }
    }
    public void displayTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += priceMap.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("\nTotal Bill: ₹" + total);
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Milk", 40);
        cart.addProduct("Bread", 30);
        cart.addProduct("Eggs", 5);
        cart.addProduct("Butter", 50);
        cart.addToCart("Bread", 2);
        cart.addToCart("Milk", 1);
        cart.addToCart("Eggs", 12);
        cart.addToCart("Butter", 1);
        cart.displayCartOrder();
        cart.displayCartSortedByPrice();
        cart.displayTotal();
    }
}

