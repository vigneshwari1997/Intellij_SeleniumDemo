package com.allure.example.runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.plugin.Plugin;

@CucumberOptions(
        features = "src/test/resources/firstTest.feature",
        glue = {"com.allure.example"},
        tags = "@messaging",
        publish = false,
        plugin = {
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "pretty",
                "rerun:target/cucumber-reports/rerun.txt",
                "com.aventstack.extentreports.reporter.ExtentCucumberReporter:"
        })
public class Run extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void generateExtentReport() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        String buildNumber = "1";
        String projectName = "Selenium Sample Framework";
        jsonFiles.add("target/cucumber-reports/CucumberTestReport.json");
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
