package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class loginTest extends TestBase {

@Test
    public void test1(){
        //driver.get("https://qa2.vytrack.com/"); bunun yerine asagidakini kullaniyoruz
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        action=new Actions(driver);
        wait=new WebDriverWait(driver,10);
}


}
