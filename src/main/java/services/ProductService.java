package services;

import entities.Product;

import java.util.ArrayList;
import java.util.Optional;

public class ProductService {

    private ArrayList<Product> productList;

    public ProductService() {
    }

    public ProductService(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Product getProductFromStorage(Long prodId){
        Optional<Product> product = productList.stream().filter(p -> p.getId().longValue() == prodId)
                .findFirst();
        product.ifPresent(value -> productList.remove(value));

        return product.orElse(new Product());
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "productList=" + productList +
                '}';
    }
}
