package org.appMain.controllers.rest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("supply")
public class CourierController {
    private static final String COURIER_URL = "http://courierservice:8082";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @PostMapping
    public ResponseEntity<Void> deliverProducts(@RequestBody String deliverJson) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> products = new HttpEntity<>(deliverJson, headers);
        ResponseEntity<Void> response = restTemplate
                .exchange(COURIER_URL + "/supply",
                        HttpMethod.POST, products, Void.class);

        if (response.getStatusCodeValue() == 200)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }
}
