package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mymarket.gr/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.clickAuthenticationLink();
        //driver.quit();
    }

    public static void main(String[] args) {
        BaseTests baseTests = new BaseTests();
        baseTests.setup();

    }
}
