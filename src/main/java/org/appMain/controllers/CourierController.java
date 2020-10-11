package org.appMain.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("supply")
public class CourierController {
    private static final String COURIER_URL = "http://localhost:8082";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @PostMapping
    public ResponseEntity<Void> deliverProducts(@RequestBody String deliverJson) {
        HttpEntity<String> products = new HttpEntity<>(deliverJson);
        ResponseEntity<Void> response = restTemplate
                .exchange(COURIER_URL + "/supply",
                        HttpMethod.POST, products, Void.class);

        if (response.getStatusCodeValue() == 200)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }
}
