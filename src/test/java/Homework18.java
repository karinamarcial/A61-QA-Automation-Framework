import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

@Test
public void playSong() throws InterruptedException {
    //navigateToPage();
    provideEmail("karina.usmanova01@testpro.io");
    providePassword("YrEdlRVe");
    clickLoginBtn();
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
