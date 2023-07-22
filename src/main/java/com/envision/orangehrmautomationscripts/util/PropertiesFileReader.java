package com.envision.orangehrmautomationscripts.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {

    public static String getPropValue(String fileName, String key) {

        try (FileInputStream fis = new FileInputStream("orangehrm_testdata/"+fileName)) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
