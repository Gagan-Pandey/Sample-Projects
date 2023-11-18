package step_definitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty:target/cucumber-pretty.txt",
        "html:target/cucumber-html-report", "json:output/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "step_definitions.Hooks" },
        tags = "@automated")
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
