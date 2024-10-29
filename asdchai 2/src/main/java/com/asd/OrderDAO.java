package com.asd;

public class OrderDAO {
    Order[] orders = new Order[16];
    public OrderDAO() {
    orders[0] = new Order(101, "\n Butter 250g\n Carrot 1kg\n Jasmine Rice", "Shipped","12 Desember");
    orders[1] = new Order(102, "\n Mineral Water 24", "Processing", "25 September");
    orders[2] = new Order(103, "\n Doritos Chips\n Hummus Dips\n Coke1L", "Delivered", "5 Febuary");
    orders[3] = new Order(104, "\n Apples 2kg\n Bananas 1kg\n Oranges 1kg", "Shipped", "18 October");
    orders[4] = new Order(105, "\n Whole Wheat Bread\n Peanut Butter 500g", "Processing", "20 September");
    orders[5] = new Order(106, "\n Chicken Breast 1kg\n Ground Beef 500g\n Salmon Fillet 300g", "Delivered", "10 February");
    orders[6] = new Order(107, "\n Milk 1L\n Eggs 12 pack\n Butter 500g", "Shipped", "7 October");
    orders[7] = new Order(108, "\n Pasta 500g\n Tomato Sauce 2 jars\n Parmesan Cheese", "Processing", "2 September");
    orders[8] = new Order(109, "\n Cereal 500g\n Almond Milk 1L\n Honey", "Delivered", "12 December");
    orders[9] = new Order(110, "\n Shampoo\n Soap 2 bars\n Toothpaste", "Shipped", "30 November");
    orders[10] = new Order(111, "\n Frozen Pizza\n Ice Cream 1L\n Garlic Bread", "Delivered", "15 January");
    orders[11] = new Order(112, "\n Rice 2kg\n Lentils 1kg\n Olive Oil 500ml", "Processing", "28 October");
    orders[12] = new Order(113, "\n Coffee Beans 250g\n Green Tea 20 bags\n Sugar 1kg", "Shipped", "5 November");
    orders[13] = new Order(114, "\n Tissues 4 pack\n Toilet Paper 6 pack", "Delivered", "20 August");
    orders[14] = new Order(115, "\n Dish Soap\n Sponge 2 pack\n Garbage Bags", "Shipped", "25 September");
    orders[15] = new Order(116, "\n Orange Juice 1L\n Bagels 6 pack\n Cream Cheese", "Processing", "10 October");
    }
    public int getOrderId(int num) {
        return orders[num].getOrderId();
    }

    public String getOrderDetails(int num) {
        return orders[num].getOrderDetails();
    }

    public String getOrderStatus(int num) {
        return  orders[num].getOrderStatus();
    }
    public String getOrderDate(int num) {
        return orders[num].getOrderDate();
    }
}
