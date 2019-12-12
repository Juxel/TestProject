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

public class TestCase_6 {
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


        //locate the testers meeting cell

        List<WebElement> titleList=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        boolean isOK=false;
        for (WebElement testersMeeting : titleList) {
            if (testersMeeting.getText().equals("Testers Meeting")){
                testersMeeting.click();
                Thread.sleep(2000);
                List<WebElement> eachRow=driver.findElements(By.cssSelector("div.control-label"));
                if ((eachRow.get(0).getText().equals("Testers Meeting"))&(eachRow.get(1).getText().equals("This is a a weekly testers meeting"))&
                        (eachRow.get(2).getText().equals("Nov 27, 2019, 9:30 PM"))&(eachRow.get(3).getText().equals("Nov 27, 2019, 10:30 PM")) &
                        (eachRow.get(4).getText().equals("No"))&(eachRow.get(5).getText().equals("Stephan Haley"))&
                        (eachRow.get(7).getText().equals("Weekly every 1 week on Wednesday"))&
                        (eachRow.get(8).getText().equals("No")))
                {
                    isOK= true;
                }
                break;
            }
        }
        Assert.assertTrue(isOK, "Verify that all the data is there");
    }
       /* WebElement testersMeetingCell = driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[14]/td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title']"));
        Thread.sleep(3000);
        //select the first checkbox
        testersMeetingCell.click();
        Thread.sleep(2000);

        //locate the description
        WebElement description=driver.findElement(By.xpath("//div[@class='control-label html-property']/p"));
        System.out.println("description: "+description.getText());


        //locate Start
        WebElement start=driver.findElement(By.xpath("//div[@class='control-group attribute-row'][3]//div[@class='control-label']"));
        System.out.println("Start: "+start.getText());*/


}




