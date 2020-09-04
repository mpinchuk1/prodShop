package services;

import entities.Customer;

import java.util.ArrayList;

public class CustomerService {

    private ArrayList<Customer> customers;

    public CustomerService() {
    }

    public CustomerService(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer getCustomerById(Long customerId){
        return customers.stream().filter(c -> c.getId().equals(customerId))
                .findFirst().orElse(new Customer());
    }
}
