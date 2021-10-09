package com.org.util;

import com.org.driverFactory.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadPropertiesFile {

    public ReadPropertiesFile() {
    }

    public static Properties loadPropertiesFile(final String propFileName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propFileName);
            prop.load(input);
            input.close();
        } catch (IOException ex) {
            System.out.println("Cannot open properties file: " + propFileName + " exception: \n" + ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("loadPropertiesFile()"+e);
                }
            }
        }

        return prop;
    }
    public static String getPropertyValue(String key) {
        String value = null;
        String environment = DriverFactory.returnEnvironment();
        List<String> results = new ArrayList<String>();
        File[] files = new File(Constants.resourcePath + environment + "/").listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getPath());
            }
        }
        Properties prop = loadPropertiesFile(Constants.resourcePath + environment + "/environment.properties");
        value = prop.getProperty(key);
        if (value == null || Constants.EMPTY.equals(value)) {
            if (value == null || Constants.EMPTY.equals(value)) {
                int count = 0;
                while (count < results.size()) {
                    Properties searchAllProp = loadPropertiesFile(results.get(count));
                    value = searchAllProp.getProperty(key);
                    if (value != null) {
                        break;
                    }
                    count++;
                }
            }
        }
        return value;
    }

}
