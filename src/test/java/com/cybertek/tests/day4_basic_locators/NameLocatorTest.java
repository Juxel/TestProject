package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) {
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //navigate the website
        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement fullNameInput=driver.findElement(By.name("full_name"));

        fullNameInput.sendKeys("John Doe");

        WebElement emailBox=driver.findElement(By.name("email"));

        emailBox.sendKeys("email@gmail.com");

        WebElement submitButton=driver.findElement(By.name("wooden_spoon"));

        submitButton.click();
        //verify that you got "Thank you for signing up. Click the button below to return to the home page."
        WebElement retrieveMessage= driver.findElement(By.name("signup_message"));
        String actualMessage=retrieveMessage.getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected message= "+expectedMessage);
            System.out.println("actula message= "+actualMessage);
        }

        driver.quit();
    }
}
