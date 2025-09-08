package com.everShop.api.clients;

public class GraphQLQueries {

    private static  String fetchProductsQuery = "{ \"query\": \"{ products { items { productId uuid name status sku } } }\" }";


    public static String getFetchProductsQuery() {
        return fetchProductsQuery;
    }
}
