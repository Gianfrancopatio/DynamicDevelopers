package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/re-run.txt",
        glue = "UI_Selenium/step_defs",
        plugin = {
                "rerun:target/re-run.txt"
        }
)
public class FailedRunner extends AbstractTestNGCucumberTests {
}
