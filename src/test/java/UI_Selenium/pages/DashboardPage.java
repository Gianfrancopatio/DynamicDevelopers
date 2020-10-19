package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

        public DashboardPage (WebDriver driver) {

            PageFactory.initElements(driver, this);
        }

    /**
     * TlA-6 All Topics dash
     * @author: Muneer
     */
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

    /**
     * CreateQuestion- TLA 7 -Juan
     */

    @FindBy(xpath = "//button[text()='Coding']")
    public WebElement SelectCoding;


    @FindBy(xpath = "//button[@class='btn btn-warning badge-pill newbtn']")
    public WebElement clickButton;

   @FindBy(xpath = "//textarea[@id='question']")
   public WebElement EnterQA;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement click_enter;

    @FindBy(xpath = "//div[@class='question-date']")
    public WebElement DisplayStamp;
        // add your page below dont forget to comment with yourname
}



