package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
       //find start button and click
        driver.findElement(By.tagName("button")).click();
        //find the username inputbox
        WebElement userName=driver.findElement(By.id("username"));

        //How to wait EXPLICITLY
        //create explicit wait object
        WebDriverWait wait=new WebDriverWait(driver,10);

        //waiting for the specific element to be visible(up to 10 sec)
        wait.until(ExpectedConditions.visibilityOf(userName));
        //asagidaki gibi de olur
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));

       //sending some username
        userName.sendKeys("MikeSmith");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();

        //finding input box
        WebElement inputBox=driver.findElement(By.cssSelector("input[type='text']"));

        //wait until element is enabled or clickable
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));




        //type something
        inputBox.sendKeys("Something something");

    }
}
