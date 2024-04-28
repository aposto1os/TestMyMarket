package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ContactPage {

    private WebDriver driver;
    private By fullNameField = By.id("full_name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By messageField = By.id("message");
    private By subjectDropdown = By.id("subject");
    private By uploadFileField = By.id("files");
    private By uploadedFileName = By.cssSelector("ul>li>span:nth-child(2)");


    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFullNameField(String fullName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField));
        driver.findElement(fullNameField).sendKeys(fullName);
    }

    public String getFullNameField(){
        return driver.findElement(fullNameField).getAttribute("value");
    }

    public void selectFromDropdown(String selection){
        findDropdown().selectByVisibleText(selection);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedOptions = findDropdown().getAllSelectedOptions();
        List<String> selectedOptionsAsStrings = new ArrayList<>();
        for (WebElement option: selectedOptions) {
            selectedOptionsAsStrings.add(option.getText());
        }
        return selectedOptionsAsStrings;
    }

    public void uploadFile(String path){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadFileField));
        driver.findElement(uploadFileField).sendKeys(path);
    }

    public String getUploadedFileName(){
        return driver.findElement(uploadedFileName).getText();
    }

    private Select findDropdown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectDropdown));
        return new Select(driver.findElement(subjectDropdown));
    }
}
