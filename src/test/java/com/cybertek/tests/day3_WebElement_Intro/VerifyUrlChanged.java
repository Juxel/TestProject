package com.cybertek.tests.day3_WebElement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    /**Verify URL changed
     open browser
     go to http://practice.cybertekschool.com/forgot_password to an external site.
     enter any email
     click on Retrieve password
     verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        // go to link: http://practice.cybertekschool.com/forgot_passwordLinks
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter any email
        WebElement emailInput=driver.findElement(By.name("email"));
        // sendKeys()-->send keyboard actions to webElement/enters given text
        emailInput.sendKeys("email@gmail.com");
       //locate to password button
        WebElement retrievePassword=driver.findElement(By.id("form_submit"));
        retrievePassword.click();
        String expectedUrl="http://practice.cybertekschool.com/email_sents";
        //get actual url
        String currentUrl=driver.getCurrentUrl();

        //verify that url changed to http://practice.cybertekschool.com/email_sent

        if(expectedUrl.equals(currentUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("acualUrl"+currentUrl);
            System.out.println("expectedUrl"+expectedUrl);

        }

        // close
        driver.quit();


    }

}
