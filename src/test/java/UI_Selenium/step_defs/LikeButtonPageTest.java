package UI_Selenium.step_defs;

import common_utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LikeButtonPageTest {
    ScenarioContext context;

    public LikeButtonPageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @Given("Website starting")
    public void websiteStarting() {
        context.driver.get(ConfigReader.readProperty
                ("projectURL","src/test/resources/properties/configuration.properties"));

    }
    @When("I log in with user email {string} and user password {string}")
    public void iLogInWithUserEmailAndUserPassword(String arg0, String arg1) {
        context.selenium_utils.sendKeys(context.likeButtonPage.email12,arg0);
        context.selenium_utils.sendKeys(context.likeButtonPage.password12, arg1);
        context.selenium_utils.click(context.likeButtonPage.signIn12);
    }


    @When("I like a statement in the Do's table I verify the like button works properly")
    public void i_like_a_statement_in_the_do_s_table_i_verify_the_like_button_works_properly() {
        context.selenium_utils.click(context.likeButtonPage.likeBtn);
    }

    @When("the Don't table as well")
    public void the_don_t_table_as_well() {
        context.selenium_utils.click(context.likeButtonPage.likeBtn2);
    }

    @And("I verify the like functionality works")
    public void iVerifyTheLikeFunctionalityWorks() {
        Assert.assertTrue(context.likeButtonPage.likeBtn.isDisplayed());
        Assert.assertTrue(context.likeButtonPage.likeBtn2.isDisplayed());
        
    }


    {

    }



        }


