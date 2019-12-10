package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropdownElement=driver.findElement(By.id("dropdownMenuLink"));

        //open dropdown menü
        dropdownElement.click();
        //Select Links=new Select(dropdownElement); bunu kullanamiyoruz cunku Select tag yok onu yerine a var

        List<WebElement> listOfLinks=driver.findElements(By.className("dropdown-item"));

        System.out.println("Number of Links: "+listOfLinks.size());
        //print text of each link
        System.out.println("List of Links: ");
        for (WebElement Link : listOfLinks) {
            System.out.println(Link.getText());
            System.out.println("first element: "+listOfLinks.get(0).getText());//print first element
            }

            //locate the element and clicking it
            //driver.findElement(By.linkText("Yahoo")).click(); //first way
            //index of the list click
            listOfLinks.get(3).click(); //second way

    }
}
