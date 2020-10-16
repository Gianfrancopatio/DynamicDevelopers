package UI_Selenium.step_defs;


import UI_Selenium.pages.DashboardPage;
import UI_Selenium.pages.LogInPage;
import UI_Selenium.pages.TLA_6_AllTopicsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class TLA_6_AllTopicsTest {
    ScenarioContext context;

    public TLA_6_AllTopicsTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @When("I log in with valid email {string} and password {string}")
    public void iLogInWithValidEmailAndPassword(String email, String password) {
        context.selenium_utils.sendKeys(context.logInPage.email, email);
        context.selenium_utils.sendKeys(context.logInPage.passwordbfSignup, password);
        context.selenium_utils.logInfo("I login using valid email: " + email + " and password: " + password, true);
        context.selenium_utils.click(context.logInPage.signInbtn);

    }





}
