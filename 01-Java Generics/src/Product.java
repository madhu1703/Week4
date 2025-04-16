import java.util.*;
class BookCategory {
    private String categoryName;
    public BookCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
}
class ClothingCategory {
    private String categoryName;
    public ClothingCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
}
class GadgetCategory {
    private String categoryName;
    public GadgetCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
}
class Product<T> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public T getCategory() {
        return category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        String categoryName;
        if (category instanceof BookCategory) {
            categoryName = ((BookCategory) category).getCategoryName();
        } else if (category instanceof ClothingCategory) {
            categoryName = ((ClothingCategory) category).getCategoryName();
        } else if (category instanceof GadgetCategory) {
            categoryName = ((GadgetCategory) category).getCategoryName();
        } else {
            categoryName = "Unknown";
        }
        return "Product{name='" + name + "', price=" + price + ", category=" + categoryName + "}";
    }
}
class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}
class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        BookCategory bookCat = new BookCategory("Fiction");
        ClothingCategory clothingCat = new ClothingCategory("Men");
        GadgetCategory gadgetCat = new GadgetCategory("Mobile");
        Product<BookCategory> book1 = new Product<>("The Great Gatsby", 300.0, bookCat);
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1200.0, clothingCat);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 25000.0, gadgetCat);
        catalog.addProduct(book1);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        System.out.println("Products before discount:");
        catalog.displayProducts();
        ProductCatalog.applyDiscount(book1, 10);
        ProductCatalog.applyDiscount(shirt, 20);
        ProductCatalog.applyDiscount(phone, 5);
        System.out.println("\nProducts after discount:");
        catalog.displayProducts();
    }
}
