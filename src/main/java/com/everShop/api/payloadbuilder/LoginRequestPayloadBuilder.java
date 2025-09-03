package com.everShop.api.payloadbuilder;

import com.everShop.api.pojo.request.LoginRequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginRequestPayloadBuilder {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public LoginRequestPayloadBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequestPayloadBuilder setPassword(String password) {
        this.password = password;
        return this;
    }


    public String build() {
        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setEmail(this.getEmail());
        loginRequestBody.setPassword(this.getPassword());

        ObjectMapper objectMapper = new ObjectMapper();
        String loginreqBody;
        try {
            loginreqBody = objectMapper.writeValueAsString(loginRequestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return loginreqBody;

    }
}
