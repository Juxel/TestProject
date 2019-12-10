package com.cybertek.tests.Assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Locators_TestCase2 {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://amazon.de");

        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("crime");

        WebElement searchButton=driver.findElement(By.xpath("//input[contains(@value,'Los')]"));
        searchButton.click();
        Thread.sleep(3000);
        String Titel=driver.getTitle();
        System.out.println(Titel);

       if(Titel.contains("crime")){

            System.out.println("PASS");

        }else{
            System.out.println("FAILED");
        }

        driver.quit();


    }


}
