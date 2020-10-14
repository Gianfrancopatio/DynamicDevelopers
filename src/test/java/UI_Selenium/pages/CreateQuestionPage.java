package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateQuestionPage {

    public CreateQuestionPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[text()='Coding']")
    public WebElement SelectCoding;


    @FindBy(xpath = "//button[@class='btn btn-warning badge-pill newbtn']")
    public WebElement clickButton;

    @FindBy(xpath = "//textarea[@class='form-control']")
    public WebElement EnterQA;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement click_enter;

    @FindBy(xpath = "//div[@class='question-date']")
    public WebElement DisplayStamp;
}
