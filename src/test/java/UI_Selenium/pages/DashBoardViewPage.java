package UI_Selenium.pages;

import UI_Selenium.step_defs.ScenarioContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardViewPage {
    public DashBoardViewPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div/input[@class='form-control']")
    public WebElement newDashboardAdd;

    @FindBy(xpath="//button[@class='btn btn-primary mb-2']")
    public WebElement addBtn;

    @FindBy(xpath="//button/img")
    public List <WebElement> dash;

    @FindBy(xpath = "//button[@class ='btn btn-light mb-2 border shadow-lg rounded']")
    public List<WebElement> topicName;

    @FindBy(xpath=" //div[contains(text(),'already exists')]")
    public WebElement errorExist;

    public boolean verifyimageActive(WebElement imgElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() != 200)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }






}
