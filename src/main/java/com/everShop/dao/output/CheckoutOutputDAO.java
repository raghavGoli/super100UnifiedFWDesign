package com.everShop.dao.output;

import com.everShop.dao.output.components.CheckoutSummaryDAO;
import com.everShop.dao.output.components.OrderSummaryDAO;
import com.everShop.dao.output.components.ProductDAO;

import java.util.List;

public class CheckoutOutputDAO {

    private List<ProductDAO> products;

    private CheckoutSummaryDAO checkoutSummaryDAO;

    public List<ProductDAO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDAO> products) {
        this.products = products;
    }

    public CheckoutSummaryDAO getCheckoutSummaryDAO() {
        return checkoutSummaryDAO;
    }

    public void setCheckoutSummaryDAO(CheckoutSummaryDAO checkoutSummaryDAO) {
        this.checkoutSummaryDAO = checkoutSummaryDAO;
    }

    @Override
    public String toString() {
        return "CheckoutOutputDAO{" +
                "products=" + products +
                ", checkoutSummaryDAO=" + checkoutSummaryDAO +
                '}';
    }
}
