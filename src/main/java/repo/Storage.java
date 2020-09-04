package repo;

import entities.Product;
import entities.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Storage {

    private ArrayList<Product> productList;

    public Storage() {
    }

    public Storage(ArrayList<Product> productList) {
        this.productList = productList;
    }



    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "productList=" + productList +
                '}';
    }
}
