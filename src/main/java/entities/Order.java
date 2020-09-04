package entities;


import java.util.Calendar;
import java.util.Date;

public class Order {

    private Long id;
    private Product product;
    private Double price;
    private Seller seller;
    private Customer customer;
    private Date orderDate;
    private Calendar c = Calendar.getInstance();

    public Order() {
    }

    public Order(Long id, Product product, Seller seller, Customer customer) {
        this.id = id;
        this.product = product;
        this.seller = seller;
        this.customer = customer;
        this.orderDate = c.getTime();
        this.price = product.getPrice();
    }

    public Order(Product product, Seller seller, Customer customer) {
        this.product = product;
        this.seller = seller;
        this.customer = customer;
        this.price = product.getPrice();
        this.orderDate = c.getTime();
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", seller=" + seller +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                '}';
    }
}
