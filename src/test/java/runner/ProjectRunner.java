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

        tags = "@doAndDontsTable"
        , dryRun = false
//=======
//        tags = "@LogInPage"
//        ,dryRun = false
//>>>>>>> 7ac02532f870ef003d7453703168c9abb0d1a2e4
=======
        tags = "@AddStatements",
        dryRun = false

>>>>>>> 915f65304ec056219ea54f47a8a414d1fde0a2b2
)

public class ProjectRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
