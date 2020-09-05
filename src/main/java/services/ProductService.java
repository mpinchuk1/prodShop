package services;

import entities.Product;

import java.util.ArrayList;
import java.util.Optional;

public class ProductService {

    private ArrayList<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
    }

    public ProductService(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Product getProductFromStorage(Long prodId){
        Optional<Product> product = productList.stream().filter(p -> p.getId().longValue() == prodId)
                .findFirst();
        return product.orElse(new Product());
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void deleteProduct(Product product){
        productList.remove(product);
    }

    public void showAvailableProducts(){
        System.out.println("___________________________________________");
        System.out.println("Products: ");
        for(Product p: productList){
            System.out.println("id: " + p.getId() + "\t name: " + p.getName()
                    + "\n price: " + p.getPrice() + "\t expireDate: " + p.getExpireDate() + "\t forAdult: " + p.getForAdult());
        }
        System.out.println("___________________________________________");
    }
}
