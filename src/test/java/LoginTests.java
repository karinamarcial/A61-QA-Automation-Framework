import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

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
}
