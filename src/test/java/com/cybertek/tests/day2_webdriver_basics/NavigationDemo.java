package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // we have to setup webdriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();

        // creating object for using selenium driver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver=new FirefoxDriver();

        //open browser
        driver.get("http://www.amazon.com"); //daha cok bunu kullaniyoruz
        //another way of opening website  . yukaridan farki: yukaridaki sayfanin tamamen yuklenmesini bekler
        driver.navigate().to("https://www.facebook.com"); //bu sayfanin tümüyle yüklenmesini beklemez
        driver.navigate().back(); //goes back previous webpage
        Thread.sleep(3000); //stop running code 3 second
        driver.navigate().forward(); // sonraki webpage

        //refresh the page
        driver.navigate().refresh();

    }
    }