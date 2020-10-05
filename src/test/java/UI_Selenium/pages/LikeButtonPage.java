package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LikeButtonPage {
    public LikeButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="//span[@class='badge badge-success']")
    public WebElement likeBtn;

      @FindBy (xpath ="(//span[@class='badge badge-success'])[27]")
    public WebElement likeBtn2;

}
