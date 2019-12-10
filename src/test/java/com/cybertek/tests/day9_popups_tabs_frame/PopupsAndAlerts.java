package com.cybertek.tests.day9_popups_tabs_frame;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void htmlPopUp(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //locating and clicking destroy button
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
        //locating No button and clicking it
        driver.findElement(By.xpath("//*[text()='No']")).click();
    }
    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //Click for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();
        //Controling alert using with Alert class
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //accept alert --> clicking ok in the alerts
        alert.accept();
        //clicking JS Confirm
        driver.findElement(By.xpath("//button[2]")).click();
        //clicking x to close, selecting no/cancel
        Thread.sleep(2000);
        alert.dismiss();
        //clicking JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //sendKeys() --> send some keys

        Thread.sleep(1000);
        alert.sendKeys("Mike Smith");
        //when we send the text, we might not see the text in the inputbox.
        Thread.sleep(500);
        alert.accept();
    }
}