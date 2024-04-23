package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By authenticationLink = By.linkText("Σύνδεση / Εγγραφή");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickAuthenticationLink(){
        driver.findElement(authenticationLink).click();
        return new LoginPage(driver);
    }
}
