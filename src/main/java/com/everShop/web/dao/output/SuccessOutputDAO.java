package com.everShop.web.dao.output;

import com.everShop.web.dao.output.components.CustomerInfoDAO;
import com.everShop.web.dao.output.components.OrderSummaryDAO;

import java.util.Objects;

public class SuccessOutputDAO {

    private CustomerInfoDAO customerInfoDAO;
    private OrderSummaryDAO orderSummaryDao;


    public CustomerInfoDAO getCustomerInfoDAO() {
        return customerInfoDAO;
    }

    public void setCustomerInfoDAO(CustomerInfoDAO customerInfoDAO) {
        this.customerInfoDAO = customerInfoDAO;
    }

    public OrderSummaryDAO getOrderSummaryDao() {
        return orderSummaryDao;
    }

    public void setOrderSummaryDao(OrderSummaryDAO orderSummaryDao) {
        this.orderSummaryDao = orderSummaryDao;
    }


    @Override
    public String toString() {
        return "SuccessOutputDAO{" +
                "customerInfoDAO=" + customerInfoDAO +
                ", orderSummaryDao=" + orderSummaryDao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuccessOutputDAO that = (SuccessOutputDAO) o;
        return Objects.equals(customerInfoDAO, that.customerInfoDAO) && Objects.equals(orderSummaryDao, that.orderSummaryDao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerInfoDAO, orderSummaryDao);
    }
}
