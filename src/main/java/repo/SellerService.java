package repo;

import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Seller;

import java.util.Optional;

public class SellerService {

    private Storage storage;

    public SellerService() {
    }

    public SellerService(Storage storage) {
        this.storage = storage;
    }

    public Order makeOrder(Seller seller, Customer customer, Long productId){
        return new Order(getProductFromStorage(productId), seller, customer);
    }

    public Product getProductFromStorage(Long prodId){
        Optional<Product> product = storage.getProductList().stream().filter(p -> p.getId().longValue() == prodId)
                .findFirst();
        product.ifPresent(value -> storage.getProductList().remove(value));

        return product.orElse(new Product());
    }
}
