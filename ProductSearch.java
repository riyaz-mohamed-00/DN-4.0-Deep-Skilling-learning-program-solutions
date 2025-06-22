import java.util.*;

// Step 1: Define the Product class
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

// Step 2: Define search algorithms
public class ProductSearch {

    // Linear Search - No need to sort
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search - Requires sorted array by productName
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(name);

            if (comparison == 0) {
                return products[mid]; // Found
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return null; // Not found
    }

    // Step 3: Main method to test
    public static void main(String[] args) {
        // Create some products
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Shampoo", "Personal Care"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Watch", "Accessories")
        };

        // ----------- Linear Search Test --------------
        String targetName1 = "Phone";
        Product result1 = linearSearch(products, targetName1);

        System.out.println("Linear Search Result:");
        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product not found.");

        // ----------- Binary Search Test --------------
        // Sort products by productName before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        String targetName2 = "Shampoo";
        Product result2 = binarySearch(products, targetName2);

        System.out.println("\nBinary Search Result:");
        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product not found.");
    }
}

