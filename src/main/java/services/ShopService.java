package services;

import entities.Product;

import java.util.Calendar;
import java.util.Date;

public class ShopService {

    private ProductService storage;
    private Date currentDate;

    public ShopService() {
    }

    public ShopService(ProductService storage) {
        this.storage = storage;
        Calendar calendar = Calendar.getInstance();
        this.currentDate = calendar.getTime();
    }


    public Product getProductFromStorage(Long prodId){
        return storage.getProductFromStorage(prodId);
    }

    public void filterExpiredProducts(){
        storage.getProductList().removeIf(p -> p.getExpireDate().after(this.currentDate));
    }
}
