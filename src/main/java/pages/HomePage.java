package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By authenticationLink = By.linkText("Σύνδεση / Εγγραφή");
    private By searchBar = By.id("main-search");
    private By contactLink = By.cssSelector("[href=\"https://www.mymarket.gr/contact\"]");
    private By productsMenu = By.cssSelector(".menu-toggle-desktop span");
    private By dairy = By.cssSelector("[href='https://www.mymarket.gr/galaktokomika-eidi-psygeiou']");
    private By milk = By.cssSelector("[href=\"https://www.mymarket.gr/gala\"]");
    private Actions actions;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public LoginPage clickAuthenticationLink(){
        driver.findElement(authenticationLink).click();
        return new LoginPage(driver);
    }

    public ResultsPage searchFor(String product){
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPage(driver);
    }

    public ContactPage getContactPage(){
        driver.findElement(contactLink).click();
        return new ContactPage(driver);
    }

    public MilkPage getMilkPage(){
        moveToProductsMenu();
        moveToDairyMenu();
        wait.until(ExpectedConditions.visibilityOfElementLocated(milk));
        actions.moveToElement(driver.findElement(milk)).click().perform();
        return new MilkPage(driver);
    }

    private void moveToProductsMenu(){
        actions.moveToElement(driver.findElement(productsMenu)).perform();
    }

    private void moveToDairyMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dairy));
        actions.moveToElement(driver.findElement(dairy)).perform();
    }

}
