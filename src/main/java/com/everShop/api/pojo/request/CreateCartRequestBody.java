package com.everShop.api.pojo.request;

public class CreateCartRequestBody {

    private String customer_full_name;
    private String customer_email;

    private List<ProductItemRequestBody> items;

    public String getCustomer_full_name() {
        return customer_full_name;
    }

    public void setCustomer_full_name(String customer_full_name) {
        this.customer_full_name = customer_full_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public List<ProductItemRequestBody> getItems() {
        return items;
    }

    public void setItems(List<ProductItemRequestBody> items) {
        this.items = items;
    }

}
