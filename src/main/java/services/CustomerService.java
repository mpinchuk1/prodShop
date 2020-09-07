package services;

import entities.Customer;
import entities.Product;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class CustomerService {

    private final ArrayList<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        customer.setRegistrationDate(currentDate);
        customers.add(customer);
    }

    public void clearCustomerBucket(Customer customer) {
        customer.getProductBucket().clear();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n___________________________________________");
        stringBuilder.append("\nCustomers: ");
        for(Customer c: customers){
            stringBuilder.append("\nid: ").append(c.getId()).append("\t firstName: ")
                    .append(c.getFirstName()).append("\n lastName: ").append(c.getLastName())
                    .append("\t age: ").append(c.getAge()).append("\t regDate: ")
                    .append(c.getRegistrationDate());
        }
        stringBuilder.append("\n___________________________________________");

        return stringBuilder.toString();
    }
}
