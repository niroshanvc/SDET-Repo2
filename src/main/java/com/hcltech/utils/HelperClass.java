package com.hcltech.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperClass {
    private static HelperClass helperClass;

    private static WebDriver driver;
    private static WebDriverWait wait;
    public static final int TIMEOUT = 10;

    private HelperClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//            options.addArguments("--disable-notifications");
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
//        driver.manage().window().maximize();
    }

    public static void openPage(String url) {
        driver.get(url);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (helperClass==null) {

            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }
}
