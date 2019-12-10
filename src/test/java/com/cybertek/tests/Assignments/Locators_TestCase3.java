package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locators_TestCase3 {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://wikipedia.org");
        WebElement searchBox=driver.findElement(By.cssSelector("#search-input>#searchInput"));
        searchBox.sendKeys("selenium webdriver");
        WebElement searchButton=driver.findElement(By.xpath("//button[contains(@class,'e-b')]"));
        searchButton.click();

        WebElement searchItem=driver.findElement(By.linkText("Selenium (software)"));
        searchItem.click();
       
        //verify url ends with "Selenium_(software)"
        String currentUrl= driver.getCurrentUrl();
        Thread.sleep(3000);
        if(currentUrl.endsWith("Selenium_(software")){
           System.out.println("PASS");
          }else{
            System.out.println("FAILED");
        }

        Thread.sleep(3000);

        driver.quit();



    }
}
