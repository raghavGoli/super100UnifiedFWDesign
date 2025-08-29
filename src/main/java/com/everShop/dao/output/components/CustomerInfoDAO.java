package com.everShop.dao.output.components;

import java.util.Objects;

public class CustomerInfoDAO {

    private String emailId;
    private String paymentMethod;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "CustomerInfoDAO{" +
                "emailId='" + emailId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfoDAO that = (CustomerInfoDAO) o;
        return Objects.equals(emailId, that.emailId) && Objects.equals(paymentMethod, that.paymentMethod);
    }
}
