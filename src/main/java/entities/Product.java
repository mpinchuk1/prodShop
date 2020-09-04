package entities;

import java.util.Date;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private Date deliveryDate;
    private Date expireDate;

    public Product() {
    }

    public Product(Long id, String name, Double price, Date deliveryDate, Date expireDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.expireDate = expireDate;
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

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", expireDate=" + expireDate +
                '}';
    }
}
