package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {


    public static WebDriver driver;
    protected HomePage homePage;


    String baseURL = "https://www.amazon.com";

    @BeforeMethod
    public void goHome() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


}
