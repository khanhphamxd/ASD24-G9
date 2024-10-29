package com.asd;

public class ProductDAO {
    Product[] products = new Product[20];
    public ProductDAO(){
        products[0] = new Product("Butter", 101, "250g", 4.00, "1.60$ / 100g","Butter.png");
        products[1] = new Product("Milk", 102, "1L", 1.50, "0.15$ / 100ml","Milk.png");
        products[2] = new Product("Carrots", 103, "1kg", 2.50, "0.25$ / 100g","No_Image_Available.jpg" );
        products[3] = new Product("Eggs", 104, "12 pack", 3.60, "0.30$ / egg", "eggs.jpg");
        products[4] = new Product("Rice", 105, "2kg", 5.00, "0.25$ / 100g","Rice.jpeg");
        products[5] = new Product("Olive Oil", 106, "500ml", 6.00, "1.20$ / 100ml","Olive oil.jpg");
        products[6] = new Product("Shampoo", 107, "250ml", 3.50, "1.40$ / 100ml","No_Image_Available.jpg");
        products[7] = new Product("Apples", 108, "1kg", 3.00, "0.30$ / 100g", "No_Image_Available.jpg");
        products[8] = new Product("Chicken Breast", 109, "500g", 7.00, "1.40$ / 100g","No_Image_Available.jpg");
        products[9] = new Product("Tomato", 110, "250g", 4.50, "0.60$ / 100g","tomato.jpg");
        products[10] = new Product("Pasta", 111, "500g", 2.20, "0.44$ / 100g","No_Image_Available.jpg");
        products[11] = new Product("Orange Juice", 112, "1L", 2.80, "0.28$ / 100ml","No_Image_Available.jpg");
        products[12] = new Product("Yogurt", 113, "500g", 3.00, "0.60$ / 100g","No_Image_Available.jpg");
        products[13] = new Product("Cereal", 114, "400g", 3.50, "0.88$ / 100g","No_Image_Available.jpg");
        products[14] = new Product("Toothpaste", 115, "100ml", 2.00, "2.00$ / 100ml","No_Image_Available.jpg");
        products[15] = new Product("Ground Beef", 116, "1kg", 9.00, "0.90$ / 100g","No_Image_Available.jpg");
        products[16] = new Product("Ice Cream", 117, "1L", 5.50, "0.55$ / 100ml","No_Image_Available.jpg");
        products[17] = new Product("Dish Soap", 118, "500ml", 2.20, "0.44$ / 100ml","No_Image_Available.jpg");
        products[18] = new Product("Bananas", 119, "1kg", 2.80, "0.28$ / 100g","banana.jpg");
        products[19] = new Product("Frozen Pizza", 120, "350g", 4.00, "1.14$ / 100g", "No_Image_Available.jpg");
    }
    public String getProductName(int i) {
        return products[i].getProductName();
    }

    public int getProductId(int i ) {
        return products[i].getProductId();
    }

    public String getProductQuantity(int i) {
        return products[i].getProductQuantity();
    }

    public double getProductPrice(int i ) {
        return products[i].getProductPrice();
    }

    public String getPricePer100gOr100ml(int i) {
        return products[i].getPricePer100gOr100ml();
    }
    public String getImageUrl(int i){
        return products[i].getImageUrl();
    }
}


