package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "Features",
    glue = "stepdefinition",
    tags = "@TestTopMenu",
    plugin = "html:target\\Reports\\htmlreport.html"
)
public class FeatureRunner {
}
