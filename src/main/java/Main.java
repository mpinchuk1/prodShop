import entities.*;
import services.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product(1L, "water", (double) 20, new Date(2133333423423L), false);
        Product p2 = new Product(2L, "apple", (double) 12, new Date(213333), false);
        Product p3 = new Product(3L, "orange", (double) 34, new Date(2133333423423L), false);
        Product p4 = new Product(4L, "cookie", (double) 54, new Date(3333312423423L), false);
        Product p5 = new Product(5L, "pill", (double) 212, new Date(2123333423423L), false);
        Product p6 = new Product(6L, "bread", (double) 2, new Date(3121333333333L), false);
        Product p7 = new Product(7L, "cola", (double) 1111, new Date(1133333333213L), false);
        Product p8 = new Product(8L, "bear", (double) 11123121, new Date(1133333333213L), true);
        Product p9 = new Product(9L, "vodka", (double) 1, new Date(3133333333213L), true);

        ArrayList<Product> deliveryProducts = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
        Courier courier1 = new Courier(11234L, "Petrov", "Co company", deliveryProducts);

        Seller seller1 = new Seller(132L, "Kolya", "Frolov");
        Shop shop = new Shop("MyShop", seller1);

        ProductService productService = new ProductService();
        ShopService shopService = new ShopService(productService);
        CourierService courierService = new CourierService(productService);
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService(productService, customerService);
        courierService.addProductToStorage(courier1);
        System.out.println(productService);

        shopService.filterExpiredProducts();

        ArrayList<Product> products = productService.getProductList();
        System.out.println(products);
        Customer customer1 = new Customer(123L, "Anton", "Vitas", 20);
        customer1.addProductToBucket(products.get(0));
        customer1.addProductToBucket(products.get(1));
        Customer customer2 = new Customer(56L, "Bad", "Guy", 17);
        customer2.addProductToBucket(products.get(3));
        customer2.addProductToBucket(products.get(5));
        orderService.addOrder(seller1, customer1);
        orderService.addOrder(seller1, customer2);
        System.out.println(productService);
        System.out.println(customerService);
        System.out.println(orderService);
    }
}
