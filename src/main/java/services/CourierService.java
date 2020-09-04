package services;

import entities.Product;
import entities.Courier;

import java.util.ArrayList;

public class CourierService {

    private ProductService storage;
    private ArrayList<Courier> couriers;

    public CourierService() {
    }

    public CourierService(ProductService storage, ArrayList<Courier> couriers) {
        this.storage = storage;
        this.couriers = couriers;
    }

    public void addProductToStorage(Courier courier){
        ArrayList<Product> toStorage = courier.getDeliveryProducts();
        toStorage.forEach(p -> storage.addProduct(p));
    }

    public void addCourier(Courier courier){
        couriers.add(courier);
    }

    public void deleteCourier(Long id){
        couriers.removeIf(c -> c.getId().equals(id));
    }

}
