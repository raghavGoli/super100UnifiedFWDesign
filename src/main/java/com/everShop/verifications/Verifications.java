package com.everShop.verifications;

import com.everShop.dao.output.SuccessOutputDAO;
import org.testng.Assert;

public class Verifications {

    public static void assertSuccessPage(SuccessOutputDAO actualData, SuccessOutputDAO expectedData) {
        Assert.assertEquals(actualData, expectedData);


    }
}
