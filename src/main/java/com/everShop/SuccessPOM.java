package com.everShop;

import com.everShop.dao.output.CheckoutOutputDAO;
import com.everShop.dao.output.components.CheckoutSummaryDAO;
import com.everShop.dao.output.components.ProductDAO;
import com.everShop.utility.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SuccessPOM extends BasePOM{
    public SuccessPOM(WebDriver wd) {
        super(wd);
        checkoutOutputDAO = new CheckoutOutputDAO();

    }
    private By tableRow = By.xpath("//div[contains(@class,'checkout-summary h-full')]//table[@class='listing items-table']//tbody//tr");
    private By productName_bold = By.xpath(".//span[contains(@class,'semibold')]");
    private By productSize = By.xpath(".//div[contains(@class,'cart-item-variant-options')]//li[1]//span[2]");
    private By productColor = By.xpath(".//div[contains(@class,'cart-item-variant-options')]//li[2]//span[2]");
    private By productPrice = By.xpath(".//span");
    private By itemQuantity = By.xpath(".//div[@class='product-thumbnail']//span");
    private By checkoutSummarySection = By.xpath("//div[contains(@class,'checkout-summary h-full')]");
    private By subTotalPrice = By.xpath(".//span[text()='Sub total']/following-sibling::div//div[2]");

    private By deliveryTypeText = By.xpath(".//span[text()='Shipping']//following-sibling::div//div[1]");
    private By shippingPrice = By.xpath(".//span[text()='Shipping']//following-sibling::div//div[2]");
    private By discountPrice = By.xpath(".//span[text()='Discount']//following-sibling::div//div[2]");
    private By grandTotalPrice = By.xpath(".//div[@class='grand-total-value']");
    private By taxprice = By.xpath(".//div[contains(@class,'grand-total')]//span[@class='italic']");


    public SuccessPOM getPage(String orderId) {
        String resourcePath = "/checkout/success/"+orderId;
        String baseURL = "https://demo.evershop.io";
        String newURL =  baseURL.concat(resourcePath);
        get(newURL);
        return this;
    }

    private CheckoutOutputDAO checkoutOutputDAO;

    public SuccessPOM getCheckoutProductData() {

        List<ProductDAO> products = new ArrayList<>();
        List<WebElement> rows = wd.findElements(tableRow);
        for (WebElement row : rows) {
            ProductDAO product = new ProductDAO();
            WebElement productCell = row.findElement(By.xpath(".//td[2]"));
            WebElement productCell1 = row.findElement(By.xpath(".//td[3]"));
            String productName = productCell.findElement(productName_bold).getText();
            product.setProductName(productName);
            String itemsQty = row.findElement(itemQuantity).getText();
            int itemsQty_num = Integer.parseInt(itemsQty);
            product.setItemQty(itemsQty_num);
            String productSize_str = productCell.findElement(productSize).getText();
            product.setProductSize(productSize_str);
            String productColor_str = productCell.findElement(productColor).getText();
            product.setProductColor(productColor_str);
            String productPrice_str = productCell1.findElement(productPrice).getText();
            String productPrice_dollarRemoved = productPrice_str.substring(1, productPrice_str.length()).replaceAll(",", "");
            float productPriceFloatValue = Float.parseFloat(productPrice_dollarRemoved);
            product.setProductPrice(productPriceFloatValue);
            products.add(product);
        }
        checkoutOutputDAO.setProducts(products);
        return this;
    }


    public SuccessPOM getCheckoutOrderSummaryData() {
        CheckoutSummaryDAO checkoutSummaryDAO = new CheckoutSummaryDAO();

        WebElement checkoutSummaryCell = wd.findElement(checkoutSummarySection);
        String deliveryType = checkoutSummaryCell.findElement(deliveryTypeText).getText();
        checkoutSummaryDAO.setDeliveryType(deliveryType);

        String subTotalPrice_str = checkoutSummaryCell.findElement(subTotalPrice).getText().replaceAll(",", "");
        String subTotalPriceDollarRemoved = subTotalPrice_str.substring(1, subTotalPrice_str.length());
        float subTotalPriceFloatValue = Float.parseFloat(subTotalPriceDollarRemoved);
        checkoutSummaryDAO.setSubTotalPrice(subTotalPriceFloatValue);

        String shippingPrice_str = checkoutSummaryCell.findElement(shippingPrice).getText().replaceAll(",", "");
        String shippingPriceDollarRemoved = shippingPrice_str.substring(1, shippingPrice_str.length());
        float shippingPriceFloatValue = Float.parseFloat(shippingPriceDollarRemoved);
        checkoutSummaryDAO.setShippingPrice(shippingPriceFloatValue);

        String discountedPrice_str = checkoutSummaryCell.findElement(discountPrice).getText().replaceAll(",", "");
        String discountedPriceDollarRemoved = discountedPrice_str.substring(1, discountedPrice_str.length());
        float discountedPriceFloatValue = Float.parseFloat(discountedPriceDollarRemoved);
        checkoutSummaryDAO.setShippingPrice(discountedPriceFloatValue);


        String grandTotalPrice_str = checkoutSummaryCell.findElement(grandTotalPrice).getText().replaceAll(",", "");
        String grandTotalDollarRemoved = grandTotalPrice_str.substring(1, grandTotalPrice_str.length());
        float grandTotalFloatValue = Float.parseFloat(grandTotalDollarRemoved);
        checkoutSummaryDAO.setTotalFinalPrice(grandTotalFloatValue);

        String taxAmountPrice = checkoutSummaryCell.findElement(taxprice).getText().replaceAll(",", "");
        String taxAmountString = taxAmountPrice.substring(taxAmountPrice.indexOf("$") + 1, taxAmountPrice.length() - 1);
        float taxAmountFloat = Float.parseFloat(taxAmountString);
        checkoutSummaryDAO.setTaxPrice(taxAmountFloat);
        checkoutOutputDAO.setCheckoutSummaryDAO(checkoutSummaryDAO);
        return this;
    }


    public CheckoutOutputDAO getCheckoutDataFromUI() {
        getCheckoutProductData().getCheckoutOrderSummaryData();
        return checkoutOutputDAO;
    }
}
