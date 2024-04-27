package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MilkPage {

    private WebDriver driver;
    private By header1 = By.tagName("h1");

    public MilkPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getH1Text(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(header1));
        return driver.findElement(header1).getText();
    }
}
