package org.appMain.controllers;

import org.appMain.entities.Customer;
import org.appMain.entities.dto.CreateOrderDTO;
import org.appMain.entities.dto.OrderProductsDTO;
import org.appMain.entities.dto.OrdersDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@RestController
@RequestMapping("orders")
public class OrderController {
    private static final String ORDERS_URL = "http://orderservice:8084";
    private static final String CUSTOMERS_URL = "http://customerservice:8083";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDTO createOrder) {
        createOrder.getCustomer().setCustomerId(UUID.randomUUID());

        HttpEntity<CreateOrderDTO> createOrderDTOHttpEntity = new HttpEntity<>(createOrder);
        ResponseEntity<Void> response = restTemplate
                .exchange(ORDERS_URL + "/orders",
                        HttpMethod.POST, createOrderDTOHttpEntity, Void.class);

        if (response.getStatusCodeValue() == 200) {
            saveCustomer(createOrder.getCustomer());
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().build();
    }

    private void saveCustomer(Customer customer) {
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer);
        ResponseEntity<Void> response = restTemplate
                .exchange(CUSTOMERS_URL + "/customers",
                        HttpMethod.POST, customerHttpEntity, Void.class);
    }

    @GetMapping
    public @ResponseBody
    OrdersDTO getAllOrders() {
        ResponseEntity<OrdersDTO> response = restTemplate
                .exchange(ORDERS_URL + "/orders",
                        HttpMethod.GET, headersEntity, OrdersDTO.class);
        return response.getBody();
    }

    @GetMapping("/orderProducts")
    public @ResponseBody
    OrderProductsDTO getAllOrderProducts() {
        ResponseEntity<OrderProductsDTO> response = restTemplate
                .exchange(ORDERS_URL + "/orders/orderProducts",
                        HttpMethod.GET, headersEntity, OrderProductsDTO.class);
        return response.getBody();
    }
}
