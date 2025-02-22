package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPageFactory extends BasePage {
    public LoginPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Factory Elements

    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;

    //Helper methods
    public LoginPageFactory provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPageFactory providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPageFactory clickLoginButton(){
        loginButton.click();
        return this;
    }
}
