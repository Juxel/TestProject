package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassLocatorTest {
    public static void main(String[] args) {
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //navigate the website
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink=driver.findElement(By.className("nav-link"));
        homeLink.click();
        //go to the website
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //"multiple button" yazdirma
        WebElement multiButton=driver.findElement(By.className("h3"));
       String messageElement= multiButton.getText();

       System.out.println(messageElement);
        //asagidaki kisa yolu
        System.out.println(driver.findElement(By.className("h3")).getText());



    }
}
