package com.everShop.api;

import com.everShop.api.applicationdao.ApplicationAPIDao;
import com.everShop.api.clients.EverShopClient;
import com.everShop.api.pojo.response.ApplicationResponsePOJO;
import com.everShop.web.utility.PropertyReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
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
    ApplicationResponsePOJO applicationResponsePOJO;

    ApplicationAPIDao applicationAPIDao;

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

        applicationResponsePOJO = new ApplicationResponsePOJO();
        applicationAPIDao = new ApplicationAPIDao();
    }

    @Test
    @Description("API E2e TestFlow")
    public void testPlaceOrderE2E() throws JsonProcessingException {


        String email = "gvenkataraghavendra@gmail.com";
        String password = "Sdetjob@12";
        String productName = "Nike zoom fly";
        String productQty = "2";

        EverShopClient client = new EverShopClient(reqSpec, resSpec, objectMapper, applicationResponsePOJO, applicationAPIDao);
        client.customerLogin(email, password)
                .getProducts().extractProductDetailFromProductsResponse(productName)
                .createCart(productName, productQty);


        System.out.println(applicationAPIDao);
        System.out.println(applicationResponsePOJO);


    }
}
