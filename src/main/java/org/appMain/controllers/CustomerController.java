package org.appMain.controllers;

import org.appMain.entities.dto.CustomersDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private static final String CUSTOMERS_URL = "http://localhost:8083";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @GetMapping
    public @ResponseBody
    CustomersDTO getAllCustomers() {
        ResponseEntity<CustomersDTO> response = restTemplate
                .exchange(CUSTOMERS_URL + "/customers",
                        HttpMethod.GET, headersEntity, CustomersDTO.class);
        return response.getBody();
    }
}
