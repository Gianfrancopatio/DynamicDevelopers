package UI_Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardViewTest {
    public DashBoardViewTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/input[@class='form-control']")
    public WebElement newDashboardAdd;

    @FindBy(xpath="//button[@class='btn btn-primary mb-2']")
    public WebElement addBtn;

    @FindBy(xpath="//button/img")
    public List <WebElement> Dash;



}
