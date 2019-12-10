package com.cybertek.tests.TestCases2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_1 {
    //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    // Step 2. Click on “Registration Form”
    // Step 3. Enter “wrong_dob” into date of birth input box.
    // Step 4. Verify that warning message is displayed: “The date of birth is not valid”
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
    public void click() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("13.13.2020");
        Thread.sleep(3000);
        String actualMessage=driver.findElement(By.xpath("//small[@data-bv-validator='date']")).getText();

        String expectedMessage= "The date of birth is not valid";
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.equals(expectedMessage));
    }
}
