package entities;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {

    private Long id;
    private ArrayList<Product> product;
    private Double price;
    private Seller seller;
    private Customer customer;
    private Date orderDate;
    private Calendar c = Calendar.getInstance();

    public Order() {
    }

    public Order(Long id, ArrayList<Product> products, Seller seller, Customer customer) {
        this.id = id;
        this.product = products;
        this.seller = seller;
        this.customer = customer;
        this.orderDate = c.getTime();
        this.price = countPrice(products);
    }

    public Order(Product product, Seller seller, Customer customer) {
        this.product = new ArrayList<>();
        this.product.add(product);
        this.seller = seller;
        this.customer = customer;
        this.price = product.getPrice();
        this.orderDate = c.getTime();
    }

    public double countPrice(ArrayList<Product> products){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> products) {
        this.product = products;
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
                ", price=" + price +
                ", seller=" + seller +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", c=" + c +
                '}';
    }
}
