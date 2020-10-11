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

=======
>>>>>>> 0632b523d644e054a7addf4f91cd587bccea000b

        tags = "@likebuttonfunctionality"
        , dryRun = false

<<<<<<< HEAD

=======
>>>>>>> 0632b523d644e054a7addf4f91cd587bccea000b
)

public class ProjectRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
