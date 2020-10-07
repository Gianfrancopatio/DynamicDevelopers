package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LikeButtonPage {
    public LikeButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email12;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password12;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signIn12;

    @FindBy (xpath ="//span[@class='badge badge-success']")
    public WebElement likeBtn;

      @FindBy (xpath ="(//span[@class='badge badge-success'])[40]")
    public WebElement likeBtn2;

}
