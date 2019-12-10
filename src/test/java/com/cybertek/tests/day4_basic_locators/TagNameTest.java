package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameTest {

    public static void main(String[] args) {
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //navigate the website
        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement fullNameInput=driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("John Doe with TagName");

        WebElement emailBox=driver.findElement(By.name("email"));

        emailBox.sendKeys("email@gmail.com");

        WebElement signUpButton=driver.findElement(By.tagName("button"));
        signUpButton.click();
        //print the message using tagname locator
        WebElement tagName=driver.findElement(By.tagName("h3"));
        tagName.getText();
        System.out.println(tagName);
        //asagidaki gibi de olur
        System.out.println(driver.findElement(By.tagName("h3")).getText());





    }


}
