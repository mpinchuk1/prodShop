package repo;

import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Seller;

import java.util.Optional;

public class SellerService {

    private ProductService storage;

    public SellerService() {
    }

    public SellerService(ProductService storage) {
        this.storage = storage;
    }


    public Product getProductFromStorage(Long prodId){
        return storage.getProductFromStorage(prodId);
    }
}
