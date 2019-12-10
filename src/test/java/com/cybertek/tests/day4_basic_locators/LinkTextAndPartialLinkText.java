package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {

    public static void main(String[] args) {
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //navigate the website
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement Link3=driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        Link3.click();

        driver.navigate().back();
        //asagida lazy way
        //driver.findElement(By.linkText("Home")).click();
        //partial linktext
        WebElement link6=driver.findElement(By.partialLinkText("Example 6"));
        link6.click();
        driver.navigate().back();
        WebElement link2=driver.findElement(By.partialLinkText("2"));
        link2.click();








    }
}
