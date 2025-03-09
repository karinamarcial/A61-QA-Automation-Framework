import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.LoginPageFactory;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


    //Login test using Page Object Model
    @Test
    public void positiveLoginTest() {
        //Objects
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //Steps
        loginPage.provideEmail("karina.usmanova01@testpro.io");
        loginPage.providePassword("YrEdlRVe");
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test(dataProvider = "loginNegativeTestData")
    public void negativeLoginTests(String email, String password) {
        //Objects
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Steps
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test
    public void registrationNavigation() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.clickRegistrationLink();
        String urlRegistration = "https://qa.koel.app/registration";
        Assert.assertEquals(getDriver().getCurrentUrl(), urlRegistration);

    }

  /*  @Test
    public void positiveLoginTestUsingPageFactory() {
        //Objects
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPageFactory.provideEmail("karina.usmanova01@testpro.io")
                        .providePassword("YrEdlRVe")
                        .clickLoginButton();
        //or loginPage.login(); will do the same as these 3 lines
        //Expected vs Actual
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }*/
}