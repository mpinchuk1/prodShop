package entities;

public class Shop {

    private String name;
    private Seller seller;

    public Shop() {
    }

    public Shop(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
