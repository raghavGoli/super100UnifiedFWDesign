package com.everShop.web.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static Properties properties = new Properties();


    public static void readPropertiesFile(String envName) {

        String fileName = envName.concat(".properties");
        File f = new File("src/main/resources/" + fileName);

        try {
            FileReader fileReader = new FileReader(f);
            properties.load(fileReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static String getProperty(String propertyName) {

        return properties.getProperty(propertyName);
    }
}
