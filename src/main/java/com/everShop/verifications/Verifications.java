package com.everShop.verifications;

import com.everShop.calculations.SuccessCalculations;
import com.everShop.dao.input.product.ApplicationInputDAO;
import com.everShop.dao.output.SuccessOutputDAO;
import org.testng.Assert;

public class Verifications {

    public static void assertSuccessPage(SuccessOutputDAO actualData, ApplicationInputDAO applicationInputDao) {
        SuccessOutputDAO expectedData = SuccessCalculations.prepareSuccessExpectedData(applicationInputDao);
        System.out.println("Expected Data is: "+ expectedData);
        System.out.println("Actual Data is: "+ actualData);
        Assert.assertEquals(actualData, expectedData);


    }
}
