package UI_Selenium.step_defs;

import common_utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {
    ScenarioContext context;

    public Hooks(ScenarioContext scenarioContext) {
        this.context = scenarioContext;
    }

    @Before
    public void setUp(Scenario scenario) {
        if (!ConfigReader.readProperty("testType", "src/test/resources/properties/configuration.properties").equalsIgnoreCase("apiOnly"))
            context.initializeDriver();
        context.initializeClasses(context);
        context.scenario = scenario;
//        RestAssured.baseURI = "http://automation.techleadacademy.io/api";
    }

    @After
    public void tearDown(Scenario scenario) {
        if (context.driver != null) {
            {
                context.selenium_utils.takeScreenshot();
            }
            context.selenium_utils.quitDriver();
       }

    }
}
