package com.everShop.dao.output;

import com.everShop.dao.output.components.CustomerInfoDAO;
import com.everShop.dao.output.components.OrderSummaryDAO;

public class SuccessOutputDAO {

    private CustomerInfoDAO customerInfoDAO;
    private OrderSummaryDAO orderSummaryDAO;

    public CustomerInfoDAO getCustomerInfoDAO() {
        return customerInfoDAO;
    }

    public void setCustomerInfoDAO(CustomerInfoDAO customerInfoDAO) {
        this.customerInfoDAO = customerInfoDAO;
    }

    public OrderSummaryDAO getOrderSummaryDAO() {
        return orderSummaryDAO;
    }

    public void setOrderSummaryDAO(OrderSummaryDAO orderSummaryDAO) {
        this.orderSummaryDAO = orderSummaryDAO;
    }

    @Override
    public String toString() {
        return "SuccessOutputDAO{" +
                "customerInfoDAO=" + customerInfoDAO +
                ", orderSummaryDAO=" + orderSummaryDAO +
                '}';
    }
}
