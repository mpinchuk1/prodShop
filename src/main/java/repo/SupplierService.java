package repo;

import entities.Product;
import entities.Supplier;

import java.util.ArrayList;

public class SupplierService {

    private Storage storage;

    public SupplierService() {
    }

    public SupplierService(Storage storage) {
        this.storage = storage;
    }

    public void addProductToStorage(Supplier supplier){
        ArrayList<Product> toStorage = supplier.getDeliveryProducts();
        storage.getProductList().addAll(toStorage);

    }

}
