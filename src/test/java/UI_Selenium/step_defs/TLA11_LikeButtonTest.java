package UI_Selenium.step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TLA11_LikeButtonTest {
    ScenarioContext context;
    public TLA11_LikeButtonTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }


    @When("I click {string}")
    public void i_click(String dashboard) {
        context.selenium_utils.click(context.tla11LikeButtonPage.alltopicsDash);
        context.selenium_utils.logInfo("I'm clicking on: " + dashboard, true);
    }



    @Then("I verify Like Button is displayed")
    public void i_verify_like_button_is_displayed() {
        for (int i = 0; i < 5; i++) {
            context.selenium_utils.click(context.tla11LikeButtonPage.questions.get(i));
            context.selenium_utils.sleep(500);
            if (context.tla11LikeButtonPage.answers.size()> 0) {
                Assert.assertTrue(context.tla11LikeButtonPage.likeButton.get(0).isDisplayed());
                context.selenium_utils.logInfo("I'm verifying likeButton is displayed: ", true);
            }
        }
    }
    @Then("I verify Like Button is clickable")
    public void i_verify_like_button_is_clickable() {
        for (int i = 0; i < 5; i++) {
            context.selenium_utils.click(context.tla11LikeButtonPage.questions.get(i));
            context.selenium_utils.sleep(1000);
            if (context.tla11LikeButtonPage.answers.size()> 0) {
                Assert.assertTrue(context.tla11LikeButtonPage.likeButton.get(0).isEnabled());
                context.selenium_utils.logInfo("I'm verifying likeButton is clickable: ", true);
            }
        }
    }

    @Then("I verify that numbers are changing")
    public void i_verify_that_numbers_are_changing() {
        for (int i = 0; i < 5; i++) {
            context.selenium_utils.click(context.tla11LikeButtonPage.questions.get(i));
            context.selenium_utils.sleep(1000);
            if (context.tla11LikeButtonPage.answers.size() > 0) {
                String likeNumber = context.tla11LikeButtonPage.likeNumber.get(0).getText();
                context.selenium_utils.click(context.tla11LikeButtonPage.likeButton.get(0));
                Assert.assertTrue(context.tla11LikeButtonPage.likeNumber.get(0).getText() != likeNumber);
                context.selenium_utils.logInfo("I'm verifying that numbers are changing: ", true);
            }
        }
    }
}

