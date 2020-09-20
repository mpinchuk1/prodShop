package org.appMain.controllers;

import org.appMain.entities.dto.CustomersDTO;
import org.appMain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/getAllCustomers")
    public @ResponseBody CustomersDTO getAllCustomers(){
        CustomersDTO customersDTO = new CustomersDTO();
        customersDTO.setCustomers(customerService.getAllCustomers());
        return customersDTO;
    }
}