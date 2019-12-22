package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{
    //we dont need to create constructor and use PageFactory class here,
    //since we are extending from BasePage
    //xpath of email element-->//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']
    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;

    //how we get dynamic xpath which accepts email and return dynamically
    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public  WebElement email2;


}
