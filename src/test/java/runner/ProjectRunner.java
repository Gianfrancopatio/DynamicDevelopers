package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"UI_Selenium/step_defs"},
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/re-run.txt"
        },

<<<<<<< HEAD


        tags = "@TLA10_AnswerCount"
=======
        tags = "@existingDashBoard"
>>>>>>> e392c9588cb1d6f95dba0e17df44481f3b299b94
        , dryRun = false

)

public class ProjectRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
