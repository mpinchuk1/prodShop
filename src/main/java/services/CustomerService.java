package services;

import entities.Customer;
import entities.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CustomerService {

    private ArrayList<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public CustomerService(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        customer.setRegistrationDate(currentDate);
        customers.add(customer);
    }

    public void showAllCustomers(){
        System.out.println("___________________________________________");
        System.out.println("Customers: ");
        for(Customer c: customers){
            System.out.println("id: " + c.getId() + "\t firstName: " + c.getFirstName() + "\n lastName: " + c.getLastName()
                    + "\t age: " + c.getAge() + "\t regDate: " + c.getRegistrationDate());
        }
        System.out.println("___________________________________________");
    }

    public void clearCustomerBucket(Customer customer) {
        customer.getProductBucket().clear();
    }
}
