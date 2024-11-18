package ru.netology.appiumtests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.netology.appiumtests.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;

public class AppiumTests {
    private AndroidDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "32131JEHN04414");
        capabilities.setCapability("appPackage", "ru.netology.testing.uiautomator");
        capabilities.setCapability("appActivity", "ru.netology.testing.uiautomator.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        mainPage = new MainPage(driver);
    }

    @Test
    public void testEmptyText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String startText = mainPage.getTextToBeChanged();

        mainPage.enterText("       ");
        mainPage.clickChangeButton();

        Assertions.assertEquals(startText, mainPage.getTextToBeChanged());
    }

    @Test
    public void testTextInNewActivity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String testText = "Hello!";

        mainPage.enterText(testText);
        mainPage.clickActivityButton();

        String newText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ru.netology.testing.uiautomator:id/text"))).getText();

        Assertions.assertEquals(testText, newText);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}