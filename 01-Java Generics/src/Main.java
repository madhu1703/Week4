import java.util.*;
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Item: " + name + ", Price: $" + price;
    }
}
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}
class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}
class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items;
    public Storage() {
        items = new ArrayList<>();
    }
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
class WarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone", 999.99));
        electronicsStorage.addItem(new Electronics("Laptop", 1499.99));
        groceriesStorage.addItem(new Groceries("Apple", 2.99));
        groceriesStorage.addItem(new Groceries("Bread", 1.49));
        furnitureStorage.addItem(new Furniture("Sofa", 499.99));
        furnitureStorage.addItem(new Furniture("Dining Table", 799.99));
        System.out.println("Electronics in storage:");
        electronicsStorage.displayItems();
        System.out.println("\nGroceries in storage:");
        groceriesStorage.displayItems();
        System.out.println("\nFurniture in storage:");
        furnitureStorage.displayItems();
    }
}
