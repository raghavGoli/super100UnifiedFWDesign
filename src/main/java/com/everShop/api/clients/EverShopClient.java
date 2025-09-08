package com.everShop.api.clients;

import com.everShop.api.applicationdao.ApplicationAPIDao;
import com.everShop.api.applicationdao.CreateCartAPIDao;
import com.everShop.api.applicationdao.LoginAPIDao;
import com.everShop.api.applicationdao.ProductAPIDao;
import com.everShop.api.config.EndPoints;
import com.everShop.api.payloadbuilder.CreateCartRequestPayloadBuilder;
import com.everShop.api.payloadbuilder.LoginRequestPayloadBuilder;
import com.everShop.api.pojo.request.ProductItemRequestBody;
import com.everShop.api.pojo.response.ApplicationResponsePOJO;
import com.everShop.api.pojo.response.createcart.RootCreateCart;
import com.everShop.api.pojo.response.fetchproducts.Item;
import com.everShop.api.pojo.response.fetchproducts.RootFetchProducts;
import com.everShop.api.pojo.response.login.RootLogin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.Cookie;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class EverShopClient {


    private RequestSpecification reqSpec;
    private ResponseSpecification resSpec;

    private ObjectMapper objectMapper;

    private ApplicationResponsePOJO applicationResponsePOJO;

    private ApplicationAPIDao applicationAPIDao;

    private Cookie cookie;

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public EverShopClient(RequestSpecification reqSpec, ResponseSpecification resSpec, ObjectMapper objectMapper, ApplicationResponsePOJO applicationResponsePOJO, ApplicationAPIDao applicationAPIDao) {
        this.reqSpec = reqSpec;
        this.resSpec = resSpec;
        this.objectMapper = objectMapper;
        this.applicationResponsePOJO = applicationResponsePOJO;
        this.applicationAPIDao = applicationAPIDao;
    }

    public EverShopClient customerLogin(String email, String password)  {

        String loginRequestPayloadBuilder = new LoginRequestPayloadBuilder()
                .setEmail(email)
                .setPassword(password).build();

        Response loginResponse = given(reqSpec)
                .body(loginRequestPayloadBuilder)
                .when()
                .post(EndPoints.getCustomerLoginEndpoint())
                .then()
                .spec(resSpec).extract().response();

        RootLogin rootLogin = null;
        try {
            rootLogin = objectMapper.readValue(loginResponse.asString(), RootLogin.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        applicationResponsePOJO.setRootLogin(rootLogin);
        extractSidAndCookieFromLoginResponse(loginResponse);
        applicationAPIDao.getLoginAPIDao().setEmail(email);
        applicationAPIDao.getLoginAPIDao().setPassword(password);

        return this;
    }

    public EverShopClient extractSidAndCookieFromLoginResponse(Response loginResponse) {
        String sessionCookie = loginResponse.getCookie("sid");

        Cookie sidCookie = new Cookie.Builder("sid", sessionCookie).build();
        setCookie(sidCookie);

        String sid = applicationResponsePOJO.getRootLogin().getData().getSid();
        LoginAPIDao loginAPIDao = new LoginAPIDao();
        loginAPIDao.setSid(sid);
        loginAPIDao.setSessionCookie(sessionCookie);
        applicationAPIDao.setLoginAPIDao(loginAPIDao);

        return this;
    }


    public EverShopClient getProducts() {

        Response getProductsResponse = given(reqSpec)
                .body(GraphQLQueries.getFetchProductsQuery())
                .cookie(getCookie())
                .when()
                .get(EndPoints.getGraphQLEndpoint())
                .then()
                .spec(resSpec).extract().response();

        RootFetchProducts rootFetchProducts = null;
        try {
            rootFetchProducts = objectMapper.readValue(getProductsResponse.asString(), RootFetchProducts.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        applicationResponsePOJO.setRootFetchProducts(rootFetchProducts);

        return this;
    }

    public EverShopClient extractProductDetailFromProductsResponse(String productName) {
        ArrayList<Item> items = applicationResponsePOJO.getRootFetchProducts().getData().getProducts().getItems();

        String skuValue = null;
        for(Item item: items) {
            if(item.getName().toLowerCase().equals(productName.toLowerCase())){
                skuValue = item.getSku();
                break;
            }
        }

        ProductAPIDao productAPIDao = new ProductAPIDao();
        productAPIDao.setProductName(productName);
        productAPIDao.setSku(skuValue);

        applicationAPIDao.addProductToProductsDao(productAPIDao);
        return this;
    }

    public EverShopClient createCart(String productName, String productQty) {

        CreateCartRequestPayloadBuilder createCartRequestPayloadBuilder =
                new CreateCartRequestPayloadBuilder();

        String skuvalue = null;
        for (ProductAPIDao product : applicationAPIDao.getProductsDao().getProductList()){
            if(product.getProductName().toLowerCase().equals(productName.toLowerCase())) {
                product.setQty(productQty);
                skuvalue =  product.getSku();
                break;
            }
        }

        ProductItemRequestBody productItemRequestBody = new ProductItemRequestBody();
        productItemRequestBody.setQty(productQty);
        productItemRequestBody.setSku(skuvalue);

        Response createCartResponse = given(reqSpec)
                .body(createCartRequestPayloadBuilder
                        .setCustomer_email(applicationAPIDao.getLoginAPIDao().getEmail())
                        .setCustomer_full_name("Venkata Goli")
                        .addItem(productItemRequestBody).build())
                .cookie(getCookie())
                .log().all()
                .when()
                .post(EndPoints.getCreateCartEndPoint())
                .then()
                .log().all()
                .spec(resSpec).extract().response();

        RootCreateCart rootCreateCart = null;
        try {
            rootCreateCart = objectMapper.readValue(createCartResponse.asString(), RootCreateCart.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        applicationResponsePOJO.setRootCreateCart(rootCreateCart);
        extractCartIDFromCreateCartResponse();
        return this;
    }

    public EverShopClient extractCartIDFromCreateCartResponse() {
        CreateCartAPIDao createCartAPIDao = new CreateCartAPIDao();
        createCartAPIDao.setCartID(applicationResponsePOJO.getRootCreateCart().getData().getCartId());
        applicationAPIDao.setCreateCartAPIDao(createCartAPIDao);
        return this;
    }
}


