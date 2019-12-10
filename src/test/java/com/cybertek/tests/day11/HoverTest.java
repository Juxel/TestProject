package com.cybertek.tests.day11;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {
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
    //hover over each image in the website
    //verify each name:user text is displayed
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img=driver.findElement(By.tagName("img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(img).perform();
        WebElement text = driver.findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        for (int i = 1; i < 4; i++) {
            String imageXpath="(//img)["+i+"]";
            WebElement img=driver.findElement(By.xpath(imageXpath));

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();
            String textXpath="//h5[.='name: user"+i+"']";

           //passing xpath to webelement
            WebElement text = driver.findElement(By.xpath(textXpath));
           //verifying text is displayed
            Assert.assertTrue(text.isDisplayed());
        }

    }
    @Test
    public void StaleTest(){
        driver.get("http://google.com");
        WebElement input=driver.findElement(By.name("q"));
        //hit the Enter Key
        input.sendKeys("Selenium"+ Keys.ENTER);

        WebElement results=driver.findElement(By.id("resultStats"));
        Assert.assertTrue(results.isDisplayed());

        //go to google second time
        driver.navigate().back();
        input=driver.findElement(By.name("q"));
        input.sendKeys("java"+Keys.ENTER);

    }
}


