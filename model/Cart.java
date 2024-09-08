package model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    // ID tracker for Cart
    private static int cartIDTracker = 1;

    // Fields
    private int cartID;
    private List<Product> itemList;
    private List<Integer> itemAmountList;
    private double totalPrice;

    // Constructor for creating a new cart
    public Cart() {
        this.cartID = cartIDTracker;
        cartIDTracker++; // Increment the cart ID for the next cart
        this.itemList = new ArrayList<>();
        this.itemAmountList = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // Getters
    public int getCartID() {
        return cartID;
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public List<Integer> getItemAmountList() {
        return itemAmountList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Method to add product to the cart
    public void addToCart(Product product, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Amount must be greater than zero.");
            return;
        }

        // Check if the product is already in the cart
        int index = itemList.indexOf(product);
        if (index >= 0) {
            // If the product is already in the cart, update the quantity
            itemAmountList.set(index, itemAmountList.get(index) + amount);
        } else {
            // If the product is not in the cart, add it
            itemList.add(product);
            itemAmountList.add(amount);
        }

        // Update the total price
        totalPrice += product.getProductPrice() * amount;
    }

    // Method to remove product from the cart
    public void removeFromCart(Product product, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Amount must be greater than zero.");
            return;
        }

        int index = itemList.indexOf(product);
        if (index >= 0) {
            int currentAmount = itemAmountList.get(index);
            if (amount >= currentAmount) {
                // Remove the product entirely if the amount to remove is greater than or equal to the current amount
                totalPrice -= product.getProductPrice() * currentAmount;
                itemList.remove(index);
                itemAmountList.remove(index);
            } else {
                // Otherwise, just reduce the quantity
                itemAmountList.set(index, currentAmount - amount);
                totalPrice -= product.getProductPrice() * amount;
            }
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    // Method to view the cart contents
    public void viewCart() {
        System.out.println("Cart ID: " + cartID);
        if (itemList.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Cart contents:");
            for (int i = 0; i < itemList.size(); i++) {
                Product product = itemList.get(i);
                int amount = itemAmountList.get(i);
                System.out.println("Product: " + product.getProductName() + ", Quantity: " + amount + ", Price: " + product.getProductPrice() * amount);
            }
        }
        System.out.println("Total Price: " + totalPrice);
    }
}

