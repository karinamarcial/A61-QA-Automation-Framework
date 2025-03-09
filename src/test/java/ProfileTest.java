import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserProfilePage;

import java.util.UUID;

public class ProfileTest extends BaseTest {

@Test
public void changeProfileName () throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());
    UserProfilePage userProfilePage = new UserProfilePage(getDriver());

    //Steps
    //Login to Koel
    //click on avatar icon to navigate to profile
    //Generate random name for profile
    //provide current password
    //provide new generated name
    //click on save button
    //Assertions (actual vs expected)


    loginPage.provideEmail("karina.usmanova01@testpro.io");
    loginPage.providePassword("YrEdlRVe");
    loginPage.clickLoginButton();
    Thread.sleep(2000);

    userProfilePage.clickOnAvatarIcon();

    String randomName = userProfilePage.generateRandomName();
    System.out.println(randomName);

    userProfilePage.provideCurrentPassword("YrEdlRVe");

    userProfilePage.provideProfileName(randomName);

    userProfilePage.clickOnSaveButton();
    Thread.sleep(2000);

    Assert.assertEquals(userProfilePage.getActualProfileName(),randomName);

}

}
