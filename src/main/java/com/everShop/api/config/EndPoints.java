package com.everShop.api.config;

public class EndPoints {

    private static String customerLoginEndpoint = "/customer/login";

    private static String graphQLEndpoint = "/api/graphql";

    private static String createCartEndPoint = "/api/carts";

    public static String getCreateCartEndPoint() {
        return createCartEndPoint;
    }

    public static String getCustomerLoginEndpoint() {
        return customerLoginEndpoint;
    }

    public static String getGraphQLEndpoint() {
        return graphQLEndpoint;
    }
}
