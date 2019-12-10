package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackLoginTest {

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/");

        WebElement userInputBox=driver.findElement(By.id("prependedInput"));

        userInputBox.sendKeys("user7");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");



        WebElement loginButton=driver.findElement(By.xpath("//button[1]"));
        loginButton.click();

        String expectedUrl = "https://qa1.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();



    }


}
