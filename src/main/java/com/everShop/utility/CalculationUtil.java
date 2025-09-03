package com.everShop.utility;

public class CalculationUtil {

    public static String removeSymbolFromPrice(String text, String symbol){
        String outputText =  text.substring(1,text.length());
        return outputText.replace(",", "");
    }


    public static String extractItemCountFromText(String text) {
        int pos = text.indexOf(" items");
        return text.substring(0,pos);
    }

    public static String extractTaxAmountFromText(String text){
        //"Inclusive of tax $410.91
        int startPos = text.indexOf("$");
        int endPos = text.indexOf(")");
        String outputText = text.substring(startPos+1,endPos );
        return outputText.replace(",", "");
    }
}
