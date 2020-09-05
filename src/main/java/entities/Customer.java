package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Date registrationDate;
    private ArrayList<Product> productBucket;

    public Customer() {
    }

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

    public void deleteProductFromBucket(Long id){
        productBucket.removeIf(p -> p.getId().longValue() == id);
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

    public void setProductBucket(ArrayList<Product> productBucket) {
        this.productBucket = productBucket;
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
