package by.bsu.pagefactoryselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Driver {
    private final static String CHROMEDRIVER_PATH = "./chromedriver";

    private static WebDriver instance;

    public static WebDriver getInstance() {
        return instance;
    }

    @BeforeSuite
    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        instance = new ChromeDriver();
        instance.manage().window().maximize();
        instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void quitDriver() {
        instance.quit();
    }
}
