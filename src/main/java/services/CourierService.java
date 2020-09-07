package services;

import entities.Product;
import entities.Courier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class CourierService {

    private final ProductService storage;

    public CourierService(ProductService storage) {
        this.storage = storage;
    }

    public void addProductToStorage(Courier courier){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        ArrayList<Product> toStorage = courier.getDeliveryProducts();
        toStorage.forEach(p -> {
            p.setDeliveryDate(currentDate);
            storage.addProduct(p);
        });
        System.out.println("Delivery by " + courier.getSupplierCompanyName() + ": \n" + "Courier " + courier.getLastName() + " has delivered " + toStorage);
    }

}
