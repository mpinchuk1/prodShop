package org.appMain.controllers.rest;

import org.appMain.entities.Customer;
import org.appMain.entities.dto.CustomersDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private static final String CUSTOMERS_URL = "http://customerservice:8083";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);


    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${customer.routing-key}")
    private String routingKey;

    @Autowired
    public CustomerController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public @ResponseBody
    CustomersDTO getAllCustomers() {
        ResponseEntity<CustomersDTO> response = restTemplate
                .exchange(CUSTOMERS_URL + "/customers",
                        HttpMethod.GET, headersEntity, CustomersDTO.class);
        return response.getBody();
    }

    @PostMapping("mq")
    public ResponseEntity<Void> addCustomerMq(@RequestBody Customer customer) {
        rabbitTemplate.convertAndSend(exchange, routingKey, customer);
        return ResponseEntity.ok().build();
    }
}
