package org.appMain.controllers;

import org.appMain.entities.Product;
import org.appMain.entities.dto.ProductsDTO;
import org.appMain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/getAllProducts")
    public @ResponseBody ProductsDTO getAllProducts(){
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProducts(productService.getAllProduct());
        return productsDTO;
    }
}
