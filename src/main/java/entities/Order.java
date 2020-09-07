package entities;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class Order {

    private final Long id;
    private final ArrayList<Product> productsInOrder;
    private final Double price;
    private final Seller seller;
    private final Customer customer;
    private final Date orderDate;
    private final Calendar c = Calendar.getInstance();

    public Order(Long id, Product productsInOrder, Seller seller, Customer customer) {
        this.id = id;
        this.productsInOrder = new ArrayList<>();
        this.productsInOrder.add(productsInOrder);
        this.seller = seller;
        this.customer = customer;
        this.price = productsInOrder.getPrice();
        this.orderDate = c.getTime();
    }

    public double countPrice(ArrayList<Product> products){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public Long getId() {
        return id;
    }

    public ArrayList<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public Double getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + productsInOrder +
                ", price=" + price +
                ", seller=" + seller +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", c=" + c +
                '}';
    }
}
