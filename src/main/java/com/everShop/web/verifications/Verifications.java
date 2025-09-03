package com.everShop.web.verifications;

import com.everShop.web.calculations.SuccessCalculations;
import com.everShop.web.dao.input.product.ApplicationInputDAO;
import com.everShop.web.dao.output.SuccessOutputDAO;
import org.testng.Assert;

public class Verifications {

    public static void assertSuccessPage(SuccessOutputDAO actualData, ApplicationInputDAO applicationInputDao) {
        SuccessOutputDAO expectedData = SuccessCalculations.prepareSuccessExpectedData(applicationInputDao);
        System.out.println("Expected Data is: "+ expectedData);
        System.out.println("Actual Data is: "+ actualData);
        Assert.assertEquals(actualData, expectedData);


    }
}
