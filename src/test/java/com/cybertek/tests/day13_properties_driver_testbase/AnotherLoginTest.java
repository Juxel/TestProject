package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {
    @Test
    public void test1(){
        driver.get("https://google.com");
    }

}
