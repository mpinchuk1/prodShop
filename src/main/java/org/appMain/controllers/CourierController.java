package org.appMain.controllers;

import com.google.gson.GsonBuilder;
import org.appMain.entities.Courier;
import org.appMain.entities.Product;
import org.appMain.entities.dto.DeliveryDTO;
import org.appMain.services.CourierService;
import org.appMain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class CourierController {
    private final CourierService courierService;
    private final ProductService productService;

    @Autowired
    public CourierController(CourierService courierService, ProductService productService) {
        this.courierService = courierService;
        this.productService = productService;
    }

    @RequestMapping(value = "/deliverProducts", method = RequestMethod.POST)
    public ResponseEntity<Void> getProductsFromCourier(@RequestBody String deliverJson){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        DeliveryDTO deliver = gson.fromJson(deliverJson, DeliveryDTO.class);
        List<Product> toStorage = deliver.getProducts();
        List<Integer> prodQuantities = deliver.getProductQuantities();
        Courier courier = deliver.getCourier();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        System.out.println(courier);
        courierService.addCourier(courier);
        for(Product p: toStorage){
            p.setDeliveryDate(currentDate);
            p.setDeliveredBy(courier);
            productService.addProduct(p);
        }
        courierService.addProductsToStorage(courier, toStorage, prodQuantities);

        return ResponseEntity.ok().build();
    }
}