package services;

import entities.Customer;
import entities.Order;
import entities.Seller;

import java.util.ArrayList;

public class OrderService {

    private ProductService productService;
    private ArrayList<Order> orders;

    public OrderService(ProductService productService, ArrayList<Order> orders) {
        this.productService = productService;
        this.orders = orders;
    }

    public void addOrder(Seller seller, Customer customer, Long productId){
        orders.add(new Order(productService.getProductFromStorage(productId), seller, customer));
    }

    public Order getOrderById(Long id){
        return orders.stream().filter(o -> o.getId().equals(id))
                .findFirst().orElse(new Order());
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
