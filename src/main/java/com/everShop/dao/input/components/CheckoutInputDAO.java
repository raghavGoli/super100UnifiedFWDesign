package com.everShop.dao.input.components;

public class CheckoutInputDAO {

    private String fullName;
    private String telephoneNum;
    private String address;
    private String city;
    private String country;
    private String province;
    private String postCode;
    private String shippingMethod;
    private String paymentMethod;

    public CheckoutInputDAO(String fullName, String telephoneNum, String address, String city, String country, String province, String postCode, String shippingMethod, String paymentMethod) {
        this.fullName = fullName;
        this.telephoneNum = telephoneNum;
        this.address = address;
        this.city = city;
        this.country = country;
        this.province = province;
        this.postCode = postCode;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "CheckoutInputDAO{" +
                "fullName='" + fullName + '\'' +
                ", telephoneNum='" + telephoneNum + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", postCode='" + postCode + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
