import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void registrationNavigation(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickRegistrationLink();
        String urlRegistration = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),urlRegistration);

    }

    @Test
    public void loginEmptyEmailPassword() {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    @Test
    public void loginValidEmailPassword () {

       navigateToPage();
       provideEmail("karina.usmanova01@testpro.io");
       providePassword("YrEdlRVe");
       clickLoginBtn();

       WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
       Assert.assertTrue(avatarIcon.isDisplayed());


    }


    @Test
    public void loginInvalidEmailOrPassword () throws InterruptedException {
        //preconditions (launch browser which is in base test @beforemothod)

        //step1: Open browser
        navigateToPage();

        //step2: Enter wrong email
        provideEmail("arina.usmanova01@testpro.io");

        //step3: enter password
        providePassword("YrEdlRVe");

        //step4: click login button
        clickLoginBtn();

        //step5: expected vs actual result
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    //Login test using Page Object Model
    @Test
    public void positiveLoginTest(){
        //Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmail("karina.usmanova01@testpro.io");
        loginPage.providePassword("YrEdlRVe");
        loginPage.clickLoginButton();
        //or loginPage.login(); will do the same as these 3 lines
        //Expected vs Actual
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test(dataProvider = "loginNegativeTestData")
    public void negativeLoginTests(String email, String password){
        //Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Steps
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
}
