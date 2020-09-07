package entities;

import java.util.ArrayList;
import java.util.Date;

public final class Customer {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private Date registrationDate;
    private final ArrayList<Product> productBucket;

    public Customer(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.registrationDate = new Date();
        this.productBucket = new ArrayList<>();
    }

    public void addProductToBucket(Product product){
        productBucket.add(product);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Product> getProductBucket() {
        return productBucket;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate){
        this.registrationDate = registrationDate;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                ", productBucket=" + productBucket +
                '}';
    }
}
