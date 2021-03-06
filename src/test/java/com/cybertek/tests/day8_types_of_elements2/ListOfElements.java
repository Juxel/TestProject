package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("button.size()= " + buttons.size()); //there are six button

        //verify that you got 6 webElement

        Assert.assertEquals(buttons.size(), 6, "verify we got 6 buttons");

        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }
    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons =driver.findElements(By.tagName("buttonhgkhjh"));//wrong locator but we are not getting error
        //but empty list, yani 0

        }
        
    }

