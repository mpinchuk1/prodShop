package repo;

import entities.Customer;
import entities.Order;
import entities.Seller;

public class OrderService {

    private ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Order makeOrder(Seller seller, Customer customer, Long productId){
        return new Order(productService.getProductFromStorage(productId), seller, customer);
    }

}
