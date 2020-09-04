package entities;

import java.util.ArrayList;

public class Courier {

    private Long id;
    private String lastName;
    private String supplierCompanyName;
    private ArrayList<Product> deliveryProducts;

    public Courier() {
    }

    public Courier(Long id, String lastName, String supplierCompanyName, ArrayList<Product> deliveryProducts) {
        this.id = id;
        this.lastName = lastName;
        this.supplierCompanyName = supplierCompanyName;
        this.deliveryProducts = deliveryProducts;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public ArrayList<Product> getDeliveryProducts() {
        return deliveryProducts;
    }


    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", supplierCompanyName='" + supplierCompanyName + '\'' +
                ", deliveryProducts=" + deliveryProducts +
                '}';
    }
}
