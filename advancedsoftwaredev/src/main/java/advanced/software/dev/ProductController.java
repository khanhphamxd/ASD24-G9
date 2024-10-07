  public class ProductController {

        private ProductDAO productDAO;  // Assume there's a ProductDAO for database operations

        // Constructor initializing the DAO
        public ProductController(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        // Method to list all products (retrieve from database)
        public List<Product> listProduct() {
            return productDAO.getAllProducts();
        }

        // Method to view a single product based on its ID
        public Product viewProduct(int productID) {
            return productDAO.getProductByID(productID);
        }

        // Method to search for a product by name
        public Product searchProduct(String productName) {
            return productDAO.getProductByName(productName);
        }

        // You can also add other methods like adding, updating, or deleting products
    }

}


