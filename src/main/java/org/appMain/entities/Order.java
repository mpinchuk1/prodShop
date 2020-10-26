package org.appMain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.UUID;

public class Order {

    private UUID id;
    private Double price;
    private Seller seller;
    private UUID customerId;
    @JsonFormat(pattern = "MMM dd, yyyy")
    private Date orderDate;

    public Order() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
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
                ", price=" + price +
                ", seller=" + seller +
                ", customer=" + customerId +
                ", orderDate=" + orderDate +
                '}';
    }
}
