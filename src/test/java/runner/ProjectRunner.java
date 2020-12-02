package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"UI_Selenium/step_defs"},
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/re-run.txt"
        },
        tags = "@dashboard"
        , dryRun = false
)

public class ProjectRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
