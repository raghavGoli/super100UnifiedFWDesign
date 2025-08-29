package com.everShop.dao.output;

import com.everShop.dao.output.components.CheckoutSummaryDAO;
import com.everShop.dao.output.components.CustomerInfoDAO;
import com.everShop.dao.output.components.OrderSummaryDAO;

import java.util.Objects;

public class SuccessOutputDAO {

    private CustomerInfoDAO customerInfoDAO;
    private CheckoutSummaryDAO checkoutSummaryDAO;
    private CheckoutOutputDAO checkoutOutputDAO;
    private OrderSummaryDAO orderSummaryDao;


    public CheckoutOutputDAO getCheckoutOutputDAO() {
        return checkoutOutputDAO;
    }

    public void setCheckoutOutputDAO(CheckoutOutputDAO checkoutOutputDAO) {
        this.checkoutOutputDAO = checkoutOutputDAO;
    }

    public CustomerInfoDAO getCustomerInfoDAO() {
        return customerInfoDAO;
    }

    public void setCustomerInfoDAO(CustomerInfoDAO customerInfoDAO) {
        this.customerInfoDAO = customerInfoDAO;
    }

    public CheckoutSummaryDAO getCheckoutSummaryDAO() {
        return checkoutSummaryDAO;
    }


    public OrderSummaryDAO getOrderSummaryDao() {
        return orderSummaryDao;
    }

    public void setOrderSummaryDao(OrderSummaryDAO orderSummaryDao) {
        this.orderSummaryDao = orderSummaryDao;
    }
    public void setCheckoutSummaryDAO(CheckoutSummaryDAO checkoutSummaryDAO) {
        this.checkoutSummaryDAO = checkoutSummaryDAO;
    }

    @Override
    public String toString() {
        return "SuccessOutputDAO{" +
                "customerInfoDAO=" + customerInfoDAO +
                ", checkoutSummaryDAO=" + checkoutSummaryDAO +
                ", checkoutOutputDAO=" + checkoutOutputDAO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuccessOutputDAO that = (SuccessOutputDAO) o;
        return Objects.equals(customerInfoDAO, that.customerInfoDAO) && Objects.equals(orderSummaryDao, that.orderSummaryDao);
    }
}
