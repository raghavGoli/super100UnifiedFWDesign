package com.everShop.api;

import com.everShop.api.clients.EverShopClient;
import com.everShop.web.utility.PropertyReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APIE2ETestCase extends BaseAPITest{

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    ObjectMapper objectMapper;


    @BeforeTest
    public void beforeTest() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri(PropertyReader.getProperty("url"))
                .setContentType(ContentType.JSON).build();


        resSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();

        objectMapper =new ObjectMapper();
    }

    @Test
    public void testPlaceOrderE2E() throws JsonProcessingException {


        String email = "gvenkataraghavendra@gmail.com";
        String password = "Sdetjob@12";

        EverShopClient client = new EverShopClient(reqSpec, resSpec, objectMapper);
        client.customerLogin(email, password);


    }
}
