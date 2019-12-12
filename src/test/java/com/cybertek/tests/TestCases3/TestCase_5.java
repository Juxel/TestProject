package com.cybertek.tests.TestCases3;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase_5 {
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
    /*
            1.Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Click on the top checkbox to select all
            5. Verify that all calendar events were selected */
    public void checkBoxTest() throws InterruptedException {

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
        WebElement calendarEvents = driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]"));

        //implicity wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //hover over calendar link and click
        Actions actions = new Actions(driver);
        actions.moveToElement(activities).clickAndHold().moveToElement(calendarEvents).click().build().perform();

        //implicitly wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //locate the check box
        WebElement checkbox = driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input"));
        Thread.sleep(3000);
        //select the first checkbox
        checkbox.click();
        Thread.sleep(2000);

        //get the total number of rows
        List<WebElement> numOfRows=driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tbody/tr"));
        System.out.println("Number of Rows int :"+numOfRows.size());

        for (int i =1; i <= numOfRows.size(); i++) {
            WebElement checkBoxEachRow=driver.findElement(By.xpath("//tbody[@class='grid-body']/tr["+i+"]//input"));
            Assert.assertTrue(checkBoxEachRow.isSelected(),"Verify that checkBoxEachRow is selected");
        }


    }
}
