package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioButton(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueRadioButton=driver.findElement(By.id("blue"));
        WebElement redRadioButton=driver.findElement(By.id("red"));

        //how we check radio button selected or not

        System.out.println("Is blue selected: "+blueRadioButton.isSelected());
        System.out.println("Is red selected: "+redRadioButton.isSelected());
        //verify that blueRadioButton selected
        Assert.assertTrue(blueRadioButton.isSelected(),"Verify that blue button is selected");
        //Verify that red button not selected
        Assert.assertFalse(redRadioButton.isSelected(),"verify that Red radio button is  not selected");

        //how to click radio button
        System.out.println("Clicking red radio button");
        redRadioButton.click();
        System.out.println("Is blue selected: "+blueRadioButton.isSelected());
        System.out.println("Is red selected: "+redRadioButton.isSelected());

        //verify that blueRadioButton not selected
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blueRadioButton not selected");
        //Verify that red button  selected
        Assert.assertTrue(redRadioButton.isSelected(),"Verify that red button  selected");
        driver.quit();
    }
}
