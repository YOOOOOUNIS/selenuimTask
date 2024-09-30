package Pages;

import Utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.Helper.explicitWait;

public class HomePage {


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchElement = By.id("twotabsearchtextbox");


    public ProductsPage sendkeysToSearchElement() {

        explicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchElement));
        driver.findElement(searchElement).sendKeys("monitors");

        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();

        return new ProductsPage(driver);

    }

}
