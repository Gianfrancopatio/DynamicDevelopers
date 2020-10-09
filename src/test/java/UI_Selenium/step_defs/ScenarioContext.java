package UI_Selenium.step_defs;

import UI_Selenium.pages.*;
import UI_Selenium.ui_utils.Selenium_utils;
import common_utils.ConfigReader;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ScenarioContext {
    public Scenario scenario;
    public WebDriver driver;

    //Classes
    public LogInPage logInPage;
    public Selenium_utils selenium_utils;
    public DosDontsTablePage dosDontsTablePage;
    public SessionExpiresPage sessionExpiresPage;
    public DosnDontsStatementsPage dosnDontsStatementsPage;

    public LikeButtonPage likeButtonPage;

    public TLA11_LikeButtonPage tla11LikeButtonPage;

    public TLA_6_AllTopicsPage allTopicsPage;



    //Selenium methods
    public void initializeClasses(ScenarioContext scenarioContext) {
        logInPage = new LogInPage(driver);
        selenium_utils = new Selenium_utils(scenarioContext);
        dosDontsTablePage = new DosDontsTablePage(driver);
        sessionExpiresPage = new SessionExpiresPage(driver);
        dosnDontsStatementsPage = new DosnDontsStatementsPage(driver);
        likeButtonPage = new LikeButtonPage(driver);
        allTopicsPage = new TLA_6_AllTopicsPage(driver);
        dosnDontsStatementsPage = new DosnDontsStatementsPage(driver);
        likeButtonPage = new LikeButtonPage(driver);

        tla11LikeButtonPage = new TLA11_LikeButtonPage(driver);

    }

//    //API
//    public RequestSpecification request;
//    public Response response;
//    public Headers headers;
//    public JSONObject jsonObject;

    public void initializeDriver() {
        if (driver == null) {
            switch (ConfigReader.readProperty("browser", "src/test/resources/properties/configuration.properties")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser type");
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    //API Methods
//    public String getResponseBody(){
//        return response.getBody().asString();
//    }
//
//    public int getStatusCode(){
//        return response
//                .getStatusCode();
//    }
//
//    public String getResponseID(){
//        return response.body().jsonPath().getString("_id");
//    }

}
