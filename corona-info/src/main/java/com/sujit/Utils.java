package com.sujit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

   static public Properties propertiesLoader(){
       Properties properties = new Properties();
        try (InputStream input = new FileInputStream("." + File.separator + "corona-info"
                + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "config.properties")) {
            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;

    }
}
