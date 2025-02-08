import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

@Test
public void changeProfileName () throws InterruptedException {

    //Login to Koel
    //click on avatar icon to navigate to profile
    //Generate random name for profile
    //provide current password
    //provide new generated name
    //click on save button
    //Assertions (actual vs expected)

    navigateToPage();
    provideEmail("karina.usmanova01@testpro.io");
    providePassword("YrEdlRVe");
    clickLoginBtn();
    Thread.sleep(2000);

    clickOnAvatarIcon();
    Thread.sleep(2000);

    String randomName = generateRandomName();
    System.out.println(randomName);
    Thread.sleep(2000);

    provideCurrentPassword("YrEdlRVe");
    Thread.sleep(2000);

    provideProfileName(randomName);
    Thread.sleep(2000);

    clickOnSaveButton();
    Thread.sleep(2000);

    WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
    Assert.assertEquals(actualProfileName.getText(), randomName);
    Thread.sleep(2000);
}

    public void clickOnSaveButton() {
    WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn-submit']"));
    saveButton.click();
    }

    public void provideProfileName(String newProfileName) {
    WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
    profileName.clear();
    profileName.sendKeys(newProfileName);
    }

    public void provideCurrentPassword(String currentPassword) {
    WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
    currentPasswordField.clear();
    currentPasswordField.sendKeys(currentPassword);
    }

    public void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public String generateRandomName () {
        return UUID.randomUUID().toString().replace("-","");

        }


}
