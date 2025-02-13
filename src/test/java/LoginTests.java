import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    String url = "https://qa.koel.app/";



    @Test (dataProvider = "loginNegativeTestData")
    public void loginNegativeTest(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //navigateToPage();
        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginBtn();


        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        // or "img[class='avatar']"
        Assert.assertTrue(avatarIcon.isDisplayed());
        Thread.sleep(2000);

    }


    @Test
    public void loginInvalidEmailOrPassword() throws InterruptedException {
        //preconditions (launch browser which is in base test @beforemothod)

        //step1: Open browser
        //navigateToPage();


        //step2: Enter wrong email
        provideEmail("arina.usmanova01@testpro.io");
        Thread.sleep(2000);

        //step3: enter password
        providePassword("YrEdlRVe");
        Thread.sleep(2000);

        //step4: click login button
        clickLoginBtn();
        Thread.sleep(2000);

        //step5: expected vs actual result
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000);
    }



    }

