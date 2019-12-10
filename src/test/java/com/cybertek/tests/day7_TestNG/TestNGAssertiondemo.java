package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertiondemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals(5,5);

        System.out.println("Second Assertion");
        Assert.assertEquals("title","titlE");
        System.out.println("after second assertion");
    }
    @Test
    public void test2(){//verfy that title starts with C
        String actualTitle="Cybertek";
        String expectedTitlebeginning="C";

        System.out.println("first assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitlebeginning),"Verify title starts with C");
        //verify that email includes @ sign
        Assert.assertTrue("yasin@mail".contains("@"),"Verify @ in email");
    }
    @Test
    public void test3(){
        Assert.assertNotEquals("one","two","one shouldnt be equal to two");
    }
    @Test
    public void test4(){
        Assert.assertFalse(1<0); //we are verifying that condition is false test pass
        // if condition true test fails
    }
}
