package repo;

import entities.Product;
import entities.Supplier;

import java.util.ArrayList;

public class SupplierService {

    private ProductService storage;

    public SupplierService() {
    }

    public SupplierService(ProductService storage) {
        this.storage = storage;
    }

    public void addProductToStorage(Supplier supplier){
        ArrayList<Product> toStorage = supplier.getDeliveryProducts();
        toStorage.forEach(p -> storage.addProduct(p));

    }

}
