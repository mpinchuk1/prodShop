package org.appMain.controllers;

import org.appMain.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/filterExpiredProducts")
    public ResponseEntity<Void> filterExpiredProducts(){
        shopService.filterExpiredProducts();
        return ResponseEntity.ok().build();
    }

}
