package com.everShop.calculations;

import com.everShop.dao.input.product.ApplicationInputDAO;
import com.everShop.dao.output.SuccessOutputDAO;
import com.everShop.dao.output.components.CustomerInfoDAO;
import com.everShop.dao.output.components.OrderSummaryDAO;
import com.everShop.dao.output.components.ProductDAO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SuccessCalculations {

    public static SuccessOutputDAO prepareSuccessExpectedData(ApplicationInputDAO applicationInputDAO) {
        SuccessOutputDAO expectedResult = new SuccessOutputDAO();
        expectedResult.setCustomerInfoDAO(prepareCustomerInfoExpectedData(applicationInputDAO));
        expectedResult.setOrderSummaryDao(prepareOrderSummaryExpectedData(applicationInputDAO));
        return expectedResult;
    }

    public static CustomerInfoDAO prepareCustomerInfoExpectedData(ApplicationInputDAO applicationInputDAO){
        CustomerInfoDAO customerInfoDao = new CustomerInfoDAO();
        customerInfoDao.setEmailId(applicationInputDAO.getLoginInputDAO().getEmail());
        customerInfoDao.setPaymentMethod(applicationInputDAO.getCheckoutInputDAO().getPaymentMethod());
        return customerInfoDao;
    }

    public static OrderSummaryDAO prepareOrderSummaryExpectedData(ApplicationInputDAO applicationInputDAO){
        OrderSummaryDAO orderSummaryDao = new OrderSummaryDAO();
        orderSummaryDao.setItemsCount(applicationInputDAO.getHomeInputDAO().getProductNames().size());
        orderSummaryDao.setShipppingCharges(getShippingCharges(applicationInputDAO.getCheckoutInputDAO().getShippingMethod()));
        orderSummaryDao.setShippingMethodType(applicationInputDAO.getCheckoutInputDAO().getShippingMethod());
        orderSummaryDao.setDiscount(0f);
        orderSummaryDao.setPurchasedProducts(prepareProductExpectedData(applicationInputDAO));
        fillTotalProductData(orderSummaryDao);
        return orderSummaryDao;
    }

    public static List<ProductDAO> prepareProductExpectedData(ApplicationInputDAO applicationInputDAO){
        List<ProductDAO> expectedProductList = new ArrayList<>();
        for (String product : applicationInputDAO.getHomeInputDAO().getProductNames()) {
            ProductDAO productDao = new ProductDAO();
            productDao.setProductName(product);
            int qty = Integer.parseInt(applicationInputDAO.getProductInputDAO().getProductQty());
            float price = applicationInputDAO.getProductInputDAO().getProductPrice();
            productDao.setProductQty(qty);
            float totalPrice = qty*price;
            productDao.setTotalPrice(totalPrice);
            expectedProductList.add(productDao);
        }
        return expectedProductList;
    }

    public static void fillTotalProductData(OrderSummaryDAO orderSummaryDao) {
        float subTotalPrice = 0f;
        for(ProductDAO product: orderSummaryDao.getPurchasedProducts()){
            subTotalPrice = subTotalPrice+ product.getTotalPrice();
        }
        orderSummaryDao.setSubTotal(subTotalPrice);
        float totalOrderPrice = subTotalPrice + orderSummaryDao.getShipppingCharges() - orderSummaryDao.getDiscount();
        orderSummaryDao.setTotalOrderPrice(totalOrderPrice);
        float taxPerc = 9.081f;
        float taxAmount = totalOrderPrice*taxPerc/100;

        BigDecimal bd = new BigDecimal(Float.toString(taxAmount));
        bd = bd.setScale(2, RoundingMode.DOWN); // Truncate without rounding
        orderSummaryDao.setTaxes(bd.floatValue());

    }

    public static float getShippingCharges(String shippingMethodName) {
        if(shippingMethodName.toLowerCase().equals("Standard Delivery".toLowerCase())){
            return 5f;
        }else {
            return 10f;
        }
    }
}
