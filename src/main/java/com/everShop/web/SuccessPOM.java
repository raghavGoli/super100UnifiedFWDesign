package com.everShop.web;

import com.everShop.web.dao.output.SuccessOutputDAO;
import com.everShop.web.dao.output.components.CustomerInfoDAO;
import com.everShop.web.dao.output.components.OrderSummaryDAO;
import com.everShop.web.dao.output.components.ProductDAO;
import com.everShop.web.utility.CalculationUtil;
import com.everShop.web.utility.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SuccessPOM extends BasePOM {



    private SuccessOutputDAO successOutputDao;

    By customerEmailAddressText = By.xpath("//h3[text()='Contact information']//parent::div//following-sibling::div[2]");

    By paymentMethodText = By.xpath("//h3[text()='Payment Method']//parent::div//following-sibling::div");

    By productcount = By.xpath("//span[text()='Sub total']//parent::div[@class='summary-row']/div/div[1]");

    By subTotalPrice = By.xpath("//span[text()='Sub total']//parent::div[@class='summary-row']/div/div[2]");

    By shippingMethodName = By.xpath("//span[text()='Shipping']//parent::div[@class='summary-row']/div/div[1]");

    By shippingAddressCharges = By.xpath("//span[text()='Shipping']//parent::div[@class='summary-row']/div/div[2]");

    By discountCharges = By.xpath("//span[text()='Discount']//parent::div[@class='summary-row']/div/div[2]");

    By grandTotalPrice = By.xpath("//div[@class='grand-total-value']");

    By taxAmount = By.xpath("//div[contains(@class,'summary-row grand-total')]//span[@class='italic']");

    By productRows = By.xpath("//div[@id='summary-items']//tbody/tr");

    By productQuantity = By.xpath(".//td[1]//span[@class='qty']");

    By productTotalPrice = By.xpath(".//td[3]//span");

    By productName = By.xpath(".//td[2]/div[@class='product-column']/div/span");

    By continueToPaymentButton = By.xpath("//a[contains(@class,'button')]//span[text()='CONTINUE SHOPPING']");


    public SuccessOutputDAO getSuccessPageData() {
        this.waitForPageLoad();
        getCustomerInfoData().getOrderSummaryData();
        return successOutputDao;
    }

    public void  waitForPageLoad() {
        WaitManager.waitForElementToBeLocated(wd, continueToPaymentButton);
    }



    public SuccessPOM getCustomerInfoData() {
        CustomerInfoDAO customerInfoDao = new CustomerInfoDAO();
        customerInfoDao.setEmailId(wd.findElement(customerEmailAddressText).getText());
        customerInfoDao.setPaymentMethod(wd.findElement(paymentMethodText).getText());
        successOutputDao.setCustomerInfoDAO(customerInfoDao);
        return this;
    }

    public SuccessPOM getOrderSummaryData() {
        OrderSummaryDAO orderSummaryDao = new OrderSummaryDAO();
        List<ProductDAO> products = new ArrayList<>();
        for(WebElement we : wd.findElements(productRows)){
            products.add(getProductDao(we));
        }

        orderSummaryDao.setSubTotal(Float.parseFloat(CalculationUtil.removeSymbolFromPrice(wd.findElement(subTotalPrice).getText(), "$")));
        orderSummaryDao.setShippingMethodType(wd.findElement(shippingMethodName).getText());
        orderSummaryDao.setShipppingCharges(Float.parseFloat(CalculationUtil.removeSymbolFromPrice(wd.findElement(shippingAddressCharges).getText(), "$")));
        orderSummaryDao.setTaxes(Float.parseFloat(CalculationUtil.extractTaxAmountFromText(wd.findElement(taxAmount).getText())));
        orderSummaryDao.setTotalOrderPrice(Float.parseFloat(CalculationUtil.removeSymbolFromPrice(wd.findElement(grandTotalPrice).getText(), "$")));
        orderSummaryDao.setDiscount(Float.parseFloat(CalculationUtil.removeSymbolFromPrice(wd.findElement(discountCharges).getText(), "$")));
        orderSummaryDao.setItemsCount(Integer.parseInt(CalculationUtil.extractItemCountFromText(wd.findElement(productcount).getText())));
        orderSummaryDao.setPurchasedProducts(products);

        successOutputDao.setOrderSummaryDao(orderSummaryDao);

        return this;
    }

    public ProductDAO getProductDao(WebElement productRow) {
        ProductDAO productDao = new ProductDAO();
        productDao.setProductName(productRow.findElement(productName).getText());
        productDao.setQty(Integer.parseInt(productRow.findElement(productQuantity).getText()));
        String price = productRow.findElement(productTotalPrice).getText();
        String newPrice =price.substring(1, price.length());
        productDao.setTotalPrice(Float.parseFloat(newPrice.replace(",", "")));
        return productDao;
    }


    public SuccessPOM(WebDriver wd){

        super(wd);
        successOutputDao = new SuccessOutputDAO();

    }

    public SuccessPOM getPage(String orderId) {
        String resourcePath = "/checkout/success/"+orderId;
        get(resourcePath);
        return this;
    }


}
