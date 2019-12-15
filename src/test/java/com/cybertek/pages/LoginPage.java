package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

   //@FindAll({})-->  either FindBy id OR Find by name
    ////@FindBys({})-->   FindBy id AND Find by name
    //asagidaki bunun yerine kullanilir-->driver.findElement(By.id("prependedInput"));

    @FindBy(id="prependedInput")
    public WebElement usernameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String usernameStr, String passwordStr){
        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }


}
