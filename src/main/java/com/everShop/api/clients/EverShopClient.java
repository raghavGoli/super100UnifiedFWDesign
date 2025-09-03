package com.everShop.api.clients;

import com.everShop.api.config.EndPoints;
import com.everShop.api.payloadbuilder.LoginRequestPayloadBuilder;
import com.everShop.api.pojo.response.login.RootLogin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class EverShopClient {

    private RequestSpecification reqSpec;
    private ResponseSpecification resSpec;

    private ObjectMapper objectMapper;

    public EverShopClient(RequestSpecification reqSpec, ResponseSpecification resSpec, ObjectMapper objectMapper) {
        this.reqSpec = reqSpec;
        this.resSpec = resSpec;
        this.objectMapper = objectMapper;
    }

    public EverShopClient customerLogin(String email, String password) throws JsonProcessingException {

        String loginRequestPayloadBuilder = new LoginRequestPayloadBuilder()
                .setEmail(email)
                .setPassword(password).build();

        Response loginResponse = given(reqSpec)
                .body(loginRequestPayloadBuilder)
                .when()
                .post(EndPoints.getCustomerLoginEndpoint())
                .then()
                .spec(resSpec).extract().response();

        RootLogin rootLogin = objectMapper.readValue(loginResponse.asString(), RootLogin.class);
        System.out.println(rootLogin);

        return this;
    }
}


