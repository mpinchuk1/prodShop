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

    public void addToOrder(Product product){
        productsInOrder.add(product);
    }

    public void deleteProdFromOrder(Long id){
        productsInOrder.removeIf(p -> p.getId().equals(id));
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
