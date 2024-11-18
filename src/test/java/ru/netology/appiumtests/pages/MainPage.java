package ru.netology.appiumtests.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage {
    private AndroidDriver driver;

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By textToBeChanged = By.id("ru.netology.testing.uiautomator:id/textToBeChanged");
    private By userInput = By.id("ru.netology.testing.uiautomator:id/userInput");
    private By buttonChange = By.id("ru.netology.testing.uiautomator:id/buttonChange");
    private By buttonActivity = By.id("ru.netology.testing.uiautomator:id/buttonActivity");

    public String getTextToBeChanged() {
        return driver.findElement(textToBeChanged).getText();
    }

    public void enterText(String text) {
        driver.findElement(userInput).sendKeys(text);
    }

    public void clickChangeButton() {
        driver.findElement(buttonChange).click();
    }

    public void clickActivityButton() {
        driver.findElement(buttonActivity).click();
    }
}