package com.cybertek.tests.day16_screenshot;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    /*open the chrome
    go to qa3.vytrack
    login as a sales manager
    navigate to customers ->contacts
    click on email mbrackstone9@example.com
    verify that full name is Ms Mariam Brackstone
    verify that email is mbrackstone9@example.com
    verify that phone number is +18982323434 */

    @Test
    public void contactDetailsTest(){
        //for reporting
        extentLogger=report.createTest("contactDetailsTest");

        LoginPage loginPage=new LoginPage();
        String username= ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("Password: "+password);
        extentLogger.info("Login as a sales manager");
        loginPage.login(username,password);

        //new DashBoardPage().navigateToModule("Customers","Contacts"); -->bu lazy way, asagidaki uzun yol
        ContactsPage contactsPage=new ContactsPage();
        BrowserUtils.waitFor(2);
        extentLogger.info("navigate to customers ->contacts page");
        contactsPage.navigateToModule("Customers","Contacts");

        contactsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        //verify that full name is Ms Mariam Brackstone
        ContactInfoPage contactInfoPage=new ContactInfoPage();
        String actualFullname=contactInfoPage.fullname.getText();
        String expectedFullname="Ms Mariam Brackstone";

        extentLogger.info("Verify fullname is "+expectedFullname);
        Assert.assertEquals(actualFullname,expectedFullname,"verify fullnames");


       // verify that email is mbrackstone9@example.com
        String actualEmail=contactInfoPage.email.getText();
        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(actualEmail,"mbrackstone9@example.com");


        //verify that phone number is +18982323434
        extentLogger.info("verify that phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434");


    }

}
