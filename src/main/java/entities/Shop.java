package entities;

public final class Shop {

    private final String name;
    private final Seller seller;

    public Shop(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
        System.out.println("Shop " + name + " is open. \n" + "The seller today is " + seller.getFirstName() + " " + seller.getLastName());
    }

}
