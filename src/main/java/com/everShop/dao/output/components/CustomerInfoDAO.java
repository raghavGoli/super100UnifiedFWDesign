package com.everShop.dao.output.components;

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
}
