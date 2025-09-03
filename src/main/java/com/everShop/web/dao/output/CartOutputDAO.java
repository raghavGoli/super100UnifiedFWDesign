package com.everShop.web.dao.output;

import com.everShop.web.dao.output.components.OrderSummaryDAO;
import com.everShop.web.dao.output.components.ProductDAO;

import java.util.List;

public class CartOutputDAO {


   private List<ProductDAO> products;

   private OrderSummaryDAO orderSummary;

    public OrderSummaryDAO getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(OrderSummaryDAO orderSummary) {
        this.orderSummary = orderSummary;
    }

    public List<ProductDAO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDAO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CartOutputDAO{" +
                "products=" + products +
                ", orderSummary=" + orderSummary +
                '}';
    }
}
