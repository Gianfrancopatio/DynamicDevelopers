package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TLA11_LikeButtonPage {
    public TLA11_LikeButtonPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='All Topics']")
    public WebElement alltopicsDash;

    @FindBy(xpath = "//div[@class='col-md-8']//a")
    public List <WebElement> questions;

    @FindBy(xpath = "//p[@class='col-md-10']")
    public List <WebElement> answers;

    @FindBy(xpath = "//span[@class='badge badge-primary']")
    public List <WebElement> likeButton;

    @FindBy(xpath = "//span[@class='badge badge-primary']")
    public List <WebElement> likeNumber;
}

