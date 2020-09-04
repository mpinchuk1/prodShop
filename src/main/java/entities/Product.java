package entities;

import java.util.Date;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private Date deliveryDate;

    public Product() {
    }

    public Product(Long id, String name, Double price, Date deliveryDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
