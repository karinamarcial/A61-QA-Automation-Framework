package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

   // @Given("I have browser opened")
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notification");
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @And("Login Page is opened")
    public void loginPageIsOpened() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @Then("I should not get logged in")
    public void iShouldNotGetLoggedIn() {
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    @When("I click on registration link")
    public void iClickOnRegistrationLink() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();


    }

    @Then("I should be redirected to registration page")
    public void iShouldBeRedirectedToRegistrationPage() {
        String urlRegistration = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),urlRegistration);
    }
}
