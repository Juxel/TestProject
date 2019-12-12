package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver; //public de olur
    protected Actions action;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod(){
        //driver = WebDriverFactory.getDriver("chrome"); bunu yerine asagidakini kullaniyoruz
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
