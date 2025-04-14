package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/webapp/auth", // Path to your feature files
    glue = {"webapp.hooks", "webapp.auth"}, // Packages containing step definitions and hooks
    plugin = {
        "pretty", // Prints Gherkin steps in the console
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Enables Allure reporting
    },
    monochrome = true // Makes console output more readable
)
public class AuthRunnerTests {
}