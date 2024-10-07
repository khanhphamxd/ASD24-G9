package advanced.software.dev;

public class CartController {

    private Cart cart;

    // Constructor to create a new CartController with a new Cart
    public CartController() {
        this.cart = new Cart();
    }

    // Add product to cart
    public void addToCart(Product product, int amount) {
        cart.addToCart(product, amount);
    }

    // Remove product from cart
    public void removeFromCart(Product product, int amount) {
        cart.removeFromCart(product, amount);
    }

    // View cart
    public void viewCart() {
        cart.viewCart();
    }
}

