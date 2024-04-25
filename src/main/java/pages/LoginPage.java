package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By submitButton = By.cssSelector(".space-y-2 button");
    private By wrongEmailMessage = By.cssSelector(".space-y-2 p");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submit(){
        driver.findElement(submitButton).click();
    }

    public String getWrongEmailMessage(){
        return driver.findElement(wrongEmailMessage).getText();
    }

}
