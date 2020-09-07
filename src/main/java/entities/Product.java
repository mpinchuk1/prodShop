package entities;

import java.util.Date;

public final class Product {

    private final Long id;
    private final String name;
    private final Double price;
    private Date deliveryDate;
    private final Date expireDate;
    private final Boolean forAdult;

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

    public Double getPrice() {
        return price;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Boolean getForAdult() {
        return forAdult;
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
