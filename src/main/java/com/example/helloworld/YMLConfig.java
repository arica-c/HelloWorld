package com.example.helloworld;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

//Need to make the return array private and access them with getter methods
public class YMLConfig {

    String[] result = new String[4];
    InputStream inputStream;


    public String[] getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String apiKey = prop.getProperty("apiKey");
            String apiSecret = prop.getProperty("apiSecret");
            String accessToken = prop.getProperty("accessToken");
            String accessSecret = prop.getProperty("accessSecret");

            result[0] = apiKey;
            result[1]= apiSecret;
            result[2]= accessToken;
            result[3]= accessSecret;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
