package com.cybertek.tests.TestCases3;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase_1 {
    // Test case #1 1.Go to “https://qa1.vytrack.com/"
    // 2.Login as a store manager
    // 3.Navigate to “Activities -> Calendar Events”
    // 4.Verify that page subtitle "Options" is displayed

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
        Thread.sleep(10000);
    }

    @Test
    public void click() throws InterruptedException {
        driver.get("https://qa1.vytrack.com");

        //locate userInput box
        WebElement userInput = driver.findElement(By.cssSelector("#prependedInput"));

        //input userName
        userInput.sendKeys("storemanager85");

       //locate passwordBox
        WebElement password = driver.findElement(By.cssSelector("#prependedInput2"));

        //input password
        password.sendKeys("UserUser123");
       //locate submit button and click
        WebElement submitButton = driver.findElement(By.cssSelector("#_submit"));
        submitButton.click();

        //locate Activities subModule link
        WebElement activities = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[4]"));

        //locate calendar event submodule link
        WebElement calendarEvents=driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]"));

        //implicity wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //hover over calendar link and click
        Actions actions = new Actions(driver);
        actions.moveToElement(activities).clickAndHold().moveToElement(calendarEvents).click().build().perform();

        //implicitly wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //wait until locate the text "option"
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement text = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(text));

        System.out.println(text.getText());

        //Verify that page subtitle "Options" is displayed
        Assert.assertTrue(text.isDisplayed(),"Verify that page subtitle Options is displayed");
    }

    @Test
    //Verify that page number is equals to "1"
    public void getPageNumber() throws InterruptedException {

        Thread.sleep(5000);
        WebElement pageNo= driver.findElement(By.cssSelector("input[type='number']"));
        Thread.sleep(5000);
        Assert.assertEquals(pageNo.getAttribute("value"), "1", "verify that 1 is shown");
        System.out.println(pageNo.getAttribute("value"));
    }
}
