import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework18 extends BaseTest{

@Test
public void playSong() throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());

    loginPage.provideEmail("karina.usmanova01@testpro.io");
    loginPage.providePassword("YrEdlRVe");
    loginPage.clickLoginButton();
    Thread.sleep(2000);

    playNextSong();
    Thread.sleep(2000);
    clickPlayButton();
    Thread.sleep(2000);
    WebElement pauseBtn = driver.findElement(By.xpath("//span[@class='pause']//i[@class='fa fa-pause']"));
    Assert.assertTrue(pauseBtn.isDisplayed());
}

    public void clickPlayButton() {
    WebElement playButton = driver.findElement(By.xpath("//span[@class='play']//i[@class='fa fa-play']"));
    playButton.click();
    }

    public void playNextSong() {
        WebElement nextSong = driver.findElement(By.xpath("//i[@class='next fa fa-step-forward control']"));
        nextSong.click();
    }
}
