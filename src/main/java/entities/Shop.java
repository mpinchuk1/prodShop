package entities;

public class Shop {

    private String name;
    private Seller seller;

    public Shop() {
    }

    public Shop(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
        System.out.println("Shop " + name + " is open. \n" + "The seller today is " + seller.getFirstName() + " " + seller.getLastName());
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
