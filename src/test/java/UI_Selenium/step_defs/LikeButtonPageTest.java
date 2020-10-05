package UI_Selenium.step_defs;

import io.cucumber.java.en.When;

public class LikeButtonPageTest {
    ScenarioContext context;

    public LikeButtonPageTest(ScenarioContext scenarioContext) {
        context = scenarioContext;
    }

    @When("I like a statement in the Do's table I verify the like button works properly")
    public void i_like_a_statement_in_the_do_s_table_i_verify_the_like_button_works_properly() {
        context.selenium_utils.waitForClickability(context.likeButtonPage.likeBtn);
    }

    @When("the Don't table as well")
    public void the_don_t_table_as_well() {
        context.selenium_utils.waitForClickability(context.likeButtonPage.likeBtn2);
    }


}
