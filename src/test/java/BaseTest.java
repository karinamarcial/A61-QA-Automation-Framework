import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public String url;

    @DataProvider (name = "loginNegativeTestData")
    public Object [][] getDataFromDataProvider() {
        return new Object[][] {
                {"arina.usmanova01@testpro.io","123456"},
                {"karina.usmanova01@testpro.io","123456"},
                {"",""},
                {"arina.usmanova01@testpro.io","YrEdlRVe"},
        };
    }




    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url=baseURL;
        navigateToPage();
    }
   @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void clickLoginBtn() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage() {
        driver.get(url);
    }
}