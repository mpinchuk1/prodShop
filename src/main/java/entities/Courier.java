package entities;

import java.util.ArrayList;

public final class Courier {

    private final Long id;
    private final String lastName;
    private final String supplierCompanyName;
    private final ArrayList<Product> deliveryProducts;

    public Courier(Long id, String lastName, String supplierCompanyName, ArrayList<Product> deliveryProducts) {
        this.id = id;
        this.lastName = lastName;
        this.supplierCompanyName = supplierCompanyName;
        this.deliveryProducts = deliveryProducts;
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
