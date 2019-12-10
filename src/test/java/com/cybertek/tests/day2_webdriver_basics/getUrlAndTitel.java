package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getUrlAndTitel {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://practice.cybertekschool.com");

        String title=driver.getTitle(); //get titel of page
        System.out.println("title = " + title);

        String currentUrl=driver.getCurrentUrl(); //get current url of page
        System.out.println("currentUrl = " + currentUrl);

        String pageSource=driver.getPageSource(); //get page sources
        System.out.println("pageSource = " + pageSource);




    }
}
