package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By authenticationLink = By.linkText("Σύνδεση / Εγγραφή");
    private By searchBar = By.id("main-search");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickAuthenticationLink(){
        driver.findElement(authenticationLink).click();
        return new LoginPage(driver);
    }

    public ResultsPage searchFor(String product){
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPage(driver);
    }
}
