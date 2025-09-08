package com.everShop.api.payloadbuilder;

public class CreateCartRequestPayloadBuilder {

    private String customer_full_name;
    private String customer_email;

    private List<ProductItemRequestBody> items;

    public String getCustomer_full_name() {
        return customer_full_name;
    }

    public CreateCartRequestPayloadBuilder setCustomer_full_name(String customer_full_name) {
        this.customer_full_name = customer_full_name;
        return this;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public CreateCartRequestPayloadBuilder setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
        return this;
    }

    public List<ProductItemRequestBody> getItems() {
        return items;
    }

    public CreateCartRequestPayloadBuilder addItem(ProductItemRequestBody item) {
        if(this.items == null){
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        return this;
    }

    public String build(){

        CreateCartRequestBody createCartRequestBody = new CreateCartRequestBody();

        createCartRequestBody.setCustomer_full_name(this.getCustomer_full_name());
        createCartRequestBody.setCustomer_email(this.getCustomer_email());
        createCartRequestBody.setItems(this.getItems());

        ObjectMapper objectMapper = new ObjectMapper();
        String createCartRequest = null;
        try {
            createCartRequest = objectMapper.writeValueAsString(createCartRequestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return createCartRequest;

    }
}
