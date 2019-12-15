package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void test1() {
        String browser = ConfigurationReader.get("browser");
        System.out.println(browser);

        System.out.println(ConfigurationReader.get("url"));
        System.out.println(ConfigurationReader.get("salesmanager_username"));
        System.out.println(ConfigurationReader.get("store manager")); //configuration properties de store manager olmadigi icin null
    }
}