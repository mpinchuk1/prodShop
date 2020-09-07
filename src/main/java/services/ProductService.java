package services;

import entities.Product;

import java.util.ArrayList;
import java.util.Optional;

public final class ProductService {

    private final ArrayList<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n___________________________________________");
        stringBuilder.append("\nProducts: ");
        for(Product p: productList){
            stringBuilder.append("\nid: ").append(p.getId()).append("\t name: ")
                    .append(p.getName()).append("\n price: ").append(p.getPrice())
                    .append("\t expireDate: ").append(p.getExpireDate())
                    .append("\t forAdult: ").append(p.getForAdult());
        }
        stringBuilder.append("\n___________________________________________");

        return stringBuilder.toString();
    }
}
