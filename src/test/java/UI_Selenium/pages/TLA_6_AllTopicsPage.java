package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TLA_6_AllTopicsPage {
    public TLA_6_AllTopicsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[text()='All Topics']")
    public WebElement alltopics_dash;

    @FindBy(xpath = "//a[contains(@href, ':')]")
    public List<WebElement> questions;

    @FindBy(css = ".answer-count.ml-5")
    public List<WebElement> answerCount;

    @FindBy(css = "div.answer-section")
    public WebElement answerSection;

    @FindBy(xpath = "//div[@class='row answer']")
    public List<WebElement> answerRows;

    @FindBy(css = "div.row.answer")
    public WebElement answerRow;

    @FindBy(xpath = "//div[@class='logo']")
    public WebElement logoBtn;

    @FindBy(xpath = "//*[contains(@placeholder, 'Your Answer')]")
    public WebElement answerForm;

    @FindBy(css = ".form-control")
    public WebElement questionForm;

    @FindBy(linkText = "Test 321")
    public WebElement linkQuestion;

    public static String questionXpath = "//p[contains(text(),'%s')]";






}
