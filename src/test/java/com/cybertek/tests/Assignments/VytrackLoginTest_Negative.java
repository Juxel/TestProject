package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackLoginTest_Negative {

    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        WebElement userInputBox=driver.findElement(By.id("prependedInput"));
        userInputBox.sendKeys("user7");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser12");
        WebElement loginButton=driver.findElement(By.xpath("//button[1]"));
        loginButton.click();
        WebElement errorMessage=driver.findElement(By.xpath("//div[contains(text(),'Invalid user name or password.')]"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Invalid user name or password.";
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actual message= " + actualMessage);
            System.out.println("expected message = " + expectedMessage);
        }
        driver.quit();

    }

}
