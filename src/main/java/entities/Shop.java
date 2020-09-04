package entities;

import repo.Storage;

public class Shop {

    private Seller seller;
    private Storage storage;
    private String name;

    public Shop() {
    }

    public Shop(Seller seller, Storage storage, String name) {
        this.seller = seller;
        this.storage = storage;
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Storage getStorage() {
        return storage;
    }

    public String getName() {
        return name;
    }

}
