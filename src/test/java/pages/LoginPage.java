package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Elements

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginButton = By.cssSelector("button[type='submit']");
    By registrationLink = By.cssSelector("a[href='registration']");

    //Helper methods

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        findElement(loginButton).click();
    }
    public void clickRegistrationLink() {
        findElement(registrationLink).click();
    }
    public void login() {
        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginButton();



    }



}
