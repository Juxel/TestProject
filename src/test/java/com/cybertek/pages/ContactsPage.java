package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{
    //we dont need to create constructor and use PageFactory class here,
    //since we are extending from BasePage
    //xpath of email element-->//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']
    // if you are trying to come up dynamic xpath you cannot use @findby --> asagidakine ihtiyacimiz yok
    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;

    //how we get dynamic xpath which accepts email and return dynamically, yani-->devami asagida
    //create a method that accepts email as a String, and returns webelement based on that email
       public WebElement getContactEmail(String email){
        String emailXpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(emailXpath));

      }


}
