package org.appMain.controllers;

import org.appMain.entities.Customer;
import org.appMain.entities.Product;
import org.appMain.entities.Seller;
import org.appMain.entities.dto.CreateOrderDTO;
import org.appMain.entities.dto.CustomersDTO;
import org.appMain.entities.dto.OrdersDTO;
import org.appMain.services.CustomerService;
import org.appMain.services.OrderService;
import org.appMain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDTO createOrder){
        Seller seller = createOrder.getSeller();
        Customer customer = createOrder.getCustomer();
        List<Product> products = createOrder.getProducts();
        orderService.addOrder(seller, products, customer);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/getAllOrders")
    public @ResponseBody OrdersDTO getAllOrders(){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setOrders(orderService.getAllOrders());
        return ordersDTO;
    }
}
