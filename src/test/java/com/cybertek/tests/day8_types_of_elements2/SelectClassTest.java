package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.locate the dropdown element with unique locator
        //WebElement dropdownElement = driver.findElement(By.id("state"));

        //create Select object by passing the element as a constructor
        //Select stateList = new Select(dropdownElement);

        Select stateList = new Select(driver.findElement(By.id("state"))); //bu kisa yöntemi

        //verify that first option is "Select a State"
        String expectedOption = "Select a State";
        String actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "Verify first selection is select a state");

        //HOW TO SELECT OPTIONS FROM THE DROPDOWN ?
        //1.USING VISIBLE TEXT
        //selectByVisibleText("text")--> selecting based on the visible text
        Thread.sleep(2000);
        //Selecting texas from the dropdown
        stateList.selectByVisibleText("Texas");
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, "Texas");

        //2.USING INDEX NUMBER
        //total option -->52
        Thread.sleep(2000);
        stateList.selectByIndex(51);
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, "Wyoming");

        //3.USING VALUE
        Thread.sleep(2000);
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());

    }
}