package com.allure.example.configs.Pages;

import com.allure.example.configs.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    BasePage() {
        this.driver = Hooks.getDriver();
    }

    public void inputText(String text, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    public boolean checkElement(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException | TimeoutException ne) {
            return false;
        }
    }

    protected void waitForVisibilityOf(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForClickable(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    public void pollingWait(WebElement webElement) {
        FluentWait fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(webElement));
    }

    public void pause(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
