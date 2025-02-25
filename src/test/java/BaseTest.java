import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public String url;
    WebDriverWait wait;
    Actions actions;

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
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        //      Added ChromeOptions argument below to fix websocket error
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
       // driver = new ChromeDriver(options);
        //driver = new SafariDriver();
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        url=baseURL;
        actions = new Actions(driver);
        navigateToPage();
    }
   @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void clickLoginBtn() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage() {
        driver.get(url);
    }

public static WebDriver pickBrowser(String browser) throws MalformedURLException {

    DesiredCapabilities caps = new DesiredCapabilities();
    String gridURL = "http://192.168.0.28:4444";
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions= new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "safari" :
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
                // Grid related browsers
            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-safari":
                caps.setCapability("browserName","safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions= new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver= new ChromeDriver(chromeOptions);

        }
}

}
