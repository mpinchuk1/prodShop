package entities;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private Long id;
    private String lastName;
    private String agencyName;
    private ArrayList<Product> deliveryProducts;

    public Supplier() {
    }

    public Supplier(Long id, String lastName, String agencyName, ArrayList<Product> deliveryProducts) {
        this.id = id;
        this.lastName = lastName;
        this.agencyName = agencyName;
        this.deliveryProducts = deliveryProducts;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public ArrayList<Product> getDeliveryProducts() {
        return deliveryProducts;
    }


    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", deliveryProducts=" + deliveryProducts +
                '}';
    }
}
