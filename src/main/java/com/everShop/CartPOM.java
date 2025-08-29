package com.everShop;

import com.everShop.dao.output.CartOutputDAO;
import com.everShop.dao.output.components.OrderSummaryDAO;
import com.everShop.dao.output.components.ProductDAO;
import com.everShop.utility.WaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPOM extends BasePOM {

    public CartPOM(WebDriver wd) {
        super(wd);
        cartOutputDAO = new CartOutputDAO();
    }

    private By checkoutBtn = By.xpath("//div[@class='summary']//a");
    private By tableHeaders = By.xpath("//div[@id='shopping-cart-items']//table//thead//tr//td/span");
    private By tableRow = By.xpath("//div[@id='shopping-cart-items']//table//tbody//tr");
    private By subTotal = By.xpath("//div[@class='summary']//div[text()='Sub total']/following-sibling::div");
    private By grandTotal = By.xpath("//div[@class='grand-total-value']");
    private By taxAmountText = By.xpath("//div[contains(@class, 'grand-total')]/div[1]//span[@class='italic']");
    private By productNameLink = By.xpath(".//div[@class='cart-tem-info']/a");
    private By productSizeTxt =By.xpath(".//div[contains(@class,'cart-item-variant-options')]//li[1]//span[2]");
    private By productColorTxt =By.xpath(".//div[contains(@class,'cart-item-variant-options')]//li[2]//span[2]");
    private By productPriceTxt =By.xpath(".//span[@class='sale-price']");



    private CartOutputDAO cartOutputDAO;


    public CartPOM getPage() {
        String resourcePath = "/cart";
        get(resourcePath);
        WaitManager.waitForElementToBeLocated(wd, checkoutBtn);
        return this;
    }

@Step("Click on checkout button")
    public CheckoutPOM clickCheckoutBtn() {
        wd.findElement(checkoutBtn).click();
        return new CheckoutPOM(wd);
    }

    public CartPOM getProductTableHeaders() {
        List<WebElement> headers = wd.findElements(tableHeaders);
        for (WebElement header : headers) {
            String headerText = header.getText();
            System.out.println("Header Text Names in Cart Page are " + headerText);
        }
        return this;
    }

    public CartPOM getProductDetailsFromCartPage() {

        List<ProductDAO> products = new ArrayList<>();
        List<WebElement> rows = wd.findElements(tableRow);
        for (WebElement row : rows) {
            ProductDAO product = new ProductDAO();

            WebElement productCell = row.findElement(By.xpath(".//td[1]"));
            String productName = productCell.findElement(productNameLink).getText();
            product.setProductName(productName);
            String productSize = productCell.findElement(productSizeTxt).getText();
            product.setProductSize(productSize);
            String productColor = productCell.findElement(productColorTxt).getText();
            product.setProductColor(productColor);
            WebElement priceCell = row.findElement(By.xpath(".//td[2]"));
            String productPrice = priceCell.findElement(productPriceTxt).getText().replaceAll(",","");
            String productPriceRemovedDollar = productPrice.substring(1, productPrice.length());
            product.setProductPrice(Float.parseFloat(productPriceRemovedDollar));

            WebElement quantityCell = row.findElement(By.xpath(".//td[3]"));
            String productQty = quantityCell.findElement(By.xpath(".//input")).getAttribute("value");
            product.setProductQty(Integer.parseInt(productQty));

            WebElement totalPriceCell = row.findElement(By.xpath(".//td[4]"));
            String productTotalPrice = totalPriceCell.findElement(By.xpath(".//span")).getText().replaceAll(",","");
            String productTPPriceRemovedDollar = productTotalPrice.substring(1, productTotalPrice.length());

            product.setTotalPrice(Float.parseFloat(productTPPriceRemovedDollar));
            products.add(product);
        }
        cartOutputDAO.setProducts(products);
        return this;
    }

    public CartOutputDAO getCartDataFromUI() {
        getProductDetailsFromCartPage().getOrderSummaryData();
        return cartOutputDAO;
    }


    public CartPOM getOrderSummaryData() {
        OrderSummaryDAO orderSummaryDAO = new OrderSummaryDAO();

        String subTotalPrice = wd.findElement(subTotal).getText().replaceAll(",","");
        String subTotalPriceDollarRemoved = subTotalPrice.substring(1, subTotalPrice.length());
        float subTotalPriceFloatValue = Float.parseFloat(subTotalPriceDollarRemoved);
        orderSummaryDAO.setTotalOrderPrice(subTotalPriceFloatValue);

        String grandTotalPrice = wd.findElement(grandTotal).getText().replaceAll(",","");;
        String grandTotalDollarRemoved = grandTotalPrice.substring(1, grandTotalPrice.length());
        float grandTotalFloatValue = Float.parseFloat(grandTotalDollarRemoved);
        orderSummaryDAO.setTotalOrderPrice(grandTotalFloatValue);

        String taxAmountPrice = wd.findElement(taxAmountText).getText().replaceAll(",","");;
        String taxAmountString = taxAmountPrice.substring(taxAmountPrice.indexOf("$") + 1, taxAmountPrice.length()-1);
        float taxAmountFloat = Float.parseFloat(taxAmountString);
        orderSummaryDAO.setTaxes(taxAmountFloat);

        cartOutputDAO.setOrderSummaryDAO(orderSummaryDAO);
       return this;
    }

}
