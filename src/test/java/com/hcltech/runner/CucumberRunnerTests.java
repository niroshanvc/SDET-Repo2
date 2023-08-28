package com.hcltech.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@ValidCredentials",
        features = "src/test/resources/features",
        glue = "com.hcltech.definitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
