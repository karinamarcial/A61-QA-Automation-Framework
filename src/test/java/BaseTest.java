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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public WebDriver driver;
    public String url;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    //public WebDriverWait wait;
    //public Actions actions;

    public static WebDriver getDriver(){
        return threadDriver.get();
    }


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
       // WebDriverManager.chromedriver().setup();
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
        //driver = pickBrowser(System.getProperty("browser"));
        //driver.manage().window().maximize();
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        url=baseURL;
        //actions = new Actions(driver);
        navigateToPage(url);
    }
  /* @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }*/
    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
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

    public void navigateToPage(String url) {
        //driver.get(url);
        getDriver().get(url);
    }

public WebDriver pickBrowser(String browser) throws MalformedURLException {

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
            case "cloud":
                return lambdaTest();


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions= new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver= new ChromeDriver(chromeOptions);

        }
}

public WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("122.0");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", "kwork.usmanova");
    ltOptions.put("accessKey", "LT_QTzscTF2J0SNh07DKwIO7SX4xrCpbgV6Or9RHeHtemyw0zU");
    ltOptions.put("project", "Koel");
    ltOptions.put("build", "Koel");
    ltOptions.put("w3c", true);
    browserOptions.setCapability("LT:Options", ltOptions);
    //return new RemoteWebDriver(new URL(hubURL), browserOptions);

    return new RemoteWebDriver(URI.create(hubURL).toURL(), browserOptions);



}

}


