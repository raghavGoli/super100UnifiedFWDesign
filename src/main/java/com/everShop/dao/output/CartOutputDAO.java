package com.everShop.dao.output;

import com.everShop.dao.output.components.OrderSummaryDAO;
import com.everShop.dao.output.components.ProductDAO;

import java.util.List;

public class CartOutputDAO {


   private List<ProductDAO> products;

   private OrderSummaryDAO orderSummaryDAO;

    public OrderSummaryDAO getOrderSummaryDAO() {
        return orderSummaryDAO;
    }

    public void setOrderSummaryDAO(OrderSummaryDAO orderSummaryDAO) {
        this.orderSummaryDAO = orderSummaryDAO;
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
                ", orderSummaryDAO=" + orderSummaryDAO +
                '}';
    }
}
