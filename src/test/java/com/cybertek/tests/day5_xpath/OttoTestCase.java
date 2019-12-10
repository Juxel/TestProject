package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OttoTestCase {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.otto.de/");

        WebElement searchBox=driver.findElement(By.cssSelector("input[placeholder*='ff / A']"));
        searchBox.click();

        //WebElement inputBox=driver.findElement(By.id("ac-gn-searchform-input"));
        searchBox.sendKeys("TV");

        WebElement searchIcon=driver.findElement(By.xpath("//button[@type='submit'][@title='Suche']"));
        searchIcon.click();

        String message=driver.findElement(By.xpath("//h1[contains(text(),'Suc')]")).getText();
        String message2=driver.findElement(By.xpath("//strong[contains(text(),'(')]")).getText();
        System.out.println("search result. "+message+message2);

        driver.quit();

    }


}
