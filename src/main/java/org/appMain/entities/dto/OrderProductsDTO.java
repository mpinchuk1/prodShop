package org.appMain.entities.dto;



import org.appMain.entities.OrderProduct;

import java.util.List;

public class OrderProductsDTO {
    private List<OrderProduct> orderProducts;

    public OrderProductsDTO() {
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
