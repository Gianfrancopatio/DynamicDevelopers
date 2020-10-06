package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardView {
    public DashBoardView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/input[@class='form-control']")
    public WebElement newDashboardadd;

    @FindBy(xpath="")
    public WebElement addBtn;
}
