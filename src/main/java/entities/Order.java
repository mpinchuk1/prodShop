package entities;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {

    private Long id;
    private ArrayList<Product> productsInOrder;
    private Double price;
    private Seller seller;
    private Customer customer;
    private Date orderDate;
    private Calendar c = Calendar.getInstance();

    public Order() {
    }

    public Order(Long id, ArrayList<Product> productsInOrder, Seller seller, Customer customer) {
        this.id = id;
        this.productsInOrder = productsInOrder;
        this.seller = seller;
        this.customer = customer;
        this.orderDate = c.getTime();
        this.price = countPrice(productsInOrder);
    }

    public Order(Product productsInOrder, Seller seller, Customer customer) {
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

    public void addToOrder(Product product){
        productsInOrder.add(product);
    }

    public void deleteProdFromOrder(Long id){
        productsInOrder.removeIf(p -> p.getId().equals(id));
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

    public ArrayList<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public void setProductsInOrder(ArrayList<Product> productsInOrder) {
        this.productsInOrder = productsInOrder;
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
                ", product=" + productsInOrder +
                ", price=" + price +
                ", seller=" + seller +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", c=" + c +
                '}';
    }
}
