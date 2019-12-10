package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Locators_TestCase1 {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://ebay.com");
        WebElement searchBox=driver.findElement(By.cssSelector("#gh-ac-box2>input"));
        searchBox.sendKeys("TV");
        WebElement searchButton=driver.findElement(By.cssSelector("#gh-btn"));
        searchButton.click();

        WebElement searchResult=driver.findElement(By.xpath("//h1[contains(@class,'t-h')]/span"));

        System.out.println("Search result is: "+searchResult.getText());

        driver.quit();
    }
}
