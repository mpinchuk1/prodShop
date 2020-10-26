package org.appMain.controllers;

import org.appMain.entities.dto.ProductsDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("products")
public class ProductsController {
    private static final String PRODUCTS_URL = "http://courierservice:8082";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    @GetMapping
    public @ResponseBody
    ProductsDTO getAllProducts() {
        ResponseEntity<ProductsDTO> response = restTemplate
                .exchange(PRODUCTS_URL + "/products",
                        HttpMethod.GET, headersEntity, ProductsDTO.class);
        return response.getBody();
    }

    @GetMapping("/filter={filter}")
    public ResponseEntity<Void> filterExpiredProducts(@PathVariable String filter){
        ResponseEntity<Void> response = null;
        if(Boolean.parseBoolean(filter))
            response = restTemplate.exchange(PRODUCTS_URL + "/products/filter=true",
                            HttpMethod.GET, headersEntity, Void.class);
        if(response != null && response.getStatusCodeValue() == 200)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }
}
