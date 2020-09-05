package entities;

import java.util.Date;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private Date deliveryDate;
    private Date expireDate;
    private Boolean forAdult;

    public Product() {
    }

    public Product(Long id, String name, Double price, Date expireDate, Boolean forAdult) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.deliveryDate = new Date();
        this.expireDate = expireDate;
        this.forAdult = forAdult;
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

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean getForAdult() {
        return forAdult;
    }

    public void setForAdult(Boolean forAdult) {
        this.forAdult = forAdult;
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
