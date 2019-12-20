package com.cybertek.tests.day15_extent_report;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest(){
     extentLogger=report.createTest("Wrong Password Test");

        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username: user1 ");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        //we put after assertion so if the assertion fails, it will not send pass to report
        extentLogger.pass("PASS:Wrong Password Test");

    }

}