package com.allure.example.configs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {

    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        return webDriver;
    }

    @Before
    public void startBrowser() {
        if (webDriver == null) {
            WebDriverManager.chromiumdriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    @After
    public void saveScreenshot(Scenario scenario) {
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()) {
            byte[] sourcePath = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
//            File fl2 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//            try{
//                FileUtils.copyFile(fl2, new File("screenshotCopy.jpg"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        getDriver().quit();
        webDriver = null;
    }
}
