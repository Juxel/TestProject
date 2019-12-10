package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlNotChanged {
    /**Test steps
     * Verify URL not changed
     * open browser
     * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * click on Retrieve password
     * verify that url did not change
     */

    public static void main(String[] args) {
        // open Chrome
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // save url to string variable
        String expectedUrl= driver.getCurrentUrl();

        // click on retrieve password
        // WebElement--> class that represents elements on the webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();
        // get actual Url
        String actualUrl= driver.getCurrentUrl();

        //verify that url did not changed
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //close the browser
        driver.quit();
    }


}
