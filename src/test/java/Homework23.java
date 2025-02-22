import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pages.BasePage;

public class Homework23 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        HomePageFactory homePageFactory= new HomePageFactory(driver);
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);

        loginPageFactory.provideEmail("karina.usmanova01@testpro.io");
        loginPageFactory.providePassword("YrEdlRVe");
        loginPageFactory.clickLoginButton();
        Thread.sleep(2000);
        homePageFactory.playNextSong();
        homePageFactory.clickPlayButton();
        Assert.assertTrue(homePageFactory.pauseBtnIsDisplayed());
       // WebElement pauseBtn = driver.findElement(By.xpath("//span[@class='pause']//i[@class='fa fa-pause']"));
       // Assert.assertTrue(homePageFactory.pauseBtn.isDisplayed());
    }




}
