package org.appMain.entities;

import java.util.Date;
import java.util.UUID;


public class Customer {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date registrationDate;

    public Customer() {

    }

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.registrationDate = new Date();
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
