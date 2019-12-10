package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAndAfterTest {


    @Test
    public void test1(){
        System.out.println("This is my test One");
    }
    @Ignore //ignore the test OR  //@Test
    @Test
    public void test2(){
        System.out.println("This is my test Two");
    }
    @Test
    public void test3(){
        System.out.println("This is my test Three");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("BEFORE METHOD");
        System.out.println("OPENING THE BROWSER");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("CLOSE THE BROWSER");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS CODE");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTING");
    }
}
