package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    @Test
    public void test(){
        String s1=Singleton.getInstance();
        String s2=Singleton.getInstance();

        System.out.println("s1="+s1);
        System.out.println("s2="+s2);

    }
    @Test
    public void test2(){
        //eski yöntem böyleydi
        //WebDriver driver= WebDriverFactory.getDriver("chrome");
        //bugunden sonra type of the driver will come from configuration.properties file
        WebDriver driver= Driver.get();

        //we are getting url from configuration.properties file
        //driver-->object
        driver.get(ConfigurationReader.get("url")); //boyle de yazilabilir-->Driver.get().get("http://amazon.com");

        //Driver-->class
        Driver.get().navigate().refresh();
    }
    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        Driver.get().get("http://amazon.com"); //söyle de yazilabilir-->driver.get("http://amazon.com")

        //if we are using Driver close , we use closeDriver method to close the driver
        Driver.closeDriver();
    }
}
