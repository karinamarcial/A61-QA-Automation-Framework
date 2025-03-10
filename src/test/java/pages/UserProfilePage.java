package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class UserProfilePage extends BasePage{
    public UserProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Elements
    By saveButton = By.cssSelector("button[class='btn-submit']");
    By profileName = By.cssSelector("[name='name']");
    By currentPasswordField = By.cssSelector("[name='current_password']");
    By avatarIcon = By.cssSelector("img.avatar");
    By actualProfileName = By.cssSelector("a.view-profile>span");
    By violetTheme = By.cssSelector("div[data-testid='theme-card-violet']");
    By violetBackground = By.cssSelector(".mac.with-extra-panel");



    //Methods

    public void clickOnSaveButton() {
        findElement(saveButton).click();
    }

    public void provideProfileName(String randomName) {
        findElement(profileName).clear();
        findElement(profileName).sendKeys(randomName);
    }


    public void provideCurrentPassword(String currentPassword) {
        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(currentPassword);

    }

    public void clickOnAvatarIcon() {
       findElement(avatarIcon).click();
    }

    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-","");

    }

    public String getActualProfileName() {
        return findElement(actualProfileName).getText();
    }

    public void chooseVioletTheme() {
        findElement(violetTheme).click();
    }

    public boolean isVioletThemeIsDisplayed() {
        return findElement(violetBackground).isDisplayed();
    }
}
