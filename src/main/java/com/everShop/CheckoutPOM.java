package com.everShop;

import com.everShop.dao.input.components.CheckoutInputDAO;
import com.everShop.dao.output.CheckoutOutputDAO;
import com.everShop.dao.output.components.CheckoutSummaryDAO;
import com.everShop.dao.output.components.ProductDAO;
import com.everShop.utility.WaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPOM extends BasePOM {

    public CheckoutPOM(WebDriver wd) {
        super(wd);
        checkoutOutputDAO = new CheckoutOutputDAO();
    }

    private By fullname_input = By.xpath("//input[@name='address[full_name]']");
    private By telephone_input = By.xpath("//input[@name='address[telephone]']");
    private By address_input = By.xpath("//input[@name='address[address_1]']");
    private By city_input = By.xpath("//input[@name='address[city]']");
    private By countrydrpDown = By.xpath("//select[@id='address[country]']");
    private By provincedrpDown = By.xpath("//select[@id='address[province]']");
    private By postalCode_input = By.xpath("//input[@name='address[postcode]']");
    private String shippingMethod = "//div[@class='shipping-methods']//span[contains(text(),'$$$')]";
    private By continueToPaymentBtn = By.xpath("//span[text()='Continue to payment']/parent::button");
    private By placeOrder_btn = By.xpath("//span[text()='Place Order']/parent::button");
    private String paymentMethod = "//h4[text()='Payment Method']/following-sibling::div//img[@alt='$$$']/parent::div/preceding-sibling::a";
    private By shippingMethodRadioWrapper = By.xpath("//div[@class='field-wrapper radio-field']");

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


    public CheckoutPOM setFullName(String fullName) {
        WaitManager.waitForElementToBeClickable(wd, fullname_input);
        wd.findElement(fullname_input).sendKeys(fullName);
        return this;
    }

    public CheckoutPOM setTelephoneNum(String telephoneNum) {
        wd.findElement(telephone_input).sendKeys(telephoneNum);
        return this;
    }

    public CheckoutPOM setAddress(String address) {
        wd.findElement(address_input).sendKeys(address);
        return this;
    }

    public CheckoutPOM setCity(String cityName) {
        wd.findElement(city_input).sendKeys(cityName);
        return this;
    }

    public CheckoutPOM selectCountry(String countryName) {
        Select s = new Select(wd.findElement(countrydrpDown));
        s.selectByVisibleText(countryName);
        return this;
    }

    public CheckoutPOM selectProvince(String provinceName) {
        Select s = new Select(wd.findElement(provincedrpDown));
        s.selectByVisibleText(provinceName);
        WaitManager.waitForElementToBeLocated(wd, shippingMethodRadioWrapper);
        return this;
    }

    public CheckoutPOM setPostalCode(String postalCodeNumber) {
        wd.findElement(postalCode_input).sendKeys(postalCodeNumber);
        return this;
    }

    public By getShippingMethod(String shippingMethodName) {
        String updatedShippingLocator = shippingMethod.replace("$$$", shippingMethodName);
        return By.xpath(updatedShippingLocator);
    }

    @Step("Click Shipping Method")
    public CheckoutPOM clickShippingMethod(String shippingMethodName) {
        wd.findElement(getShippingMethod(shippingMethodName)).click();
        return this;
    }

    @Step("Click on Continue payment")
    public CheckoutPOM clickContinueToPayment() {
        wd.findElement(continueToPaymentBtn).click();
        WaitManager.waitForElementToBeClickable(wd, placeOrder_btn);
        return this;
    }

    public By getPaymentMethod(String shippingMethodName) {
        String updatedPaymentMethodLocator = paymentMethod.replace("$$$", shippingMethodName);
        return By.xpath(updatedPaymentMethodLocator);
    }

    @Step("Select the payment method")
    public CheckoutPOM selectPaymentMethod(String paymentMethodName) {
        wd.findElement(getPaymentMethod(paymentMethodName)).click();
        return this;
    }

    @Step("Click on Place Order")
    public SuccessPOM clickPlaceOrder() {
        wd.findElement(placeOrder_btn).click();
        return new SuccessPOM(wd);
    }

    @Step("Fill Shipping Details")
    public CheckoutPOM fillShippingDetails(CheckoutInputDAO checkoutInputDAO) {
        setFullName(checkoutInputDAO.getFullName())
                .setTelephoneNum(checkoutInputDAO.getTelephoneNum())
                .setAddress(checkoutInputDAO.getAddress())
                .setCity(checkoutInputDAO.getCity())
                .selectCountry(checkoutInputDAO.getCountry())
                .selectProvince(checkoutInputDAO.getProvince())
                .setPostalCode(checkoutInputDAO.getPostCode());
        return this;
    }

    public CheckoutPOM get() {
        String resourcePath = "/checkout";
        get(resourcePath);
        WaitManager.waitForElementToBeLocated(wd, placeOrder_btn);
        return this;
    }


    private CheckoutOutputDAO checkoutOutputDAO;

    public CheckoutPOM getCheckoutProductData() {

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

    public CheckoutPOM getCheckoutOrderSummaryData() {
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
